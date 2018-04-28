package com.jalja.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * spring boot ʹ�� jsp  ����
 * 1��������� tomcat-embed-jasper
 * 2�������ļ���� spring.mvc.view.prefix=/WEB-INF/jsp/ spring.mvc.view.suffix=.jsp
 * 3����� webapp/WEB-INF/jsp
 * @author XL
 *
 */
@Controller
public class JspController {
	@GetMapping(value="/toLogin")
	public String toLogin(Model model) {
		model.addAttribute("title", "��¼");
		return "/login";
	}
}
