package cn.tedu.straw.api.question.util;

import io.netty.util.concurrent.BlockingOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class RedisUtils {

    @Autowired
    RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();

    public boolean delete(String key){
        return  redisTemplate.delete(key);
    }

    public long rightPush(String key,Serializable serializable){
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        return ops.rightPush(key,serializable);
    }

    public List<Serializable> ListRange(String key){
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        return ops.range(key,0,ops.size(key));
    }
    public List<Serializable> ListRange(String key,long start,long end){
        ListOperations<String, Serializable> ops = redisTemplate.opsForList();
        return ops.range(key,start,end);
    }
}
