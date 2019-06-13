package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService implements IUserService {

	IUserDao dao;
	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
	public UserService() {
		dao = new UserDao();
	}

	/**
	 * 
	 * Method : userList 작성자 : PC24 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVo> userList() {
		// controller -> service -> dao
		// db에서 데이터를 조회했다고 가정

		return dao.userList();
	}

	/**
	 * Method : getUser 작성자 : PC24 변경이력 :
	 * 
	 * @param userId
	 * @return Method 설명 : 사용자 정보
	 */
	@Override
	public UserVo getUser(String userId) {

		return dao.getUser(userId);
	}

	/**
	 * Method : userPagingList 작성자 : PC24 변경이력 :
	 * 
	 * @param pageVo
	 * @return Method 설명 :
	 */
	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		// 1. List<UserVo>, usersCnt를 필드로하는 vo
		// 2. List<Object>, resultList = new ArrayList<Object>();
		// result.add(userList);
		// result.add(usersCnt);
		// 3. Map<String,Object> resultMap = new HashMap<String, Object>();
		// resultMap.put("userList",userList);
		// resultMap.put("usersCnt",usersCnt);
		// 보통 3번방법으로 한다

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", dao.userPagingList(pageVo));
//		resultMap.put("usersCnt", dao.usersCnt());
		
		//usersCnt --> paginationSize변경
		int usersCnt = dao.usersCnt();
		//pageSize-- > pageVo.getPageSize();
		int paginationSize= (int) Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		return resultMap;
	}

	

	/**
	* Method : insertUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		
		return dao.insertUser(userVo);
	}

	
	
	/**
	* Method : deleteUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자삭제
	*/
	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	/**
	* Method : updateUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 수정
	*/
	@Override
	public int updateUser(UserVo userVo) {
		
		return dao.updateUser(userVo);
	}

	/**
	* Method : encryptPassAllUser
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	*/
	@Override
	public int encryptPassAllUser() {
		//사용X
		if(1==1){
			return 0;
		}
		//0.sql 실행에 필요한 sqlSession 객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//1.모든 사용자 정보를 조회(단 기존 암호화 적용 사용자 제외) --> user.xml 쿼리 생성
		List<UserVo> userList = dao.userListForPassEncrypt(sqlSession);
		//2. 조회된 사용자의 비밀번호를 암호화 적용 후 사용자 업데이트
		int updateCntSum=0;
		for(UserVo userVo : userList){
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
			userVo.setPass(encryptPass);
			
			int updateCnt = dao.updateUserEncryptPass(sqlSession,userVo);
			updateCntSum+=updateCnt;
			//비정상처리
			if(updateCnt!=1){
				sqlSession.rollback();
				break;
			}
		}
		sqlSession.commit();
		sqlSession.close();
		
		//3. sqlSession 객체를 commit, close
		
		return updateCntSum;
	}

	public static void main(String[] args) {
		IUserService userService= new UserService();
		int updateCnt= userService.encryptPassAllUser();
		logger.debug("updateCnt : {} ", updateCnt);
	}

	

}
