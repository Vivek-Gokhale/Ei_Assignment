// Adaptee class: Stripe has its own payment method, not compatible with Payment interface
class Stripe {
    
    // Stripe-specific payment method
    public void makePayment(double amount) {
        System.out.println("Stripe processed payment of $" + amount);
    }
}
