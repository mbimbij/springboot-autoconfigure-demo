package helloautoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HelloService.class)
@EnableConfigurationProperties(HelloProperties.class)
public class HelloAutoConfiguration {
  @Bean
  @ConditionalOnMissingBean
  public HelloService helloService(HelloProperties helloProperties) {
    return new HelloService(helloProperties.getPrefix(), helloProperties.getSuffix());
  }
}
