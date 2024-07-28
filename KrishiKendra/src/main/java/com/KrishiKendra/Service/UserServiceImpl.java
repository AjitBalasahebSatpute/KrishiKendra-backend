package com.KrishiKendra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KrishiKendra.DTO.UserDTO;
import com.KrishiKendra.Exception.*;
import com.KrishiKendra.Model.User;
import com.KrishiKendra.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepo;

	@Override
	public User addUser(User user) throws Exception {
		try {
			if(userRepo.findBymobileNumber(user.getMobileNumber())==null) {
				return userRepo.save(user);
			}
			else {
				throw new BadInputException("user with details Exist");
			}
		}
		catch(NullPointerException e) {
			
			System.out.println("***** Repository ******");
			e.printStackTrace();
//			throw new Exception("DB connection Error");
			return null;
			
		}
		
	}

	@Override
	public User getUser(Long ID) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<User> searchUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() throws Exception {
		// TODO Auto-generated method stub
		try {
			
			return userRepo.findAll();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Data base connection error");
		}
	}

}
