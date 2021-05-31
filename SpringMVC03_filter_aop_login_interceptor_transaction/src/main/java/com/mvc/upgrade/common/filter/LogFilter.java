package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		// 클라이언트의 IP 주소 혹은 요청을 보낸 마지막 프록시를 리턴
		String remoteAddr = req.getRemoteAddr();
		
		// 요청 URL의 context-root부터 쿼리 스트링 부분을 리턴
		String uri = req.getRequestURI();
		
		// 클라이언트가 요청을 하기 위해 사용한 URL
		String url = req.getRequestURL().toString();
		
		// 요청 URL의 쿼리 스트링을 리턴
		String queryString = req.getQueryString();
		
		// getHeader() : 특정 요청 header 값을 String으로 리턴
		// 이전 URL 가져옴
		String referer = req.getHeader("referer");
		
		// 사용자 정보 가져옴
		String agent = req.getHeader("User-Agent");
		
		StringBuffer sb = new StringBuffer();
		sb.append("* remoteAddr : " + remoteAddr + "\n")
			.append("* uri : " + uri + "\n")
			.append("* url : " + url + "\n")
			.append("* queryString : " + queryString + "\n")
			.append("* referer : " + referer + "\n")
			.append("* agent : " + agent);
		
		logger.info("LOG FILTER\n" + sb);
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
