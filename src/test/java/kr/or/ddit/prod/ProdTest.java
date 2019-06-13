package kr.or.ddit.prod;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.model.ProdVo;

import org.junit.Test;

public class ProdTest {

	@Test
	public void prodList() {
		/***Given***/
		IProdDao dao= new ProdDao();

		/***When***/
		List<ProdVo> list = dao.prodList("P201");

		/***Then***/
		assertNotNull(list);
		assertEquals(21, list.size());

	}

}
