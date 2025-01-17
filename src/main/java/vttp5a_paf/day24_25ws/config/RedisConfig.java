package vttp5a_paf.day24_25ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    
    @Bean("String-String")
    RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connFac) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connFac);
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    // technically only need if using convertAndSend plus MessageListener
    // @Bean
    // RedisMessageListenerContainer createMessageListenerContainer(RedisConnectionFactory connFac) {
    //     RedisConnectionFactory redisConnectionFactory = connFac;
    //     RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    //     container.setConnectionFactory(redisConnectionFactory);
    //     container.addMessageListener(subscriber, ChannelTopic.of("mytopic"));

    //     return container;
    // }

}
