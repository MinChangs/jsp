package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.LprodVo;

public interface ILprodService {
	Map<String, Object> lprodPagingList(PageVo pageVo);
	
	List<LprodVo> lprodList();
	


}
