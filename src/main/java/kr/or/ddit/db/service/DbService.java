package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IdbDao;
import kr.or.ddit.db.model.DbVo;

public class DbService implements IdbService {
	
	private IdbDao dao;
	public DbService() {
		dao = new DbDao();
	}


	@Override
	public List<DbVo> getUriMappingList() {
		return dao.getUriMappingList();
	}

}
