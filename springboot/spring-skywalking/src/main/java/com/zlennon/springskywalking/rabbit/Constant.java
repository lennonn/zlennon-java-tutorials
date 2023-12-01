package com.zlennon.springskywalking.rabbit;

public class Constant {
    public static final String FANOUT_QUEUE_1_NAME = "rabbit.fanout.queue1";
    public static final String FANOUT_QUEUE_2_NAME = "rabbit.fanout.queue2";
    public static final String FANOUT_EXCHANGE_NAME = "rabbit.fanout.exchange";

    public static final String TOPIC_QUEUE_1_NAME = "rabbit.topic.queue1";
    public static final String TOPIC_QUEUE_2_NAME = "rabbit.topic.queue2";
    public static final String TOPIC_EXCHANGE_NAME = "rabbit.topic.exchange";
    public static final String BINDING_PATTERN_IMPORTANT = "*.important.*";
    public static final String BINDING_PATTERN_ERROR = "#.error";

    public static final boolean NON_DURABLE = true;

    public static final String QUEUE_MESSAGES = "dlx-messages-queue";
    public static final String QUEUE_MESSAGES_DLQ = QUEUE_MESSAGES + ".dlq";

    public static final String DLX_EXCHANGE_MESSAGES = QUEUE_MESSAGES + ".dlx";
    public static final String DLX_ROUTEING_KEY = QUEUE_MESSAGES + ".rk";


    public static final String DIRECT_QUEUE_NAME = "rabbitmq_direct_queue";


    /**
     * 交换机名称
     */
    public static final String DIRECT_EXCHANGE_NAME = "rabbitmq_direct_exchange";

    /**
     * 交换机代理的路由键
     */
    public static final String DIRECT_EXCHANGE_ROUT_KEY = "rabbitmq.spring.boot.direct";
}
