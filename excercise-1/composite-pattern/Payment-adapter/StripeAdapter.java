// Adapter: makes Stripe compatible with Payment interface
class StripeAdapter implements Payment {
    private Stripe stripe; // adaptee (Stripe class)

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe; // store the Stripe instance
    }

    @Override
    public void pay(double amount) {
        stripe.makePayment(amount); // delegate Payment call to Stripe's method
    }
}
