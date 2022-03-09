package com.zzkk.rpc.transport;

import com.zzkk.rpc.entity.RpcRequest;
import com.zzkk.rpc.serializer.CommonSerializer;

/**
 * @author zzkk
 * @date [2021-02-18 17:50]
 * @description 客户端类通用接口
 */
public interface RpcClient {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    Object sendRequest(RpcRequest rpcRequest);

}

