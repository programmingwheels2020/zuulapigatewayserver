package com.verizontraining.zuulapigatewaydemo;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LoggingFilter extends ZuulFilter{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		System.out.println("---------------------THis is called");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		System.out.println("-----------------------------THis RUn");
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request came from =>"+ request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
