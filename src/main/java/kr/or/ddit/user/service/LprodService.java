package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.ILprodDao;
import kr.or.ddit.user.dao.LprodDao;
import kr.or.ddit.user.model.LprodVo;

public class LprodService implements ILprodService {
	
	ILprodDao dao;
	
	
	public LprodService() {
		dao= new LprodDao();
	}


	@Override
	public Map<String, Object> lprodPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lprodList", dao.lprodPagingList(pageVo));
		
		int lprodCnt = dao.lprodCnt();
		int paginationSize= (int) Math.ceil((double)lprodCnt/pageVo.getPageSize());
		resultMap.put("paginationSize",paginationSize);
		
		return resultMap;
	}


	@Override
	public List<LprodVo> lprodList() {
		return dao.lprodList();
	}



}
