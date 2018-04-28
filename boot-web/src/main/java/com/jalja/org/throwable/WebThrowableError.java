package com.jalja.org.throwable;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class WebThrowableError implements ErrorPageRegistrar {

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage error=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/html/error.html");
		ErrorPage error2=new ErrorPage(NullPointerException.class, "/html/error.html");
		registry.addErrorPages(error,error2);
	}

	
}
