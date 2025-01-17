package vttp5a_paf.day24_25ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import vttp5a_paf.day24_25ws.model.Order;
import vttp5a_paf.day24_25ws.repository.ListRepo;
import vttp5a_paf.day24_25ws.utils.Constants;

@Service
public class RegistrationService {
    
    @Autowired
    private ListRepo registrationRepo;

    // @Autowired
    // private RedisTemplate<String, String> template;

    public void addToRegistration(String customerName) {
        registrationRepo.addToListStart(Constants.REGISTATIONS_REDIS_KEY, customerName);
    }

    public List<String> getRegistrations() {
        return registrationRepo.getList(Constants.REGISTATIONS_REDIS_KEY);
    }

    public void saveOrder(Order o) {
        registrationRepo.addToListEnd(Constants.CUSTOMER_NAME, Order.toJson(o).toString());

        // can either or! if save to redis then no need convertAndSend()
        // template.convertAndSend(Constants.CUSTOMER_NAME, Order.toJson(o).toString());
    }

}
