package com.example.disconf.demo.config;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;

@Service
@Scope("singleton")
@DisconfFile(filename="redis.properties")
@DisconfUpdateService(classes={JedisConfig.class})
public class JedisConfig implements IDisconfUpdate {

	
	private String host;
	private String port;
	
	@DisconfFileItem(name="redis.host", associateField="host")
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	@DisconfFileItem(name="redis.port", associateField="port")
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
		System.out.println("set port");
	}
	@Override
	public void reload() throws Exception {
		System.out.println("Host: " + host + ", Port: " + port );
	}
}
