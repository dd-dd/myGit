package com.bonc.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title: IndexController</p>
 * <p>Description: </p>
 * @author zwd
 * @date 2018年9月27日
 */

//springboot中加载xml文件，扫描到文件

@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/index")
	public String index() {
		 //
		System.out.println("执行了==================");
		 return "redirect:/con/say";
		 //return "forward:index.html";
	}
}
