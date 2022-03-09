package com.zzkk.rpc.register;

import java.net.InetSocketAddress;

/**
 * @author zzkk
 * @date [2021-03-14 9:56]
 * @description 服务发现接口
 */
public interface ServiceDiscovery {
    /**
     * @description 根据服务名称查找服务端地址
     * @param
     * @return [java.net.InetSocketAddress]
     * @date [2021-03-14 10:09]
     */
    InetSocketAddress lookupService(String serviceName);
}
