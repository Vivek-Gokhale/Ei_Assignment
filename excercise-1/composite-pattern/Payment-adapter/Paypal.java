// PayPal class: already compatible with Payment interface
class PayPal implements Payment {

    // directly implements Payment interface method
    @Override
    public void pay(double amount) {
        System.out.println("PayPal processed payment of $" + amount);
    }
}
