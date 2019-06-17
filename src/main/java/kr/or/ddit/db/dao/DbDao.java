package kr.or.ddit.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class DbDao implements IdbDao{

	@Override
	public List<DbVo> getUriMappingList() {
		SqlSession sqlSession= MyBatisUtil.getSqlSession();
		List<DbVo> list = sqlSession.selectList("db.getUriMappingList");
		sqlSession.close();
		return list;
	}
	

}
