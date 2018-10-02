package com.ggstudy.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.ggstudy.springboot.domain.SysConfig;
import com.ggstudy.springboot.domain.User;
import com.ggstudy.springboot.service.ISysConfigService;
import com.ggstudy.springboot.service.IUserService;
import com.ggstudy.springboot.support.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import com.ggstudy.starter.model.ConfigClient;

@RestController
@EnableConfigurationProperties({ AppConfig.class })
public class IndexController {

	@Value("${appConfig.name}")
	private String appName;
	@Value("${appConfig.author}")
	private String author;

//	@Autowired
//	private ConfigClient configClient;
	
	@Autowired
	private AppConfig appConfig;

	@Autowired
	Map<String, Map<String, String>> KVMap;

	@Autowired
	ISysConfigService sysConfigService;

	@Autowired
	IUserService userService;

    @RequestMapping("/KVMap")
	public Object KVMap() {
		// return KVMap.get("key");
//		System.out.println(configClient.getClientName() + "11111111111");
		return KVMap.get(0);
	}

	@RequestMapping("/appConfig")
	public Object appConfig() {
		return appConfig.getName();
	}

	@RequestMapping("/addUser")
	public String addUser() {
		User u = new User();
		u.setUserName("aaa11");
		userService.addUser(u);
		return "ok";
	}

	@RequestMapping("/addSys")
	public String addSys() {
		SysConfig sys = new SysConfig();
		sys.setCfgName("bbb");
		sysConfigService.addSysConfig(sys);
		return "ok";
	}

	@RequestMapping("/updateSys")
	public String updateSys(@RequestParam String name) {
		SysConfig sys = new SysConfig();
		sys.setId(1);
		sys.setCfgName(name);
		sysConfigService.updateSysConfig(sys);
		return "ok";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam Integer id,@RequestParam String name) {
		User user=new User();
        user.setId(id);
		user.setUserName(name);
        /**
         * 异步执行方式，事务不生效的
         */
		userService.updateUserAsyc(user);
        /**
         * 同步方式，事务生效
         */
//        userService.updateUser(user);
		return "ok";
	}


	@RequestMapping("/getSys")
	public SysConfig getSys(@RequestParam Integer id) {
		SysConfig sys = sysConfigService.getSysConfig(id);
		return sys;
	}

	@RequestMapping("/")
	public String appName() {
		return "Welcome Sun Yu!";
	}

	@RequestMapping("/index")
	public String index() {
		return "This is index";
	}

	@RequestMapping("/saveSysConfig")
	public String saveSysConfig() {
		SysConfig sc = new SysConfig();
		sc.setCfgCode("ssss");
		sysConfigService.addSysConfig(sc);
		return "OK";
	}

	@RequestMapping("/login")
	public Object login(@RequestBody Map<String, String> param) {
		System.out.println(param);
		JSONObject res = new JSONObject();
		if (param.isEmpty()) {
			res.put("code", "-999");
			res.put("msg", "Need something to login");
		} else {
			JSONObject input = new JSONObject();
			for (String key : param.keySet()) {
				input.put(key, param.get(key));
			}
			res.fluentPut("your_input", input);
			res.put("respone_code", "200");
			res.put("respone_msg", "login success!");
		}
		return res;
	}

	@RequestMapping("/getAsync")
	public List<String> getAsync() {
		List<String> res = sysConfigService.asyncTest();
		return res;
	}


	@RequestMapping(value = "/xmlTest",produces = {"application/json","application/xml"})
	public List<String> xmlTest() {
		List<String> stringList=new ArrayList<String>(){{
			add("1");
			add("2");
			add("3");
			add("4");
		}};
		return stringList;
	}


}
