package helloautoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloAutoConfiguration {

  @Bean
  public HelloService helloService(){
    return new HelloService();
  }
}
