package com.zlennon.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

@SpringBootApplication(scanBasePackages = "com.zlennon")
public class SpringbootI18nApplication implements CommandLineRunner {

    @Autowired
    MessageUtils messageUtils;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootI18nApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("中文：=>>"+messageUtils.get("001"));
        Locale locale = new Locale("en_US");
        LocaleContextHolder.setLocale(locale);
        System.out.println("英文：=>>"+messageUtils.get("001"));

    }
}
