package kr.or.ddit.util;

import javax.servlet.http.Part;

import kr.or.ddit.servlet.FileUploadServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtil {

	/**
	* Method : getFileName
	* 작성자 : PC24
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 파일명을 반환한다.
	*/
	public static String getFileName(String contentDisposition) {
		//content-disposition : form-data; name="profile"; filename="9. 개념ERD_다독다독.png" 
		
		
		String[] arr =  contentDisposition.split("; ");
		String fileName = "";
		for(int i =0; i<arr.length; i++){
			if(arr[i].startsWith("filename=")){
				int start= arr[i].indexOf('"');
				int end= arr[i].lastIndexOf('"');
				fileName = arr[i].substring(start+1, end);
				return fileName;
			}
		}
		return fileName;
	}

	/**
	* Method : getExt
	* 작성자 : PC24
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일명으로부터 파일 확장자를 반환
	*/
	public static String getExt(String fileName) {
		if(fileName.contains(".")){
			return fileName.substring(fileName.lastIndexOf('.')+1);
		}
		return "";
	}
	
}
