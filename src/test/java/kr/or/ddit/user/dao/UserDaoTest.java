package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.LprodVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoTest.class);
	private IUserDao userDao;
	private ILprodDao lprodDao;

	// junit 실행순서
	// @BeforeClass가 적용된 메서드가 최초 1회 실행

	// 다음 구간은 @Test가 적용된 모든 메서드에 대해 반복적용
	// @Before가 적용된 메서드 실행
	// @Test가 적용된 메서드 실행
	// @After가 적용된 메서드 실행

	// @AfterClass가 적용된 메서드 실행
	@BeforeClass
	public static void beforeClass() {
		logger.debug("beforeClass");
	}

	@Before
	public void setup() {
		userDao= new UserDao();
		lprodDao= new LprodDao();
		logger.debug("setup");

	}

	@After
	public void teardown() {
		logger.debug("teardown");

	}

	@AfterClass
	public static void afterClass() {
		logger.debug("afterClass");

	}

	/**
	 * Method : userListTest 작성자 : PC24 변경이력 : Method 설명 : 사용자 전체 조회 테스트
	 */
	@Test
	public void userListTest() {
		// 테스트
		/*** Given ***/

		/*** When ***/
		List<UserVo> userList = userDao.userList();

		/*** Then ***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		logger.debug("userList : {}", userList);
	}

	@Test
	public void getUserTest() {
		// 테스트
		/*** Given ***/
		String userId = "brown";

		/*** When ***/
		UserVo userVo = userDao.getUser(userId);

		/*** Then ***/
		assertEquals("브라운", userVo.getName());
		logger.debug("getUser : {}", userVo);
	}
	
	
	//사용자 페이징리스트 조회
	//고려사항
	//몇번째 페이지 조회인지?, 페이징 몇건씩 데이터를 보여줄건지 : 쿼리 실행 파라미터
	
	//정렬순서 ? 로직 --> 파라미터화 시킬 수 있다.
	//-->사용자 아이디 순으로 정렬
	
	
	/**
 	 * Method : userPagingListTest
	 * 작성자 : PC24
	 * 변경이력 :
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		
		List<UserVo> userList = userDao.userPagingList(pageVo);

		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
	}
	
	
	/**
	* Method : userCntTest
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 사용자 전체수 조회 테스트
	*/
	@Test
	public void usersCntTest() {
		/***Given***/
		

		/***When***/
		int usersCnt = userDao.usersCnt();
		
		
		/***Then***/
		assertEquals(105, usersCnt);

	}
	
	
	@Test
	public void prodListTest(){
		List<LprodVo> lprodList = lprodDao.lprodPagingList(new PageVo(1,5));
		
		assertNotNull(lprodList);
		assertEquals(5, lprodList.size());
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
		int inserCnt = userDao.insertUser(userVo);
		

		/***Then***/
		//insertCnt();
		assertEquals(1, inserCnt);
		
		//data삭제 
		userDao.deleteUser(userVo.getUserId());
		
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
		int updateCnt = userDao.updateUser(userVo);
		

		/***Then***/
		//insertCnt();
		assertEquals(1, updateCnt);
		
		
	}
	
	

}
