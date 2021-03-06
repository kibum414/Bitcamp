package pkb.md.filesetting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import lombok.extern.log4j.Log4j;

@Log4j
// View 역할을 하는 JAVA 파일. JAVA로 만든 JSP 같은 것.
// -> 사용하려면 Controller에 등록해줘야 함 (servlet-context.xml)
public class FileDownloadView extends AbstractView {

	public FileDownloadView() {
		setContentType("application/download;charset=utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 다운로드 할 파일 이름 : downloadFile
		File file = (File) model.get("downloadFile");

		response.setContentType(getContentType());
		response.setContentLength((int) file.length());

		String value = "attachment; filename=" + java.net.URLEncoder.encode(file.getName(), "utf-8") + ";";

		response.setHeader("Content-Disposition", value);
		response.setHeader("Content-Transfer-Encoding", "binary");

		OutputStream os = response.getOutputStream();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, os);
			os.flush();
		} catch (IOException ie) {
			log.info("FileDownloadView ie: " + ie);
		} finally {
			if (fis != null)
				fis.close();
			if (os != null)
				os.close();
		}
	}
}
