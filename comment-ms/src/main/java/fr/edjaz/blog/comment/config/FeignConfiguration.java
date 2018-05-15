package fr.edjaz.blog.comment.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "fr.edjaz.blog.comment")
public class FeignConfiguration {

}
