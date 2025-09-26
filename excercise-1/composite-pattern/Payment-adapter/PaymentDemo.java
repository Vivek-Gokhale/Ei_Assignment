import java.util.ArrayList;
public class PaymentDemo {
    public static void main(String[] args) {
        ArrayList<Payment> payments = new ArrayList<>();

        // Add PayPal (already implements Payment)
        payments.add(new PayPal());

        // Add Stripe through Adapter
        payments.add(new StripeAdapter(new Stripe()));

        // Execute payments
        for (Payment p : payments) {
            p.pay(150.0); // all can be called uniformly
        }
    }
}
