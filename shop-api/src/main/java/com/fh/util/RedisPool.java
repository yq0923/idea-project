package com.fh.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
    //最大连接数
    private static  final int MAX_TOTAL=500;
    //最小空闲连接数
    private static  final int MIN_IDLE=100;
    //最大空闲连接数
    private static  final int MAX_IDLE=400;
    //Redis服务IP地址
    private static  final String REDIS_SERVICE_IP="192.168.94.128";
    //Redis服务器口号
    private static  final int REDIS_SERVICE_PORT=6379;

    private static  final String REDIS_SERVER_PASSWORD="123456";
    private static JedisPool jedisPool;
    // 静态块，只执行一次，在加载类的时候执行
    static {
        initPool();
    }
    private  static void initPool(){
        //实例化一个Jedis连接池配置对象
        JedisPoolConfig config= new JedisPoolConfig();
        config.setMaxTotal(MAX_TOTAL);
        config.setMinIdle(MIN_IDLE);
        config.setMaxIdle(MAX_IDLE);
        //实例化一个Jedis连接池对象
        jedisPool =new JedisPool(config,REDIS_SERVICE_IP,REDIS_SERVICE_PORT,100,REDIS_SERVER_PASSWORD);

    }
    public static Jedis getResource() {
        return jedisPool.getResource();
    }
}

