package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {

	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	IUserService service;
	@Before
	public void setup() {
		service = new UserService();
		logger.debug("setup");

	}
	
	@Test
	public void userListTest() {
		
		
		/***Given***/
		

		/***When***/
		List<UserVo> userList= service.userList();
		/***Then***/
		assertEquals(105, userList.size());
		logger.debug("userList : {}", userList);

	}
	
	
	@Test
	public void getUserTest() {
		
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVo vo= service.getUser(userId);
		/***Then***/
		
		assertEquals(userId, vo.getUserId());
		logger.debug("getUser : {}", vo);

	}

}
