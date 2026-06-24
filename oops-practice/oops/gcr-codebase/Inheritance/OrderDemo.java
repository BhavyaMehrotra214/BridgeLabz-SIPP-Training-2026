class Order {
    String orderId;
    String orderDate;
    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    String getOrderStatus() {
        return "Order Placed";
    }
}
class ShippedOrder extends Order {

    String trackingNumber;

    ShippedOrder(String orderId,
                 String orderDate,
                 String trackingNumber) {

        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {

    String deliveryDate;

    DeliveredOrder(String orderId,
                   String orderDate,
                   String trackingNumber,
                   String deliveryDate) {

        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    String getOrderStatus() {
        return "Order Delivered";
    }
}
public class OrderDemo {
    public static void main(String[] args) {

        DeliveredOrder d =
                new DeliveredOrder(
                        "ORD101",
                        "20-06-2026",
                        "TRK555",
                        "22-06-2026");

        System.out.println("Order ID : " + d.orderId);
        System.out.println(d.getOrderStatus());
    }
}