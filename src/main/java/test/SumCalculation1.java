package test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/sumCalculation")
public class SumCalculation1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(SumCalculation1.class);   
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int result=0;
		
		for(int i=Integer.parseInt(start); i<=Integer.parseInt(end);i++){
			result += i;
		}
		logger.debug(Integer.toString(result));
		
		request.getSession().setAttribute("sumResult", result);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);;
		
	
	}

}
