package vttp5a_paf.day24_25ws.repository;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ListRepo {
    
    @Autowired
    @Qualifier("String-String")
    RedisTemplate<String, String> redisTemplate;

    public void addToListStart(String redisKey, String redisValue) {
        redisTemplate.opsForList().leftPush(redisKey, redisValue);
    }

    public void addToListEnd(String redisKey, String redisValue) {
        redisTemplate.opsForList().rightPush(redisKey, redisValue);
    }

    public void removeFromListStart(String redisKey) {
        redisTemplate.opsForList().leftPop(redisKey);
    }

    public void removeFromListEnd(String redisKey) {
        redisTemplate.opsForList().rightPop(redisKey);
    }

    public void addToList(String redisKey, String valueToAdd, String afterValueToAdd) {
        redisTemplate.opsForList().leftPush(redisKey, afterValueToAdd, valueToAdd);
    }

    public void removeFromList(String redisKey, String redisValue) {
        redisTemplate.opsForList().remove(redisKey, 1, redisValue);
    }

    public String getByIndex(String redisKey, Integer index) {
        String redisValue = redisTemplate.opsForList().index(redisKey, index);
        return redisValue;
    }

    public Long getIndexOfValue(String redisKey, String redisValue) {
        Long index = redisTemplate.opsForList().indexOf(redisKey, redisValue);
        return index;
    }

    public void editValue(String redisKey, String oldValue, String newValue) {
        redisTemplate.opsForList().set(redisKey, getIndexOfValue(redisKey, oldValue), newValue);
    }

    public List<String> getList(String redisKey) {
        List<String> allElements = redisTemplate.opsForList().range(redisKey, 0, -1);
        return allElements;
    }

    public Long getListLength(String redisKey) {
        return redisTemplate.opsForList().size(redisKey);
    }

    public void expire(String redisKey, Long expireValue) {
        Duration expireDuration = Duration.ofSeconds(expireValue);
        redisTemplate.expire(redisKey, expireDuration);
    }
}
