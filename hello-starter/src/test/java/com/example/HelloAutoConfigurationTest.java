package com.example;

import helloautoconfig.HelloAutoConfiguration;
import helloautoconfig.HelloService;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloAutoConfigurationTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Rule
  public OutputCaptureRule output = new OutputCaptureRule();
  private ConfigurableApplicationContext context;

  @After
  public void closeContext() throws Exception {
    if (context != null){
      context.close();
    }
  }

  @Test
  public void defaultServiceIsAutoConfigured() {
    load(EmtpyConfiguration.class);
    HelloService service = context.getBean(HelloService.class);
    service.sayHello("World !");
    output.expect(Matchers.containsString("Hello World !"));
  }

  private void load(Class<?> config, String ... environment){
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(config);
    context.refresh();
    TestPropertyValues.of(environment).applyTo(context);
    this.context = context;
  }

  @Configuration
  @ImportAutoConfiguration(HelloAutoConfiguration.class)
  static class EmtpyConfiguration{}

  @Configuration
  @Import(EmtpyConfiguration.class)
  static class UserConfiguration{}
}
