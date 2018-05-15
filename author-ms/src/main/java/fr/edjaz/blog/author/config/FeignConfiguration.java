package fr.edjaz.blog.author.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "fr.edjaz.blog.author")
public class FeignConfiguration {

}
