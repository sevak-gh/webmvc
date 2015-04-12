package sevak.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditingInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(AuditingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
                             Object handler) throws Exception {
        request.setAttribute("start", System.currentTimeMillis());
        LOG.debug("pre handle: {}", request.getRequestURI());
        return true;            
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, 
                             Object handler, ModelAndView model) throws Exception {        
        LOG.debug("postHandle: {}", response.getStatus());
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
                                Object handler, Exception e) throws Exception {
        LOG.debug("completed in {} msec", (System.currentTimeMillis() - Long.parseLong(request.getAttribute("start").toString())));
    }
}
