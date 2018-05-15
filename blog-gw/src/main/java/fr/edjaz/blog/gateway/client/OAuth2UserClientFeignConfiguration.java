package fr.edjaz.blog.gateway.client;

import java.io.IOException;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OAuth2UserClientFeignConfiguration {

    @Bean(name = "userFeignClientInterceptor")
    public RequestInterceptor getUserFeignClientInterceptor() throws IOException {
        return new UserFeignClientInterceptor();
    }
}
