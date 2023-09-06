package com.zlennon.rabbimq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.zlennon.rabbimq.Constant.*;


@Configuration
public class RabbitDirectConfig {



    /**
     * 定义队列(demo)
     *
     * @return
     */
    @Bean("directQueue")
    public Queue directQueue(){
        return new Queue(DIRECT_QUEUE_NAME);
    }


    /**
     * 定义直连交换机(Demo)
     */
    @Bean("directExchange")
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE_NAME, false, true);
    }
    

    /**
     * 绑定直连交换机与队列(direct demo)
     * @param queue
     * @param directExchange
     * @return
     */
    @Bean
    public Binding bindingDirectExchangeDemo(@Qualifier("directQueue") Queue queue,
                                             @Qualifier("directExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with(DIRECT_EXCHANGE_ROUT_KEY);
    }

}

