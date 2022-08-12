package com.dailycodebuffer.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.service.UserService;
import com.dailycodebuffer.user.vo.ResponseTemplateVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		log.info("inside saveUser of usercontroller ");
		return userService.saveUser(user);
		
	}
	@GetMapping("/{id}")
	public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId) {
		log.info("inside getUserWithDepartment of usercontroller");
		return userService.getUserWithDepartment(userId) ;
		
	}
	

}
