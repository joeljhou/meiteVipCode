package com.mayikt.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author 周宇
 * @create 2021-09-21 22:22
 */
public class ChientHandler extends SimpleChannelInboundHandler {

    /**
     * 活跃的通道
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("请问每特教育第六期平均月薪突破多少", CharsetUtil.UTF_8));
    }

    /**
     * 读取消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        String resp = byteBuf.toString(CharsetUtil.UTF_8);
        System.out.println("客户端获取到服务器端响应的消息:" + resp);
    }
}
