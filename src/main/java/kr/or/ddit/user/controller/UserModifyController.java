package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;
@WebServlet("/userModify")
@MultipartConfig(maxFileSize=1024*1024*3 , maxRequestSize=1024*1024*15)
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);
    
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		UserVo userVo = userService.getUser(userId);
		request.setAttribute("userInfo", userVo);
		
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
//		UserVo vo = (UserVo) request.getAttribute("userInfo");
//		String userId = request.getParameter(vo.getUserId());
		
		//
		String userId= request.getParameter("userId");
		
		UserVo vo = userService.getUser(userId);
//		request.setAttribute("userInfo", vo);
		
		
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");

		//사용자가 보낸 평문 비밀번호 데이터
		String pass = request.getParameter("pass");
		pass = KISA_SHA256.encrypt(pass);
		logger.debug(vo.getPath());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = null ;
		try {
			userVo = new UserVo(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 업데이트하기위해 사용자 userId가 존재하는지  체크
		UserVo dbUser =userService.getUser(userId);
		//등뢱된 사용자가 아닌경우 --> 정상입력이 가능한 상황
		if(dbUser!=null){
			Part profile = request.getPart("profile");
			
			if(profile.getSize()>0){
				String contentDisposition = profile.getHeader("content-disposition");
				String fileName= PartUtil.getFileName(contentDisposition);
				String ext = PartUtil.getExt(fileName);
				
				String uploadPath= PartUtil.getUploadPath();
				File uploadFolder = new File(uploadPath);
				

				if (uploadFolder.exists()) {
					String filePath= uploadPath + File.separator + UUID.randomUUID().toString()+ext;
			
					userVo.setPath(filePath);
					userVo.setFilename(fileName);
						
				
					profile.write(filePath);
					profile.delete();// 임시저장공간에 만약 찌거기가 남아있으면 지우기 위해 호출
				}
			}else{
				
				userVo.setPath(vo.getPath());
				userVo.setFilename(vo.getFilename());
				
			}
			
			
			int insertCnt=userService.updateUser(userVo);
			//정상등록된경우
			if(insertCnt==1)
				request.setAttribute("msg", "수정에 성공했습니다.");
				response.sendRedirect(request.getContextPath()+"/user?userId="+userId);
		
			
				
		}else{
			//request.getRequestDispatcher("/userForm").forward(request, response); -->위의 doGet메서드 호출
			request.setAttribute("msg", "수정에 실패했습니다.");
			doGet(request, response);
		}
		
	}

}
