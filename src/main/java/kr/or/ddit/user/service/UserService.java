package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IUserService{
	
	IUserDao dao = new UserDao();
	
	

	public UserService() {
		dao = new UserDao();
	}


	/**
	 * 
	* Method : userList
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVo> userList() {
		//controller -> service -> dao
		//db에서 데이터를 조회했다고 가정
		
		return dao.userList();
	}

	
	/**
	* Method : getUser
	* 작성자 : PC24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보
	*/
	@Override
	public UserVo getUser(String userId) {
		
		return dao.getUser(userId);
	}
	
	
	
}
