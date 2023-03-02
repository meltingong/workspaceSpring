package com.itwill.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Bean
	public ViewResolver viewResolver(){
		// VIEW 지정
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// 접두사(ex./WEB-INF/views/main.jsp)
		resolver.setPrefix("/WEB-INF/views");
		// 접미사
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	/***********************************************************/
	/*
	@Bean
	public SimpleUrlHandlerMapping sampleServletMapping() {
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		Properties urlProperties = new Properties();
		urlProperties.put("/hello.do", "helloController");
		mapping.setMappings(urlProperties);
		return mapping;
	}
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
	*/
	/*
    jsp를 view로 사용할 때 사용
    Controller에서 리턴하는 뷰 이름에 접두, 접미어를 붙여서 jsp 경로를 찾는다.
    */
	
	/*
    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
    	BeanNameViewResolver bean1=new BeanNameViewResolver();
    	bean1.setOrder(0);
    	InternalResourceViewResolver bean2 = new InternalResourceViewResolver();
        bean2.setViewClass(JstlView.class);
        bean2.setOrder(1);
        viewResolverRegistry.viewResolver(bean1);
        viewResolverRegistry.viewResolver(bean2);
    }
	 @Override
	  public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
	    	BeanNameViewResolver bean1=new BeanNameViewResolver();
	    	bean1.setOrder(0);
	    	
	    	InternalResourceViewResolver bean2 = new InternalResourceViewResolver();
	        bean2.setViewClass(JstlView.class);
	        bean2.setPrefix("/WEB-INF/views/");
	        bean2.setSuffix(".jsp");
	        bean2.setOrder(1);
	        viewResolverRegistry.viewResolver(bean1);
	        viewResolverRegistry.viewResolver(bean2);
	    }

    // '/'로 모든 요청을 받아들이는데 이 요청들을 처리할 url 설정에 대한 코드
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) { }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {  }
    @Override
	public void  configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {
	    	contentNegotiationConfigurer.defaultContentType(MediaType.APPLICATION_JSON);
	    	contentNegotiationConfigurer.favorPathExtension(true);
	    	contentNegotiationConfigurer.ignoreAcceptHeader(false);
	    	contentNegotiationConfigurer.mediaType("json", MediaType.APPLICATION_JSON);
	    	contentNegotiationConfigurer.mediaType("xml", MediaType.APPLICATION_XML);
	    	contentNegotiationConfigurer.mediaType("jsonp", new MediaType("application", "x-javascript"));
	}
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {  }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {
    		//defaultServletHandlerConfigurer.enable();
    }
    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) { }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {  }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) { }

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        	viewControllerRegistry.addViewController("/home").setViewName("myhome");
	    	viewControllerRegistry.addViewController("/hello").setViewName("helloworld");
	    	viewControllerRegistry.addRedirectViewController("/home", "/hello");
	    	viewControllerRegistry.addStatusController("/detail", HttpStatus.BAD_REQUEST);    
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {  }
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {  }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {  }
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {  }
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {  }
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {  }
    @Override
    public Validator getValidator() {
        return null;
    }
    @Override
    public MessageCodesResolver getMessageCodesResolver() {        return null;
    }
	*/
}