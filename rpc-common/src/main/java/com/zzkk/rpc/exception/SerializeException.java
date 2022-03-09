package com.zzkk.rpc.exception;

/**
 * @author zzkk
 * @date [2021-03-09 17:18]
 * @description 序列化异常
 */
public class SerializeException extends RuntimeException{
    public SerializeException(String msg){
        super(msg);
    }
}
