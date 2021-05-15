package chap7.config;

import chap7.Calculator;
import chap7.RecCalculator;
import chap7.aspect.ExeTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppContext {
    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }

}
