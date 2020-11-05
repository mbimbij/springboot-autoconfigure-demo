package helloautoconfig;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class HelloService {
  private String prefix;
  private String suffix;

  public void sayHello(String string) {
    System.out.println(prefix + " " + string + " " + suffix);
  }
}
