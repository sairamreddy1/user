package com.dailycodebuffer.user.vo;

import com.dailycodebuffer.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {
	
     public User user;
	public Department department;
	

}
