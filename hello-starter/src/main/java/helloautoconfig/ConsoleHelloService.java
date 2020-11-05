package helloautoconfig;

public class ConsoleHelloService extends HelloService {

  @Override
  public void sayHello(String string) {
    System.out.println("Bonjour " + string);
  }
}
