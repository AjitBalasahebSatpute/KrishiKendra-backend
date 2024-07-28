package com.KrishiKendra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.KrishiKendra.DTO.UserDTO;
import com.KrishiKendra.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


	User findBymobileNumber(String mobileNumber);
	
//	@Query("select All from table User_Data")
	
//    @Query("SELECT new com.KrishiKendra.DTO.UserDTO(u.id, u.name) FROM UserData u")
//    @Query("SELECT new com.KrishiKendra.DTO.UserDTO(u.id, u.firstName, u.lastName, u.villageName, u.mobileNumber) FROM User_Data u")
//	List<UserDTO>FindAllUsers();
	
}
