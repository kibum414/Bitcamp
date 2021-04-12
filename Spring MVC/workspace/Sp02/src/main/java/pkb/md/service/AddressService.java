package pkb.md.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import pkb.md.domain.Address;
import pkb.md.domain.AddressFile;

public interface AddressService {
	List<Address> listS();
	void insertS(Address address);
	void deleteS(long seq);
	String saveStore(MultipartFile file);
	boolean writeFile(MultipartFile file, String saveFileName);
}
