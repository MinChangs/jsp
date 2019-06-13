package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.prod.model.ProdVo;

import org.apache.ibatis.session.SqlSession;

public class ProdDao implements IProdDao{

	@Override
	public List<ProdVo> prodList(String code) {
		SqlSession sqlSession  =MyBatisUtil.getSqlSession();
		List<ProdVo> list =  sqlSession.selectList("prod.prodList",code);
		sqlSession.close();
		return list;
	}

}
