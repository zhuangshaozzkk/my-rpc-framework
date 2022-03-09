package com.zzkk.rpc.register;

import java.net.InetSocketAddress;

/**
 * @author zzkk
 * @date [2021-02-07 16:55]
 * @description 服务注册接口
 */
public interface ServiceRegistry {

    /**
     * @description 将一个服务注册到注册表
     * @param serviceName inetSocketAddress 服务名称，提供服务的地址
     * @return [void]
     * @date [2021-03-13 14:44]
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress);

}
