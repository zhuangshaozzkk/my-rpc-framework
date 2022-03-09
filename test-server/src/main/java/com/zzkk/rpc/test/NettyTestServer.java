package com.zzkk.rpc.test;

import com.zzkk.rpc.annotation.ServiceScan;
import com.zzkk.rpc.serializer.CommonSerializer;
import com.zzkk.rpc.transport.RpcServer;
import com.zzkk.rpc.transport.netty.server.NettyServer;

/**
 * @author zzkk
 * @date [2021-02-22 17:13]
 * @description 测试用Netty服务端
 */
@ServiceScan
public class NettyTestServer {
    public static void main(String[] args) {
        RpcServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        server.start();
    }
}
