package com.zlennon.springautoconfig;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;


class SpringAutoconfigApplicationTests {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(MyAutoConfiguration.class));

    @Test
    public  void serviceNameCanBeConfigured() {
        this.contextRunner.withUserConfiguration(MyAutoConfiguration.class).run((context) -> {
            context.assertThat().hasSingleBean(MyService.class);
            MyService service = context.getBean(MyService.class);
            Assertions.assertThat(service.isAutoConfig()).isTrue();
        });
    }

}
