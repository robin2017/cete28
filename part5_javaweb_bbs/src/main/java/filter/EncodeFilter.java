package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter implements Filter{
	private FilterConfig filterConfig;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		System.out.println("encode filter...");
		//request.setCharacterEncoding("UTF-8");
		String encode = filterConfig.getInitParameter("encode");
		System.out.println(encode);
		request.setCharacterEncoding(encode);
		//过滤器过滤完请求继续向后走
		arg2.doFilter(arg0, arg1);
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	      this.filterConfig = arg0;
	}

	
}
