package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256_test {
	private static final Logger logger = LoggerFactory
			.getLogger(KISA_SHA256_test.class);
	/**
	* Method : sha256test
	* 작성자 : PC24
	* 변경이력 :
	* Method 설명 : 복호화가 불가능한 hash 알고리즘
	*/
	@Test
	public void sha256test() {
		/***Given***/
		String plainText ="20bbc85c57c06695ea7703d5cd9e64d10dd77c44850ec15d14da21b232d673";

		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);

		/***Then***/
		logger.debug("encryptText :{}", encryptText);
		assertEquals("7570475a166e1c763728d3e2b1a2a1ea57e1eed2993bbe81c79495375d8c9", encryptText);
	}

}
