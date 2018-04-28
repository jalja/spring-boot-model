package com.jalja.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * spring boot 使用 jsp  步骤
 * 1、添加依赖 tomcat-embed-jasper
 * 2、配置文件添加 spring.mvc.view.prefix=/WEB-INF/jsp/ spring.mvc.view.suffix=.jsp
 * 3、添加 webapp/WEB-INF/jsp
 * @author XL
 *
 */
@Controller
public class JspController {
	@GetMapping(value="/toLogin")
	public String toLogin(Model model) {
		model.addAttribute("title", "登录");
		return "/login";
	}
}
