package kr.or.ddit.locale;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/selectLocale")
public class SelectLocaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = request.getParameter("language");
		System.out.println(language);
		if(language==null||language.equals(""))
			language="ko";
		request.setAttribute("language",language);
		request.getRequestDispatcher("/jstl/selectLocation.jsp").forward(request, response);;
		

	}

}
