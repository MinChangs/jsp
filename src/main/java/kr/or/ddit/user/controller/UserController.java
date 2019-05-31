package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IUserService userService;
	@Override
	public void init() throws ServletException {
		userService= new UserService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// requset객체로부터 사용자 아이디 파라미터획득
		String userId = request.getParameter("userId");
		//사용자 아이디로 사용자 정보를 조회
		UserVo userVo = userService.getUser(userId);
		//조회 결과를 request객체에 속성으로 저장
		request.setAttribute("userInfo", userVo);
		//화면을 담당하는 /user/user.jsp로 foward
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);
		
	}


}
