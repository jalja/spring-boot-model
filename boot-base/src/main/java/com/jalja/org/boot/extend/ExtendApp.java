package com.jalja.org.boot.extend;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
/**
 * springboot 的运行流程 
 * 1、执行SpringApplication.initialize(sources)
 * 2、加载所有classpath下 META-INF/spring.factories中 ApplicationContextInitializer
 * 3、加载所有classpath下 META-INF/spring.factories中 ApplicationListener
 * 4、推断main方法所在的类
 * 5、执行run方法
 * 6、设置 java.awt.headless 系统变量
 * 7、加载所有classpath下 META-INF/spring.factories中 SpringApplicationRunListeners
 * 8、执行所有SpringApplicationRunListeners 的 listeners.starting();
 * 9、实例化 ApplicationArguments对象
 * 10、创建 environment 对象
 * 11、配置 environment 数据 主要将 run方法中的参数设置进去
 * 12、执行所有SpringApplicationRunListeners 的  environmentPrepared(environment)方法;
 * 13、如果不是web环境，但是是web的environment，则吧这个web的environment转换为标准的environment；
 * 14、打印 Banner printedBanner = printBanner(environment);
 * 15、初始化 ApplicationContext 如果是web环境实例化AnnotationConfigEmbeddedWebApplicationContext 
 *    否则实例化：AnnotationConfigApplicationContext
 * 16、如果 beanNameGenerator 不为空则将 beanNameGenerator 注入到ApplicationContext
 * 17、回调所有的 ApplicationContextInitializer
 * 18、执行所有SpringApplicationRunListeners 的   listeners.contextPrepared(context)方法
 * 19、向spring容器注入ApplicationArguments 对象和 Banner对象;
 * 20、将所有的源加入到 ApplicationContext中
 * 21、执行所有SpringApplicationRunListeners 的 listeners.contextLoaded(context);
 * 22、执行 ApplicationContext的refreshContext(context)并且调用ApplicationContext.registerShutdownHook();
 * 23、回调，获取容器中所有的ApplicationRunner、CommandLineRunner 进行排序 依次自行
 * 24、执行所有SpringApplicationRunListeners中的	listeners.finished(context, null);
 * @author XL
 *
 */
@SpringBootApplication
public class ExtendApp {
	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(ExtendApp.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.addInitializers(new MyApplicationContextInitializer());
		ConfigurableApplicationContext context=app.run(args);
		ApplicationArguments ar=context.getBean(ApplicationArguments.class);
		context.close();
	}
}
