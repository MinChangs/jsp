package kr.or.ddit.db.dao;

import java.util.List;

import kr.or.ddit.db.model.DbVo;

public interface IdbDao {
	List<DbVo> getUriMappingList();

}
