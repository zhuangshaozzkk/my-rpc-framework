package com.zzkk.rpc.test;

import com.zzkk.rpc.annotation.Service;
import com.zzkk.rpc.api.ByeService;

/**
 * @author zzkk
 * @date [2021-03-16 13:12]
 * @description 服务实现类
 */
@Service
public class ByeServiceImpl implements ByeService {

    @Override
    public String bye(String name) {
        return "bye," + name;
    }

}
