package vttp5a_paf.day24_25ws.service;

import java.time.Instant;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import vttp5a_paf.day24_25ws.model.Order;
import vttp5a_paf.day24_25ws.model.OrderDetail;
import vttp5a_paf.day24_25ws.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;
    
    // {customerName=[hello], shipAddress=[bye], notes=[lala], product=[as, wer], 
    // unitPrice=[0.1, 0.1], quantity=[1, 1]}
    public Boolean addOrder(MultiValueMap<String, String> form){

        Order o = new Order();
        o.setOrderDate(new Date(Instant.now().toEpochMilli()));
        o.setCustomerName(form.getFirst("registration"));
        // o.setCustomerName(form.getFirst("customerName"));
        o.setShipAddress(form.getFirst("shipAddress"));
        o.setNotes(form.getFirst("notes"));
        o.setTax(0.05);

        int order_id = orderRepo.saveOrder(o);

        List<String> products = form.get("product");
        List<String> unitPrice = form.get("unitPrice");
        List<String> quantity = form.get("quantity");

        List<OrderDetail> lineItems = new ArrayList<>();
        
        for (int i = 0; i < products.size(); i++) {
            double discount = Math.random();
            OrderDetail od = new OrderDetail();
            od.setDiscount(discount);
            od.setProduct(products.get(i));
            od.setUnitPrice(Double.parseDouble(unitPrice.get(i)));
            od.setQuantity(Integer.parseInt(quantity.get(i)));

            lineItems.add(od);

            Boolean isSaved = orderRepo.saveOrderDetails(od, order_id);

            if (!isSaved){
                return false;
            }
        }
        o.setLineItems(lineItems);
        return true;
    }
}
