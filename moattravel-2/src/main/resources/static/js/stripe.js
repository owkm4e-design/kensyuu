const stripe = Stripe('pk_test_51TWneCL1HIizIFvPHzXZD1742CCwq8KuuEzWGsjCoEPTIsb4qshCZ0QH8C0R4bS06EPbvkcluxtYwyPoNfV5w2VO00AQVIlRFW');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
    stripe.redirectToCheckout({
        sessionId: sessionId
    })
});