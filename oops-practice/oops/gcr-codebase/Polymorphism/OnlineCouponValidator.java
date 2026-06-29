/*
2. Online Coupon Validator
An e-commerce website validates discount coupons.
● Create an interface CouponValidator containing:
○ abstract method validateCoupon(String code)
○ static method isLengthValid(String code)
● Store coupon codes in a String[].
● Implement the interface in a class ShoppingCart.
Task: Check each coupon from the array and print whether it is valid or
invalid. */


interface CouponValidator{
  void validateCoupon(String code);

  static boolean isLengthValid(String code){
    return code.length()==5;
  }
}
class ShoppingCart implements CouponValidator{
    public void validateCoupon(String code) {

        if (CouponValidator.isLengthValid(code)) {
            System.out.println("valid" );
        } else {
            System.out.println("Invalid Coupon");
        }
    }
}
public class OnlineCouponValidator {
    public static void main(String[] args) {

        String[] coupons = { "HELLO", "DISCOUNT"};

        ShoppingCart cart = new ShoppingCart();

        for (String code : coupons) {
            cart.validateCoupon(code);
        }
    }
}



