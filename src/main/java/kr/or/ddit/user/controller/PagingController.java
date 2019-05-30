package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

@WebServlet("/userPagingList")
public class PagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * int page = 1; int pageSize =10;
		 * 
		 * if(request.getParameter("page")!=null||request.getParameter("pageSize"
		 * )!=null){ page = Integer.parseInt(request.getParameter("page"));
		 * pageSize = Integer.parseInt(request.getParameter("pageSize")); }
		 */

		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);

		PageVo pageVo = new PageVo(page, pageSize);

		// pageVo를 이용한 사용자 페이징 리스트 조회
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");

		// requset scope에서 사용자 리스트를 공유할 수 있도록 속성 설정
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);

		// 화면 출력을 담당하는 jsp에게 역할 위임
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
	}

}
