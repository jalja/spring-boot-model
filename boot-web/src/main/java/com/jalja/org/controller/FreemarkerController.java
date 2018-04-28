package com.jalja.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 步骤：
 * 1、添加依赖  spring-boot-starter-freemarker
 * 2、在src/main/resources创建 templates文件  freemarker 
 *    默认路径templates(可在配置中修改 spring.framework.templateLoaderPath=xxx)  
 *    默认扩展名 .ftl
 * 3、     
 * @author XL
 *
 */
@Controller
public class FreemarkerController {
	@GetMapping(value="/fr")
	public String toFr(Model model) {
		model.addAttribute("name", "张三");
		return "fr";
	}
}
