package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;
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
	
	
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		
		Map<String, Object> resultMap = service.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (int) resultMap.get("paginationSize");

		/***Then***/
		//pagingLiost assert
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		//paginationSize assert
		assertEquals(11, paginationSize);
	}
	
	
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		/***Then***/
		logger.debug("paginationSize : {}", paginationSize);
		
		assertEquals(11, (int)paginationSize);
		

	}

}
