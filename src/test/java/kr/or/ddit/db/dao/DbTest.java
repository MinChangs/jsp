package kr.or.ddit.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IdbDao;
import kr.or.ddit.db.model.DbVo;

import org.junit.Test;

public class DbTest {

	@Test
	public void getUriMappingListTest() {
		/***Given***/
		IdbDao dao = new DbDao();

		/***When***/
		List<DbVo>list = dao.getUriMappingList();

		/***Then***/
		assertNotNull(list);
		assertEquals(2, list.size());

	}

}
