package pl.mb2k15;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addRedirectViewController("addusersucces" ,"/login");
        registry.addRedirectViewController("/", "warehouse/list");
        registry.addViewController("/addUserName").setViewName("register");
        registry.addViewController("/currency").setViewName("currency_state");
        registry.addViewController("/warehouse/addform").setViewName("warehouse/addproductwarehouse");
        registry.addViewController("/warehouse/upcart").setViewName("upcart");
        registry.addViewController("/remove").setViewName("upcart");


    }

}