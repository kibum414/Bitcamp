package pkb.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pkb.md.dao.AddressDao;
import pkb.md.domain.Address;
import pkb.md.mapper.AddressMapper;

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

}
