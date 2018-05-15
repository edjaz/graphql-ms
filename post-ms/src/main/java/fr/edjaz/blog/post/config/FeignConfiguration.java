package fr.edjaz.blog.post.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "fr.edjaz.blog.post")
public class FeignConfiguration {

}
