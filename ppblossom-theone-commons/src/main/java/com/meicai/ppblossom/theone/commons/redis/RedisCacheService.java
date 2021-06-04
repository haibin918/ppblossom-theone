package com.meicai.ppblossom.theone.commons.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.StringBuffer;

@Slf4j
@Component
public class RedisCacheService {


    @Autowired
    private JedisCluster jedis;

    public String getRedisCache(String key) {
        if (!jedis.exists(key))
            return null;
        return jedis.get(key);
    }

    public void setRedisCache(String key,String value,int times){
        jedis.setex(key,times,value);
    }


    public void setRedisCacheForever(String key, String value) {
        jedis.psetex(key, 32227200000L, value);
    }


    public void setRedisCacheMonth(String key, String value) {
        jedis.psetex(key, 2592000000L, value);
    }


    public void setRedisCacheUpdateByDay(String key, String value) {
        jedis.psetex(key, getExpire(), value);
    }


    public String getRedisCacheUpdateByDataCycle(String key, String dataCycle) {
        if (!jedis.exists(key))
            return null;
        //存储的日期和查询日期相等，就返回存储的日期
        String valuePackStr = jedis.get(key);
        JSONObject valuePack = JSONObject.parseObject(valuePackStr);
        String datekey = valuePack.getString("datekey");
        if (datekey.equals(dataCycle))
            return valuePack.get("value").toString();
        //存储的日期和查询的日期不相等，就清除当前缓存
        jedis.del(key);
        return null;
    }


    public void setRedisCacheUpdateByDataCycle(String key, String value, String dataCycle) {
        JSONObject valuePack = new JSONObject();
        valuePack.put("datekey", dataCycle);
        valuePack.put("value", value);
        jedis.set(key, JSON.toJSONString(valuePack));
    }


    public void delRedisCache(String pattern) {
        TreeSet<String> keys = getRedisKeys(pattern);
        log.info("redis pattern = " + pattern + ", keys.size() = " + keys.size());
        log.info("开始删除redis by pattern");
        keys.forEach(key -> jedis.del(key));
        log.info("结束删除redis by pattern");
    }


    public int countRedisCache(String pattern) {
        TreeSet<String> keys = getRedisKeys(pattern);
        return keys.size();
    }

    //获取失效时间，毫秒（今天到明天上午7点的时间戳之差）
    private Long getExpire() {
        Date now = new Date();
        //当前时间的毫秒
        Long nowMs = now.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        Integer hours = Integer.valueOf(sdf.format(now));
        //如果当前时间大于早上七点，取明天七点的时间戳
        if (hours >= 7) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(now);
            calendar.add(Calendar.DATE, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 7);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            //明天七点
            long tomorrow7 = calendar.getTimeInMillis();
            return tomorrow7 - nowMs;
        } else {
            //如果当前时间小于早上七点，取当天七点的时间戳
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(now);
            calendar.add(Calendar.DATE, 0);
            calendar.set(Calendar.HOUR_OF_DAY, 7);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            //今天七点
            long today7 = calendar.getTimeInMillis();
            return today7 - nowMs;
        }

    }

    private TreeSet<String> getRedisKeys(String pattern) {
        log.info("get all redis keys start");

        TreeSet<String> keys = new TreeSet<>();
        Map<String, JedisPool> clusterNodes = jedis.getClusterNodes();
        for (String node : clusterNodes.keySet()) {
            log.info("getting keys from {}", node);
            JedisPool jp = clusterNodes.get(node);
            Jedis connection = jp.getResource();
            try {
                keys.addAll(connection.keys(pattern));
            } catch (Exception e) {
                log.error("Getting keys error: {}", e);
            } finally {
                log.debug("Connection closed.");
                connection.close();//用完一定要close这个链接！！！
            }
        }
        log.info("get all redis keys end");
        return keys;
    }


    public void setRedisCacheUpdateByMillisecond(String key, String value, long milliseconds) {
        jedis.psetex(key, milliseconds, value);
    }

    public Long increaseAndExpire(String key, int seconds) {
        StringBuffer sb = new StringBuffer();
        sb.append("local key = KEYS[1]\n");
        sb.append("local ttl = tonumber(ARGV[1])\n");
        sb.append("local autoIncrId = redis.call(\"incr\",key)\n");
        sb.append("if autoIncrId == 1 then \n");
        sb.append("redis.call(\"expire\",key,ttl)\n");
        sb.append("end\n");
        sb.append("return autoIncrId\n");

        Object num = jedis.eval(sb.toString(), 1, key, Integer.toString(seconds));
        return Long.parseLong(String.valueOf(num));
    }

    public void setHsetRedis(String hset, String key, String value) {

        jedis.hset(hset, key, value);
    }

    public String getHsetRedis(String hset, String key) {
        return jedis.hget(hset, key);
    }

    /**
     * 获取hash所有的key
     * @param key
     * @return
     */
    public Set<String> getKeysHashRedis(String key){
        return jedis.hkeys(key);
    }

    /**
     * 获取hash所有的value
     * @param key
     * @return
     */
    public List<String> getValuesHashRedis(String key){
        return jedis.hvals(key);
    }


    public Long deleteHsetRedis( String key) {
        log.info("RedisCacheService_deleteHsetRedis key "+key);
        return jedis.del(key);
    }

    public String setex( String key,int expireTime,String value) {
        return jedis.setex(key,expireTime,value);
    }

    /**
     * 查看键的剩余生存时间
     * @param key
     * @return
     */
    public Long getTtl(String key){
        Long ttl = jedis.ttl(key);
        return ttl;
    }

    /**
     * 获取重新set
     * GETSET is an atomic set this value and return the old value command
     * @param key
     * @param value
     * @return
     */
    public String getSet(String key,String value){
        String set = jedis.getSet(key, value);
        return set;
    }

    /**
     *
     * @param key
     * @return
     */
    public Map<String,String> hgetAll(String key){
        Map<String, String> redisMap = jedis.hgetAll(key);
        return redisMap;

    }

    /**
     *hmset
     * @param key
     * @param redisMap
     * @return
     */
    public String hmset(String key,Map<String,String> redisMap) {
        String result = jedis.hmset(key, redisMap);
        return result;
    }

    /**
     *批量keys删除
     * @param keys
     * @return
     */
    public Long batchDelCache(String... keys){
        return jedis.del(keys);
    }

    /**
     * 批量获取redis的value值
     * @param keys
     * @return
     */
    public List<String> mget(String... keys){
        List<String> list = jedis.mget(keys);
        //去掉所有的null
        list.removeAll(Collections.singleton(null));
        return list;
    }
}
