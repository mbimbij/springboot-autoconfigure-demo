package helloautoconfig;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
  public void sayHello(String string) {
    System.out.println("Hello " + string);
  }
}
