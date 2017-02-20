package com.example.disconf.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.disconf.demo.config.JedisConfig;

@Service
public class DisconfDemoTask {
	protected static final Logger LOGGER = LoggerFactory.getLogger(DisconfDemoTask.class);

	@Autowired
	private JedisConfig jedisConfig;
    public int run() {
    	try {
            while (true) {
                Thread.sleep(5000);
                System.out.println("redis( " + jedisConfig.getHost() + ","+ jedisConfig.getPort()+")");
            }
        } catch (Exception e) {
            LOGGER.error("", e);
        }
        return 0;
    }
}
