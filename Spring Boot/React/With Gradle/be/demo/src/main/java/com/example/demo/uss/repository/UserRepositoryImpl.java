package com.example.demo.uss.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.uss.domain.UserDto;

@Repository
public class UserRepositoryImpl {
	
	@Query("insert into users() + values(:title)")
	public void create(UserDto userDto) throws Exception {
		update(@Param("title") String userName),
		userDto.getPassword());
	}
}
