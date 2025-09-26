
// Adapter to make Stripe compatible with Payment interface
class StripeAdapter implements Payment {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void pay(double amount) {
        stripe.makePayment(amount); // delegate to Stripe
    }
}
