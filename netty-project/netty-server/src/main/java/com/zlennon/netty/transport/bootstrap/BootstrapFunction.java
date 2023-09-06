package com.zlennon.netty.transport.bootstrap;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.BootstrapConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class BootstrapFunction {
    Bootstrap bootstrap = new Bootstrap();
    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    ServerBootstrap serverBootstrap = new ServerBootstrap();

    public void config() {

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            ChannelFuture connect = bootstrap.connect("10.10.10.10", Integer.parseInt("8080"));
        } catch (Exception e) {

        }

        BootstrapConfig config = bootstrap.config();
        System.out.println(config.toString());
    }

    public void connect(){
        ChannelFuture localhost =
                bootstrap.connect(new InetSocketAddress("localhost", 8080));
    }


}
