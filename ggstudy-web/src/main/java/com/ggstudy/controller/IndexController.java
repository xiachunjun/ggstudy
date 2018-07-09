package com.ggstudy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ggstudy.domain.user.UserDomain;
import com.mysql.jdbc.StringUtils;

@Controller
public class IndexController {
	public static final String PWD = "123";

	@RequestMapping("index")
	public ModelAndView index(@RequestParam Map<String, Object> map) {
		ModelAndView mv=new ModelAndView("/index");
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("c");
		list.add("e");
		list.add("");
		list.add(null);
		mv.addObject("list", list);
		Map<String,Object> map1=new HashMap<String,Object>();
		UserDomain ud=new UserDomain();
		map1.put("user", ud);
		mv.addObject("userName", "帅到 & 没朋友");
		return mv;
	}

	@RequestMapping("lock")
	public ModelAndView lock() {
		return new ModelAndView("/lockscreen");
	}

	@RequestMapping("unlock")
	public ModelAndView unlock(String password, String goToUrl) {
		ModelAndView mv = null;
		if (PWD.equals(password)) {
			if (StringUtils.isNullOrEmpty(goToUrl)) {
				mv = new ModelAndView("redirect:/index");
			} else {
				mv = new ModelAndView("redirect:" + goToUrl);
			}
		} else {
			mv = new ModelAndView("/lockscreen");
		}
		return mv;
	}
}
