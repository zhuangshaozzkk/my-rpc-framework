## 架构

[![系统架构](https://s1.ax1x.com/2022/03/09/b24sjx.jpg)](https://imgtu.com/i/b24sjx)

消费者调用提供者的方式取决于消费者的客户端选择，如选用原生 Socket 则该步调用使用 BIO，如选用 Netty 方式则该步调用使用 NIO。如该调用有返回值，则提供者向消费者发送返回值的方式同理。

### 执行流程

![执行流程](https://images.gitee.com/uploads/images/2021/0516/134406_67d5cf06_8044183.png "liuchentu.png")

我们本地写和服务器端一样的接口 然后用代理模式 发送请求给服务器端 服务器端返回结果响应

## 特性

- 实现了基于 Java 原生 Socket 传输与 Netty 传输两种网络传输方式
- 实现了四种序列化算法，Json 方式、Kryo 算法、Hessian 算法与 Google Protobuf 方式（默认采用 Kryo方式序列化）
- 实现了两种负载均衡算法：随机算法与轮转算法
- 使用 Nacos 作为注册中心，管理服务提供者信息
- 消费端如采用 Netty 方式，会复用 Channel 避免多次连接
- 如消费端和提供者都采用 Netty 方式，会采用 Netty 的心跳机制，保证连接
- 接口抽象良好，模块耦合度低，网络传输、序列化器、负载均衡算法可配置
- 实现自定义的通信协议
- 服务提供侧自动注册服务

## 项目模块概览

- **roc-api**	——	通用接口
- **rpc-common**	——	实体对象、工具类等公用类
- **rpc-core**	——	框架的核心实现
- **test-client**	——	测试用消费侧
- **test-server**	——	测试用提供侧

## 传输协议（PRF协议）

调用参数与返回值的传输采用了如下 PRF 协议（ Panda-RPC-Framework 首字母）以防止粘包：

```
+---------------+---------------+-----------------+-------------+
|  Magic Number |  Package Type | Serializer Type | Data Length |
|    4 bytes    |    4 bytes    |     4 bytes     |   4 bytes   |
+---------------+---------------+-----------------+-------------+
|                          Data Bytes                           |
|                   Length: ${Data Length}                      |
+---------------------------------------------------------------+
```

| 字段            | 解释                                                         |
| :-------------- | :----------------------------------------------------------- |
| Magic Number    | 魔数，表识一个 PRF 协议包，0xCAFEBABE                        |
| Package Type    | 包类型，标明这是一个调用请求还是调用响应                     |
| Serializer Type | 序列化器类型，标明这个包的数据的序列化方式                   |
| Data Length     | 数据字节的长度                                               |
| Data Bytes      | 传输的对象，通常是一个`RpcRequest`或`RpcClient`对象，取决于`Package Type`字段，对象的序列化方式取决于`Serializer Type`字段。 |

## 使用

启动前请确保 Nacos 运行在本地 `8848` 端口。

首先启动服务提供者，再启动消费者，在消费侧会输出成功调用hello()方法。
