<template>
    <div>
        <h2>Order List</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Customer ID</th>
                    <th>Product IDs</th>
                    <th>Quantity</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="order in orders" :key="order.id">
                    <td>{{ order.id }}</td>
                    <td>{{ order.customerId }}</td>
                    <td>{{ order.productIds.join(', ') }}</td>
                    <td>{{ order.quantity }}</td>
                    <td>{{ order.status }}</td>
                    <td>
                        <button @click="editOrder(order)">Edit</button>
                        <button @click="deleteOrder(order.id)">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>
        <OrderForm @editOrder="editOrder" />
    </div>
</template>

<script>
import OrderForm from './OrderForm.vue';

export default {
    components: {
        OrderForm,
    },
    computed: {
        orders() {
            return this.$store.state.orders;
        },
    },
    methods: {
        editOrder(order) {
            this.$refs.orderForm.editOrder(order);
        },
        deleteOrder(id) {
            this.$store.dispatch('deleteOrder', id);
        },
    },
    mounted() {
        this.$store.dispatch('fetchOrders');
    },
};
</script>
