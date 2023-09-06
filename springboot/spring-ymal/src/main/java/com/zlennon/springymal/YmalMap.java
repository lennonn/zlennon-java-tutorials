package com.zlennon.springymal;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "map")
@Data
public class YmalMap {

    private Map<String, String> maps;
    private Map<String, User> users;

}
