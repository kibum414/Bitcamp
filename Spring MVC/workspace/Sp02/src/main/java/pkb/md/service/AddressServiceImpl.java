package pkb.md.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import pkb.md.dao.AddressDao;
import pkb.md.domain.Address;
import pkb.md.filesetting.Path;
import pkb.md.mapper.AddressMapper;

@Log4j
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	//private AddressMapper addressMapper;
	private AddressDao addressDao;
	
	@Override
	public List<Address> listS() {
		//return addressMapper.list();
		return addressDao.list();
	}

	@Override
	public void insertS(Address address) {
		//addressDao.insert(address);
		addressDao.insert(address);
	}

	@Override
	public void deleteS(long seq) {
		//addressDao.delete(seq);
		addressDao.delete(seq);
	}

	@Override
	public String saveStore(MultipartFile file) {
		String ofname = file.getOriginalFilename();
		
		int idx = ofname.lastIndexOf(".");
		String ofheader = ofname.substring(0, idx);
		String ext = ofname.substring(idx);
		long ms = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		
		sb.append(ofheader);
		sb.append("_");
		sb.append(ms);
		sb.append(ext);
		
		String saveFileName = sb.toString();
		
		long fsize = file.getSize();
		
		log.info("#idx: " + idx + 
				", #ofname: " + ofname + 
				", saveFileName: " + saveFileName + 
				", fsize: " + fsize);
		
		boolean flag = writeFile(file, saveFileName);
		
		if (flag) {
			log.info("#업로드 성공");
			
			
		} else {
			log.info("#업로드 실패");
		}
		
		return Path.FILE_STORE + "/" + saveFileName;
	}

	@Override
	public boolean writeFile(MultipartFile file, String saveFileName) {
		File dir = new File(Path.FILE_STORE);
		
		if (!dir.exists()) dir.mkdirs();
		
		FileOutputStream fos = null;
		
		try {
			byte data[] = file.getBytes();
			fos = new FileOutputStream(Path.FILE_STORE + "/" + saveFileName);
			fos.write(data);
			fos.flush();
			
			return true;
		} catch (IOException ie) {
			return false;
		} finally {
			try {
				if (fos != null) fos.close();
			} catch (IOException ie) {
				
			}
		}
	}

}
