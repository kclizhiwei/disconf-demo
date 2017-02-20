package com.example.disconf.demo.service.callbacks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.example.disconf.demo.config.JedisConfig;
import com.example.disconf.demo.service.SimpleRedisService;
@Service
@Scope("singleton")
@DisconfUpdateService(classes = {JedisConfig.class}, itemKeys = {"redis.host","redis.port"})
public class SimpleRedisServiceUpdateCallback implements IDisconfUpdate{
	protected static final Logger LOGGER = LoggerFactory.getLogger(SimpleRedisServiceUpdateCallback.class);

    @Autowired
    private SimpleRedisService simpleRedisService;
    /**
     *
     */
    public void reload() throws Exception {

        simpleRedisService.changeJedis();
    }

}
