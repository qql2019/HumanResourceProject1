package com.cisst.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ChinaFilter implements Filter {

	@Override
	public void destroy() {
	
		
	}
//中文过滤
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain china)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		china.doFilter(req, res);
	
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	
		
	}

}
