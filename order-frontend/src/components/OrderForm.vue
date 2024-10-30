<template>
  <div>
      <h2>Order Form</h2>
      <form @submit.prevent="submitOrder">
          <label for="customerId">Customer ID:</label>
          <input type="text" v-model="order.customerId" required />
          
          <label for="productIds">Product IDs (comma separated):</label>
          <input type="text" v-model="order.productIds" required />
          
          <label for="quantity">Quantity:</label>
          <input type="number" v-model="order.quantity" required />
          
          <button type="submit">{{ isEditing ? 'Update Order' : 'Create Order' }}</button>
      </form>
  </div>
</template>

<script>
export default {
  data() {
      return {
          order: {
              customerId: '',
              productIds: '',
              quantity: 0,
          },
          isEditing: false,
          orderId: null,
      };
  },
  methods: {
      submitOrder() {
          if (this.isEditing) {
              this.$store.dispatch('updateOrder', { id: this.orderId, order: this.order });
          } else {
              this.$store.dispatch('createOrder', this.order);
          }
          this.resetForm();
      },
      resetForm() {
          this.order = { customerId: '', productIds: '', quantity: 0 };
          this.isEditing = false;
          this.orderId = null;
      },
      editOrder(order) {
          this.order = { ...order };
          this.isEditing = true;
          this.orderId = order.id;
      },
  },
  mounted() {
      this.$store.dispatch('fetchOrders');
  },
};
</script>
