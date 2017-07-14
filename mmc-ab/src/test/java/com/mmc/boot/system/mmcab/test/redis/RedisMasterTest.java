// Copyright (C) 2017-2017 GGWW All rights reserved
package com.mmc.boot.system.mmcab.test.redis;

import java.util.HashSet;

import com.mmc.boot.system.mmcab.test.BaseTest;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/** 
 * className: RedisMasterTest<br/>
 * Description: redis集群测试<br/>
 * Author: GW<br/>
 * CreateTime： 2017年7月14日<br/>
 *
 * History: (version) Author DateTime Note <br/>
 */
public class RedisMasterTest extends BaseTest {

	
	public static void main(String[] args) {
		JedisCluster cluster = RedisCluster.instance();
		cluster.set("user2", "test");
	}
	
	
	static class RedisCluster {
        
		private static JedisCluster jedisCluster;
		
        static {
        	// 集群节点集合
    		HashSet<HostAndPort> nodes = new HashSet<HostAndPort>();
    		
    		HostAndPort hostAndPort = new HostAndPort("10.0.20.221", 7006);  
            HostAndPort hostAndPort1 = new HostAndPort("10.0.20.221", 7001);  
            HostAndPort hostAndPort2 = new HostAndPort("10.0.20.221", 7002);  
            HostAndPort hostAndPort3 = new HostAndPort("10.0.20.221", 7003);  
            HostAndPort hostAndPort4 = new HostAndPort("10.0.20.221", 7004);  
            HostAndPort hostAndPort5 = new HostAndPort("10.0.20.221", 7005);
            HostAndPort hostAndPort6 = new HostAndPort("10.0.20.221", 7007);
            
            nodes.add(hostAndPort);
            nodes.add(hostAndPort1);
            nodes.add(hostAndPort2);
            nodes.add(hostAndPort3);
            nodes.add(hostAndPort4);
            nodes.add(hostAndPort5);
            nodes.add(hostAndPort6);
            
            //创建config  
            JedisPoolConfig poolConfig = new JedisPoolConfig();  
            //通过config创建集群实例  
            jedisCluster = new JedisCluster(nodes,poolConfig);
        }
        
        public static JedisCluster instance() {
        	return jedisCluster;
        }
	}
}
