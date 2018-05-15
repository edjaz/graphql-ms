package fr.edjaz.blog.tag.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "fr.edjaz.blog.tag")
public class FeignConfiguration {

}
