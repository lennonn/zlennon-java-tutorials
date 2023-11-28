package com.zlennon.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@LoadBalancerClient(name = "instance-server", configuration = DemoServerInstanceConfiguration.class)
public class LoadBanlanceConfig {

        @LoadBalanced
        @Bean
        WebClient.Builder webClientBuilder() {
            return WebClient.builder();
        }

        @Bean
        @LoadBalanced
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }

        @Bean
        public ReactorLoadBalancer<ServiceInstance> reactorServiceInstanceLoadBalancer(Environment environment,
                                                                                       LoadBalancerClientFactory loadBalancerClientFactory) {
            String name = "instance-server";
            return new ZBRoundRobinLoadBalancer(
                    loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
        }
}
