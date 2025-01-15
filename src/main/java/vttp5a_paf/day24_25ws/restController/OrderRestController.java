package vttp5a_paf.day24_25ws.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp5a_paf.day24_25ws.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    @Autowired 
    OrderService orderService;
    
    @PostMapping(path = "/order", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
    produces = "application/json")
    public ResponseEntity<String> handleOrderForm(@RequestBody MultiValueMap<String, String> form) {
        Boolean isSaved = orderService.addOrder(form);
        if (isSaved){
            return ResponseEntity.ok().body("Successfully saved!");
        }
        return ResponseEntity.badRequest().body("Error saving order");
    }
}
