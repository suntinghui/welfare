package com.welfare.client;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @功能	注册过滤器
 * @描述
 * <blockquote>
 * </br>
 * </blockquote> 
 * @创建时间 2019年5月22日 上午1:59:44
 * @抛出异常 无
 * @作者	   inkongs	fallsoul@163.com
 */
@Component
public class RegFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(RegFilter.class);
	
	/**
	 * Default constructor.
	 */
	public RegFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("进入服务过滤器");
		
		HttpServletRequest hreq = (HttpServletRequest) request;

		HttpServletResponse hresp = (HttpServletResponse) response;

		// 放开options请求 支持跨域请求头
		// 跨域
		hresp.setHeader("Access-Control-Allow-Origin", "*");

		// 跨域 Header

		hresp.setHeader("Access-Control-Allow-Methods", "*");

		hresp.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
		
		
		// 浏览器是会先发一次options请求，如果请求通过，则继续发送正式的post请求
		// 配置options的请求返回

		if (hreq.getMethod().equals("OPTIONS")) {
			logger.info("跨域包含OPTIONS");
			hresp.setStatus(HttpStatus.SC_OK);

			// hresp.setContentLength(0);

			hresp.getWriter().write("OPTIONS returns OK");

			return;

		} else {
			logger.info("请求不包含OPTIONS");
		}

		
		// Filter 只是链式处理，请求依然转发到目的地址。
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
