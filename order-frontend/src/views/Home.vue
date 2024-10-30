<template>
    <div class="home">
        <h1>Order Management</h1>
        <!-- Afficher la liste des commandes -->
        <OrderList />
        
        <!-- Formulaire pour ajouter ou modifier une commande -->
        <OrderForm />
    </div>
</template>

<script>
// Importer les composants nécessaires
import OrderList from '@/components/OrderList.vue';
import OrderForm from '@/components/OrderForm.vue';

export default {
    name: 'HomeView',
    components: {
        OrderList,
        OrderForm,
    },
};
</script>

<style scoped>
.home {
    display: flex;
    flex-direction: column;
    align-items: center;
}
h1 {
    color: #333;
}
</style>
