
// PayPal class already compatible
class PayPal implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("PayPal processed payment of $" + amount);
    }
}