package com.jalja.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ���裺
 * 1���������  spring-boot-starter-freemarker
 * 2����src/main/resources���� templates�ļ�  freemarker 
 *    Ĭ��·��templates(�����������޸� spring.framework.templateLoaderPath=xxx)  
 *    Ĭ����չ�� .ftl
 * 3��     
 * @author XL
 *
 */
@Controller
public class FreemarkerController {
	@GetMapping(value="/fr")
	public String toFr(Model model) {
		model.addAttribute("name", "����");
		return "fr";
	}
}
