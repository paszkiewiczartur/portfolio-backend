package pl.portfolio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

//@Configuration
public class RestMvcConfig //extends RepositoryRestMvcConfiguration 
	{
//repositoryExporterHandlerMapping()
   /* @Override
    public RequestMappingHandlerAdapter repositoryExporterHandlerAdapter() {
        RequestMappingHandlerAdapter mapping = super.repositoryExporterHandlerAdapter();
        
        mapping.setInterceptors(new Object[] { new OriginInterceptor() });
        return mapping;
    }*/
//	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    //registry.addInterceptor(new OriginInterceptor());
	}
}