package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicGugudan extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		// localhost/jsp//timeServlet?param=6
		String param = req.getParameter("i");
		String param2 = req.getParameter("j");
		System.out.println("param : " +param);
		System.out.println("param2 : " +param2);
		
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title> Hello, World  </title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("	<table border='1'>");
		for(int i=1; i<=Integer.parseInt(param2); i++){
			pw.write("	<tr>");
			for(int j=2; j<=Integer.parseInt(param); j++ ){
				pw.write("	<td>"+j+" * "+i+" = "+i*j+"</td>");
				
			}
			pw.write("	</tr>");
			
		}
		pw.write("	</table>");
		
		pw.write("	</body>");
		pw.write("</html>");
		pw.close();
		
	}

}
