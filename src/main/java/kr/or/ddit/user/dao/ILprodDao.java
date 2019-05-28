package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.LprodVo;

public interface ILprodDao {
	
	
	List<LprodVo> lprodList();
	/**
	* Method : prodList
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 리스트
	*/
	List<LprodVo> lprodPagingList(PageVo pageVo);
	
	
	
	/**
	* Method : userCnt
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : LPROD 전체수 조회
	*/
	int lprodCnt();

}
