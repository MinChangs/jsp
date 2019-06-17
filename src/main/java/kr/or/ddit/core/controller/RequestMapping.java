package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;
import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IdbService;

public class RequestMapping {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	
	//main.do -> MainController
	//userList.do -> UserController
//	private static Map<String, String>requestMappingClass;
	private static Map<String, Controller> requestMapping;
	private static IdbService dbService = new DbService();
	
	static {
		List<DbVo>uriClassMappingList =  dbService.getUriMappingList();

		requestMapping =  new HashMap<String, Controller>();
		
		
		for(DbVo vo : uriClassMappingList){
			//classInfo : "kr.or.ddit.controller.MainController"
			String classInfo=vo.getClassname();
			
			try {
				Class clazz = Class.forName(classInfo);
				Object obj=clazz.newInstance();
				requestMapping.put(vo.getUri(), (Controller)obj);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
		/*
		
		
		requestMappingClass = new HashMap<String, String>();
		requestMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");
		//		requestMappingClass.put("/main.do", "kr.or.ddit.controller.UserListController");
		
		for(String key : requestMappingClass.keySet()){
			//classInfo : "kr.or.ddit.controller.MainController"
			String classInfo=requestMappingClass.get(key);
			
			try {
				Class clazz = Class.forName(classInfo);
				Object obj=clazz.newInstance();
				requestMapping.put(key, (Controller)obj);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		*/

		
		
		
//		requestMapping.put("/main.do", new MainController());
//		requestMapping.put("/userList.do", new UserListController());
	}
	public static Controller getController(String uri) {
		logger.debug("getController : {} ", uri);
		return requestMapping.get(uri);
	}

}
