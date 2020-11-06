package helloautoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnValidHelloPrefixCondition extends SpringBootCondition {
  @Override
  public ConditionOutcome getMatchOutcome(ConditionContext context,
                                          AnnotatedTypeMetadata metadata) {
    Environment environment = context.getEnvironment();
    String key = "hello.prefix";
    ConditionMessage.Builder condition = ConditionMessage.forCondition("ValidHelloPrefix");
    if(environment.containsProperty(key)) {
      String value = environment.getProperty(key);
      if (Character.isUpperCase(value.charAt(0))){
        return ConditionOutcome.match(condition.available(String.format("valid prefix ('%s')", value)));
      }
      return ConditionOutcome.noMatch(condition.because(String.format("rejected the prefix '%s' as it does not start " +
          "with an uppercase character", value)));
    }else {
      return ConditionOutcome.noMatch(condition.didNotFind("property").items("'hello.prefix'"));
    }
  }
}
