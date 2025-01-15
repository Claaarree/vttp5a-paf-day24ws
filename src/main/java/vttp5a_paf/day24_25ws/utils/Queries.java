package vttp5a_paf.day24_25ws.utils;

public class Queries {
    
    public static String INSERT_ORDER_SQL = """
            insert into orders(order_date, customer_name, ship_address, notes)
            values (?, ?, ?, ?)
            """;

    public static String INSERT_ORDER_DETAIL_SQL = """
            insert into order_details (product, unit_price, discount, quantity, order_id)
            values (?, ?, ?, ?, ?)
            """;
}
