package com.example.demo.service;

import com.example.demo.dto.User;

public interface IUserService {

		public User add(User proyecto);

		public User getOne(String email);
		
		public User update(User user);
}
