package passionx3.jkdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	@Qualifier(value = "signonInterceptor")
	private HandlerInterceptor interceptor;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// registry.addViewController("/shop/index.do").setViewName("Home");
		registry.addViewController("/user/signonForm.do").setViewName("SignonForm");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
				.addPathPatterns("/order/newOrder.do", "/order/newFundOrder.do");		
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8"); // 파일 인코딩 설정
		multipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024); // 파일당 업로드 크기 제한 (5MB)
		return multipartResolver;
	}
}
