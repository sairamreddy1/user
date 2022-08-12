package com.dailycodebuffer.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;
import com.dailycodebuffer.user.vo.Department;
import com.dailycodebuffer.user.vo.ResponseTemplateVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ResponseTemplateVo responseTemplateVo;

	public User saveUser(User user) {
		log.info("inside saveuser of userservice");
		return userRepository.save(user) ;
	}

	public ResponseTemplateVo getUserWithDepartment(Long userId) throws Exception {
		log.info("inside getUserWithDepartment of UserService ");
		ResponseTemplateVo vo=new ResponseTemplateVo();
		User user;
		user = UserRepository.findByUserId(userId);
		Department department=restTemplate.getForObject("http://localhost:8081/departments"+user.getDepartmentId(),Department.class );
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

}
