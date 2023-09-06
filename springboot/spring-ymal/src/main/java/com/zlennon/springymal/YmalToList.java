package com.zlennon.springymal;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "list")
@Data
public class YmalToList {

    private List<String> include;

    private List<User> userlist;

}
