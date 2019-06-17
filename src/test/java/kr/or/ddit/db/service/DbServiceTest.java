package kr.or.ddit.db.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IdbService;

import org.junit.Test;

public class DbServiceTest {

	@Test
	public void getUriMappingListTest() {
		/***Given***/
		IdbService service = new DbService();

		/***When***/
		List<DbVo>list = service.getUriMappingList();

		/***Then***/
		assertNotNull(list);
		assertEquals(2, list.size());

	}

}
