package helloautoconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "hello")
@Getter
@Setter
public class HelloProperties {
  /**
   * Prefix of the welcome message
   */
  private String prefix;
  /**
   * Suffix of the welcome message
   */
  private String suffix = "!";
}
