package co.company.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="co.company.spring")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {
   //책 47p
      
//   @Bean//컨테이너에 객체를 등록해주는 어노테이션이 Bean임
//   public Greeter greeter() {
//      Greeter g = new Greeter();
//      g.setFormat("%s, 안녕하세요");
//      return g;
//   }

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
   }
   
   @Bean
   public ViewResolver getViewResolver(){
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      resolver.setOrder(3);
      return resolver;
   }
   
   @Override
   public void configureDefaultServletHandling(
         DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
   }

   
//
//   @Override
//   public void configureViewResolvers(ViewResolverRegistry registry) { //우리는 이거 안쓰고 tilesview 쓸거임
//      registry.jsp("WEB-INF/views/",".jsp");
//   }
//   
   
   


   
}