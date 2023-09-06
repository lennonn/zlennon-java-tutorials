package com.zlennon.netty.time;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    private static ChannelHandlerContext channelHandlerContext;

   @Override
    public void channelActive(ChannelHandlerContext ctx) {
       System.out.print("server channelActive");
       channelHandlerContext=ctx;
       sendMsg(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String rev = new String(bytes,CharsetUtil.UTF_8);

        //System.out.println("server 接收到消息==>>"+rev);
        //给客户端响应一条数据
       //write是写入缓冲区,

      // Scanner scanner =  new Scanner(System.in);
       ctx.writeAndFlush(Unpooled.copiedBuffer("server send==>>"+rev, CharsetUtil.UTF_8));
    }

    void sendMsg(ChannelHandlerContext ctx){
        for (int i = 0; i <100 ; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ctx.writeAndFlush(Unpooled.copiedBuffer("server send==>>"+i, CharsetUtil.UTF_8));

        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        ctx.close();
    }
}
