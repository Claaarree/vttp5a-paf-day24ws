package vttp5a_paf.day24_25ws.component;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import vttp5a_paf.day24_25ws.utils.Constants;

@Component
public class MessagePoller {

    @Autowired
    @Qualifier("String-String")
    private RedisTemplate<String,String> template;
    
    @Async
    public void start() {
        Runnable poller = () -> {
            ListOperations<String, String> orderList = template.opsForList();
            while(true) {
                try {
                    Optional<String> option = Optional
                    .ofNullable(orderList.rightPop(Constants.CUSTOMER_NAME, Duration.ofSeconds(30)));
    
                    if(option.isEmpty()) {
                        continue;
                    }
                    String payload = option.get();
                    System.out.println(payload);
    
                } catch (Exception e) {
                    System.err.println(e.getMessage());            
                }
            }
        };
        Executors.newSingleThreadExecutor().execute(poller);

    }
}
