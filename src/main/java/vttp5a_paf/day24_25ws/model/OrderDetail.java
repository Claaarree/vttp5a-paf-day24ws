package vttp5a_paf.day24_25ws.model;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class OrderDetail {
    
    private int id;

    private String product;

    private double unitPrice;

    private double discount;

    private int quantity;

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static JsonObject toJson(OrderDetail od) {
        JsonObject jObject = Json.createObjectBuilder()
                .add("product", od.getProduct())
                .add("unit_price", od.getUnitPrice())
                .add("discount", od.getDiscount())
                .add("quantity", od.getQuantity())
                .build();

        return jObject;
    }
}
