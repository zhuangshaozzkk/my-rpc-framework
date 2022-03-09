package com.zzkk.rpc.test;

import com.zzkk.rpc.annotation.ServiceScan;
import com.zzkk.rpc.serializer.CommonSerializer;
import com.zzkk.rpc.transport.RpcServer;
import com.zzkk.rpc.transport.socket.server.SocketServer;

/**
 * @author zzkk
 * @date [2021-02-05 14:45]
 * @description 测试用服务端
 */
@ServiceScan
public class SocketTestServer {
    public static void main(String[] args) {
        RpcServer server = new SocketServer("127.0.0.1", 9998, CommonSerializer.HESSIAN_SERIALIZER);
        server.start();
    }
}
