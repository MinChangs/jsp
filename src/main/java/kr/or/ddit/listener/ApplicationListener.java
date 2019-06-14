package kr.or.ddit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//contextPath -> js, css 경로 설정
//${pageContext.requset.contextPath}/js/jquery.js
//application cp 속성에 contextPath값을 넣어주면
//${cp}/js/jquery.js
public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("cp", sce.getServletContext().getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
