package com.java.tao.redis.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * ****************************** key **************************************
     */

    /**
     * 设置过期时间
     * @param key
     * @param seconds
     * @return
     */
    public Boolean expire(String key, Long seconds){
        try {
            if(seconds>0L){
                return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取过期时间，0表示永久有效
     * @param key
     * @return
     */
    public Long getExpire(String key){
        try {
            return redisTemplate.getExpire(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public Boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除数据，返回删除的个数
     * @param key
     * @return
     */
    public Long delete(String... key){
        if(key!=null && key.length>0){
            if(key.length==1){
                Boolean delete = redisTemplate.delete(key[0]);
                if(delete){
                    return 1L;
                }
            }else {
                return redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
        return 0L;
    }

    /**
     * ****************************** string **************************************
     */

    /**
     * 获取值，没有返回null
     * @param key
     * @return
     */
    public Object get(String key){
        try {
            return key==null? null:redisTemplate.opsForValue().get(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    public Boolean set(String key, Object value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置值，并设置生效时间。time<=0，表示无时限
     * @param key
     * @param value
     * @param second
     * @return
     */
    public Boolean set(String key, Object value, Long second){
        try {
            if(second>0L){
                redisTemplate.opsForValue().set(key, value, second);
            }else {
                redisTemplate.opsForValue().set(key, value);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 递增，返回0表示失败
     * @param key
     * @param delta
     * @return
     */
    public Long incr(String key, Long delta){
        try {
            if(delta>0L){
                return redisTemplate.opsForValue().increment(key, delta);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 递减，返回0表示失败
     * @param key
     * @param delta
     * @return
     */
    public Long decr(String key, Long delta){
        try {
            if(delta>0L){
                return redisTemplate.opsForValue().decrement(key, delta);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * ****************************** hash **************************************
     */

    /**
     * 获取某个hash的field的值
     * @param key
     * @param field
     * @return
     */
    public Object hget(String key, String field){
        try {
            return redisTemplate.opsForHash().get(key, field);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取hash对象
     * @param key
     * @return
     */
    public Map<Object, Object> hmget(String key){
        try {
            return redisTemplate.opsForHash().entries(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置某个hash的field的值
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Boolean hset(String key, String field, Object value){
        try {
            redisTemplate.opsForHash().put(key, field, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置某个hash的field的值，并设置过期时间。second<=0，表示没有时限
     * @param key
     * @param field
     * @param value
     * @param second
     * @return
     */
    public Boolean hset(String key, String field, Object value, Long second){
        try {
            redisTemplate.opsForHash().put(key, field, value);
            if(second>0L){
                expire(key, second);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置hash的值
     * @param key
     * @param map
     * @return
     */
    public Boolean hmset(String key, Map<String, Object> map){
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置hash的值，并设置失效时间。second<=0，表示没有时限
     * @param key
     * @param map
     * @param second
     * @return
     */
    public Boolean hmset(String key, Map<String, Object> map, Long second){
        try {
            redisTemplate.opsForHash().putAll(key, map);
            if(second>0L){
                expire(key, second);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除hash中key的field
     * @param key
     * @param fields
     * @return
     */
    public Long hdel(String key, Object... fields){
        try {
            return redisTemplate.opsForHash().delete(key, fields);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 判断hash-field是否存在
     * @param key
     * @param field
     * @return
     */
    public Boolean hHasKey(String key, Object field){
        try {
            return redisTemplate.opsForHash().hasKey(key, field);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 递增
     * @param key
     * @param field
     * @param incr
     * @return
     */
    public Long hincr(String key, Object field, Long incr){
        try {
            return redisTemplate.opsForHash().increment(key, field, incr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 递减
     * @param key
     * @param field
     * @param decr
     * @return
     */
    public Long hdecr(String key, Object field, Long decr){
        try {
            return redisTemplate.opsForHash().increment(key, field, -decr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * ****************************** list **************************************
     */

    /**
     * 获取list
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> lget(String key, Long start, Long end){
        try {
            return redisTemplate.opsForList().range(key, start, end);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取list的长度
     * @param key
     * @return
     */
    public Long lsize(String key){
        try {
            return redisTemplate.opsForList().size(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 通过索引index，获取list中的值
     * @param key
     * @param index
     * @return
     */
    public Object lgetIndex(String key, Long index){
        try {
            return redisTemplate.opsForList().index(key, index);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在list开头放入元素
     * @param key
     * @param value
     * @return
     */
    public Long lfset(String key, Object value){
        try {
            return redisTemplate.opsForList().leftPush(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 在list开头放入元素，设置时效。second<=0，表示不限时
     * @param key
     * @param value
     * @return
     */
    public Long lfset(String key, Object value, Long second){
        try {
            Long index = redisTemplate.opsForList().leftPush(key, value);
            if(second>0L){
                expire(key, second);
            }
            return index;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 在list结尾放入元素
     * @param key
     * @param value
     * @return
     */
    public Long lrset(String key, Object value){
        try {
            return redisTemplate.opsForList().rightPush(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 在list开头放入元素，设置时效。second<=0，表示不限时
     * @param key
     * @param value
     * @return
     */
    public Long lrset(String key, Object value, Long second){
        try {
            Long index = redisTemplate.opsForList().rightPush(key, value);
            if(second>0L){
                expire(key, second);
            }
            return index;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 在list开头放入list
     * @param key
     * @param list
     * @return
     */
    public Long lfsetList(String key, List<Object> list){
        try {
            return redisTemplate.opsForList().leftPushAll(key, list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 在list开头放入list，设置时效。second<=0，没有限制
     * @param key
     * @param list
     * @return
     */
    public Long lfsetList(String key, List<Object> list, Long second){
        try {
            Long s = redisTemplate.opsForList().leftPushAll(key, list);
            if(second>0L){
                expire(key, second);
            }
            return s;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 在list结尾放入list
     * @param key
     * @param list
     * @return
     */
    public Long lrsetList(String key, List<Object> list){
        try {
            return redisTemplate.opsForList().rightPushAll(key, list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 在list结尾放入list，设置时效。second<=0，没有限制
     * @param key
     * @param list
     * @return
     */
    public Long lrsetList(String key, List<Object> list, Long second){
        try {
            Long s = redisTemplate.opsForList().rightPushAll(key, list);
            if(second>0L){
                expire(key, second);
            }
            return s;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 在list某个索引放入元素
     * @param key
     * @param index
     * @param value
     * @return
     */
    public Boolean lsetIndex(String key, Long index, Object value){
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 在list某个索引放入元素，并设置时效。second<=0，没有限制
     * @param key
     * @param index
     * @param value
     * @return
     */
    public Boolean lsetIndex(String key, Long index, Object value, Long second){
        try {
            redisTemplate.opsForList().set(key, index, value);
            if(second>0L){
                expire(key, second);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 移除n个key下面的value
     * @param key
     * @param count
     * @param value
     * @return
     */
    public Long lremove(String key, Long count, Object value){
        try {
            return redisTemplate.opsForList().remove(key, count, value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * ****************************** set **************************************
     */

    /**
     * 根据key获取set
     * @param key
     * @return
     */
    public Set<Object> sget(String key){
        try {
             return redisTemplate.opsForSet().members(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断某个key的set中是否包含value
     * @param key
     * @param value
     * @return
     */
    public Boolean sHasKey(String key, Object value){
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 存入set
     * @param key
     * @param values
     * @return
     */
    public Long sset(String key, Object... values){
        try {
            return redisTemplate.opsForSet().add(key, values);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 存入set，并设置时效。second<=0，表示不限制
     * @param key
     * @param values
     * @return
     */
    public Long sset(String key, Long second, Object... values){
        try {
            Long s = redisTemplate.opsForSet().add(key, values);
            if(second>0L){
                expire(key, second);
            }
            return s;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 返回key的集合长度
     * @param key
     * @return
     */
    public Long ssize(String key){
        try {
            return redisTemplate.opsForSet().size(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 移除key中values的值
     * @param key
     * @param values
     * @return
     */
    public Long sremove(String key, Object... values){
        try {
            return redisTemplate.opsForSet().remove(key, values);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0L;
    }





}
