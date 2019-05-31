package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IUserService {

	IUserDao dao;

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


	

}
