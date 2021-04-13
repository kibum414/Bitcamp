package pkb.md.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pkb.md.domain.Address;
import pkb.md.domain.AddressFile;

public interface AddressService {
	List<Address> listS();
	//void insertS(Address address);
	
	void deleteS(long seq);
	void removeFiles(long seq); // delete 할 때
	
	ArrayList<AddressFile> insertS(Address address, ArrayList<MultipartFile> files);
	void removeFiles(); // 업로딩 실패 시
}
