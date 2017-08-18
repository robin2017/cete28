import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by robin on 2017/8/18.
 */
public class EncodingFilter  implements Filter {
    FilterConfig config;
    public void init(FilterConfig filterConfig) throws ServletException {
        config=filterConfig;
    }
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String encode=config.getInitParameter("encodeStr");
        request.setCharacterEncoding(encode);
        //请求继续走
        filterChain.doFilter(servletRequest,servletResponse);
    }
    public void destroy() {}
}
