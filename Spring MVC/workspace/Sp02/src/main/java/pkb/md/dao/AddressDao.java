package pkb.md.dao;

import java.util.List;

import pkb.md.domain.Address;

public interface AddressDao {
	List<Address> list();
	void insert(Address address);
	void delete(long seq);
}
