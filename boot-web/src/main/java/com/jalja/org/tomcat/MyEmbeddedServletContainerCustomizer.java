package com.jalja.org.tomcat;

import java.io.File;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * spring boot 2.0  WebServerFactoryCustomizer 接口  本文 使用  spring boot2 版本
 * spring boot 1版本   EmbeddedServletContainerCustomizer 接口
 * @author XL
 *
 */
@Component
public class MyEmbeddedServletContainerCustomizer implements WebServerFactoryCustomizer{

	@Override
	public void customize(WebServerFactory factory) {
		TomcatServletWebServerFactory tomcat=(TomcatServletWebServerFactory)factory;
		tomcat.setPort(9999);
		//设置tomcat的临时目录
		tomcat.setBaseDirectory(new File("d:/logs/tomcat"));
		tomcat.addContextValves(getAccessLog());
		tomcat.addConnectorCustomizers(getTomcatConnector());
		
		
		System.out.println("==========WebServerFactoryCustomizer===========");
		
	}
	private AccessLogValve getAccessLog() {
		AccessLogValve log=new AccessLogValve();
		//log.setDirectory("d:/logs");
		log.setEnabled(true);
		log.setPattern("common");
		log.setPrefix("spring-boot-web-log");
		log.setSuffix(".log");
		return log;
		
	} 
	private TomcatConnectorCustomizer getTomcatConnector() {
		TomcatConnectorCustomizer tomcat=new TomcatConnectorCustomizer() {
			@Override
			public void customize(Connector connector) {
				System.out.println("======="+connector.getMaxPostSize()+"==============");
				Http11NioProtocol protocol=(Http11NioProtocol)connector.getProtocolHandler();
				protocol.setMaxConnections(100);//最大连接数
				protocol.setMaxThreads(50);//最大线程 并发
				
			}
		};
		return tomcat;
	}
 
}
