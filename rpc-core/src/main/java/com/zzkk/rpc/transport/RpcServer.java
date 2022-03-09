package com.zzkk.rpc.transport;

import com.zzkk.rpc.serializer.CommonSerializer;

/**
 * @author zzkk
 * @date [2021-02-18 17:53]
 * @description 服务端类通过接口
 */
public interface RpcServer {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    void start();

    /**
     * @description 向Nacos注册服务
     * @param [service, serviceClass]
     * @return [void]
     * @date [2021-03-13 15:56]
     */
    <T> void publishService(T service, String serviceName);
}
