package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	
	/**
	* Method : insertUserTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	*/
	@Test
	public void insertUserTest(){
		/***Given***/
		//사용자 정보를 담고 있는 vo 객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = null;
		try {
			 userVo = new UserVo("대덕인", "userTest","중앙로","userTest1234","대전광역시 중구 중알로76","영민빌딩 2층 204호","34940",sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/***When***/
		//userDao.insertUser();
		int inserCnt = service.insertUser(userVo);
		

		/***Then***/
		//insertCnt();
		assertEquals(1, inserCnt);
		
		//data삭제 
		service.deleteUser(userVo.getUserId());
		
	}
	
	
	@Test
	public void updateUserTest(){
		/***Given***/
		//사용자 정보를 담고 있는 vo 객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = null;
		try {
			 userVo = new UserVo("대덕인", "userTest","중앙로","userTest1234","대전광역시 중구 중알로76","영민빌딩 2층 204호","34940",sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/***When***/
		//userDao.insertUser();
		int updateCnt = service.updateUser(userVo);
		

		/***Then***/
		//insertCnt();
		assertEquals(1, updateCnt);
		
		
	}

}
