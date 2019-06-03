package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadServlet.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// userId, profile 파라미터를 확인
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String profile = request.getParameter("profile");

		logger.debug("userId : {} ", userId);
		logger.debug("profile : {} ", profile);

		Part part = request.getPart("profile");

		logger.debug("part.getSize() : {} ", part.getSize());

		// 파일이 존재할 때만 파일을 정해진 위치에 기록한다.
		if (part.getSize() > 0) {

			logger.debug("part.getContentType() : {} ", part.getContentType());
			logger.debug("part.getName(): {} ", part.getName());

			// Collection<String> headerNames= part.getHeaderNames();
			// for(String header : headerNames)
			// logger.debug("{} : {} ", header, part.getHeader(header));

			String contentDisposition = part.getHeader("content-disposition");
			String fileName = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(fileName);


			String uploadPath = PartUtil.getUploadPath();
			
//			File.separator는 윈도우 환경에서는 \\ 리눅스 환경에서는 /이기때문에 OS환경이 달라지면 안되는 경우가 있다
//			File.separator를 이용하면 JVM에서 자동으로 OS환경에 맞게 지정해준다
			File uploadFolder = new File(uploadPath);

			if (uploadFolder.exists()) {
				// 파일 디스크에 쓰기
				// part.write("d:\\upload\\"+fileName); fileName이 중복되는 경우가 있기때문에 사용하기 힘들다
				//java.util에 있는 UUID 클래스를 이용해서 임의이 파일이름을 생성해준다
				
				part.write(uploadPath + "\\" + UUID.randomUUID().toString()	+ ext);
				part.delete();// 임시저장공간에 만약 찌거기가 남아있으면 지우기 위해 호출
			}
		}
	}
}



/*
 logger.debug("part.getContentType() : {} ", part.getContentType());
			logger.debug("part.getName(): {} ", part.getName());

			// Collection<String> headerNames= part.getHeaderNames();
			// for(String header : headerNames)
			// logger.debug("{} : {} ", header, part.getHeader(header));

			String contentDisposition = part.getHeader("content-disposition");
			String fileName = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(fileName);

			// 년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가 있는지
			Date dt = new Date();
			SimpleDateFormat yyyyMMSdf = new SimpleDateFormat("yyyyMM");
			String yyyyMM = yyyyMMSdf.format(dt);
			String yyyy = yyyyMM.substring(0,4);
			String mm = yyyyMM.substring(4,6);

			File yyyyFolder = new File("d:\\upload\\" + yyyy);
			if (!yyyyFolder.exists()) {
				yyyyFolder.mkdir();
			}

			File mmFolder = new File("d:\\upload\\"+yyyy+"\\" + mm);
			if (!mmFolder.exists()) {
				mmFolder.mkdir();
			}

			String uploadPath = "d:"+File.separator+"upload"+File.separator + yyyy + File.separator + mm;
			
//			File.separator는 윈도우 환경에서는 \\ 리눅스 환경에서는 /이기때문에 OS환경이 달라지면 안되는 경우가 있다
//			File.separator를 이용하면 JVM에서 자동으로 OS환경에 맞게 지정해준다
			File uploadFolder = new File(uploadPath);

			if (uploadFolder.exists()) {
				// 파일 디스크에 쓰기
				// part.write("d:\\upload\\"+fileName); fileName이 중복되는 경우가 있기때문에 사용하기 힘들다
				//java.util에 있는 UUID 클래스를 이용해서 임의이 파일이름을 생성해준다
				
				part.write(uploadPath + "\\" + UUID.randomUUID().toString()	+ ext);
				part.delete();// 임시저장공간에 만약 찌거기가 남아있으면 지우기 위해 호출
			}
 */
