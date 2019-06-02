package com.cosi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cosi.iservice.IUserService;
import com.cosi.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@RequestMapping("/show.do")
	public ModelAndView showUsers(){
		ModelAndView mv = new ModelAndView();
		List<User> users = userService.getUsers();
		mv.addObject("users",users);
		mv.setViewName("showusers.jsp");
		return mv;
	}
	
	// 在方法的返回值之前标注@ResponseBody注解，提示以json格式返回数据（Object）
	@RequestMapping("/getusersjson.do")
	public @ResponseBody Map<String,Object> getUsersJson(){
		List<User> users = userService.getUsers();
		Map<String,Object> result = new HashMap<>();
		result.put("rows", users);
		result.put("total", users.size());
		return result;
	}
	
	
	
}
