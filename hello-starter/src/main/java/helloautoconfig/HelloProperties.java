package helloautoconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello")
@Getter
@Setter
public class HelloProperties {
  private String prefix = "Hello";
  private String suffix = "!";
}
