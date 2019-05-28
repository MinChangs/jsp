package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.LprodVo;

public class LprodDao implements ILprodDao {

	/**
	* Method : prodList
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : lprod 전체 리스트
	*/
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		SqlSession sqlSession =MyBatisUtil.getSqlSession();
		List<LprodVo> lprodList= sqlSession.selectList("lprod.lprodPagingList",pageVo);
		sqlSession.close();
		return lprodList;
	}

	@Override
	public int lprodCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int lprodCnt = (Integer)sqlSession.selectOne("lprod.lprodCnt");
		sqlSession.close();
		return lprodCnt;
	}

	@Override
	public List<LprodVo> lprodList() {
		SqlSession sqlSession =MyBatisUtil.getSqlSession();
		List<LprodVo> lprodList= sqlSession.selectList("lprod.lprodList");
		sqlSession.close();
		return lprodList;
	}
}
