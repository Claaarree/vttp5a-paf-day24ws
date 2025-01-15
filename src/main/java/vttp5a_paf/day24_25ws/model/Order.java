package vttp5a_paf.day24_25ws.model;

import java.sql.Date;
import java.util.List;

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

    
}
