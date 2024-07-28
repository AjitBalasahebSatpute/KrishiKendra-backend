package com.KrishiKendra.Service;

import java.util.List;

import com.KrishiKendra.DTO.UserDTO;
import com.KrishiKendra.Model.User;

public interface UserService {
	
	User addUser(User user) throws Exception;
	User getUser(Long ID);
	List<User> getAllUsers() throws Exception;
	List<User> searchUser(String userName);
	

}
