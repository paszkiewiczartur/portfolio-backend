package pl.portfolio.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class OriginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
    throws Exception {
    // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    throws Exception {
    	response.setHeader("allow", "GET, HEAD, POST");
    	response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
    	System.out.println("inside postHandle");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }


}