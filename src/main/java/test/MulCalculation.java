package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/jsp/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory
			.getLogger(MulCalculation.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		int result = Integer.parseInt(param1)*Integer.parseInt(param2);
		logger.debug(Integer.toString(result));
		
		request.getSession().setAttribute("mulResult", result);
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
		
		
	}

}
