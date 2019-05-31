package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
@WebServlet("/userModify")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
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
		request.setAttribute("userInfo", vo);
		
		
		String name = request.getParameter("name");
		
		
		String alias = request.getParameter("alias");
		
		
		String addr1 = request.getParameter("addr1");
		
		
		String addr2 = request.getParameter("addr2");
		
		
		String zipcd = request.getParameter("zipcd");
		
		
		String birth = request.getParameter("birth");
		
		
		String pass = request.getParameter("pass");
		

		
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
			int insertCnt=userService.updateUser(userVo);
			//정상등록된경우
			if(insertCnt==1)
				response.sendRedirect(request.getContextPath()+"/user?userId="+userId);
			if(request.getAttribute("msg")!=null)
				request.removeAttribute("msg");
				
		}else{
			//request.getRequestDispatcher("/userForm").forward(request, response); -->위의 doGet메서드 호출
			request.setAttribute("msg", "수정에 실패했습니다.");
			doGet(request, response);
		}
		
	}

}
