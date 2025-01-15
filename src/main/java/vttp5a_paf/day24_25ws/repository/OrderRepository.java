package vttp5a_paf.day24_25ws.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import vttp5a_paf.day24_25ws.model.Order;
import vttp5a_paf.day24_25ws.model.OrderDetail;
import vttp5a_paf.day24_25ws.utils.Queries;

@Repository
public class OrderRepository {
    
    @Autowired
    private JdbcTemplate template;

    public int saveOrder(Order o) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(Queries.INSERT_ORDER_SQL, 
                new String[]{"order_date", "customer_name", "ship_address", "notes"});
                ps.setDate(1, o.getOrderDate());
                ps.setString(2, o.getCustomerName());
                ps.setString(3, o.getShipAddress());
                ps.setString(4, o.getNotes());

                return ps;
            }
            
        };

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(psc, keyHolder);

        int orderId = keyHolder.getKey().intValue();

        return orderId;
    }

    public Boolean saveOrderDetails(OrderDetail od, int orderId) {
        try {
            template.update(Queries.INSERT_ORDER_DETAIL_SQL, od.getProduct(), od.getUnitPrice(),
            od.getDiscount(), od.getQuantity(), orderId);
            return true;
        } catch (Exception e) {
            System.out.println("Error in adding order details!");
            return false;
        }
    }
}
