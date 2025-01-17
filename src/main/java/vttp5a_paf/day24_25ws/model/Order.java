package vttp5a_paf.day24_25ws.model;

import java.sql.Date;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

public class Order {
    
    private int orderId;

    private Date orderDate;

    private String customerName;

    private String shipAddress;

    private String notes;

    private Double tax;

    private List<OrderDetail> lineItems;

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public List<OrderDetail> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<OrderDetail> lineItems) {
        this.lineItems = lineItems;
    }

    public static JsonObject toJson(Order o) {
        JsonArrayBuilder jArrayBuilder = Json.createArrayBuilder();
        for (OrderDetail od : o.getLineItems()) {
            JsonObject jsonObject = OrderDetail.toJson(od);
            jArrayBuilder.add(jsonObject);
        }

        JsonObject orderJsonObject = Json.createObjectBuilder()
                .add("customer_name", o.getCustomerName())
                .add("ship_address", o.getShipAddress())
                .add("notes", o.getNotes())
                .add("tax", o.getTax())
                .add("line_items", jArrayBuilder.build())
                .build();

        return orderJsonObject;
    }
}
