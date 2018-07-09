package com.ggstudy.controller.user;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ggstudy.common.GGLogger;
import com.ggstudy.domain.user.UserDomain;
import com.ggstudy.service.user.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	GGLogger logger=new GGLogger(UserController.class);
	@Resource
	private IUserService userService;
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam Map<String,Object> map) {
		System.out.println(map.size());
		return null;
	}
	@RequestMapping("/userAdd")
	public ModelAndView userAdd() {
		ModelAndView mv=new ModelAndView("/user/userAdd");
		return mv;
	}
	@RequestMapping("/userAddPost")
	public ModelAndView userAddPost(@ModelAttribute UserDomain user) {
		logger.debug("用户名："+user.getUserName());
		logger.debug("密码："+user.getUserPwd());
		try {
			userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv=new ModelAndView("/user/userAdd");
		return mv;
	}
}
