import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        orders: [],
        order: null,
    },
    mutations: {
        setOrders(state, orders) {
            state.orders = orders;
        },
        setOrder(state, order) {
            state.order = order;
        },
    },
    actions: {
        async fetchOrders({ commit }) {
            const response = await axios.get('http://localhost:8083/orders');
            commit('setOrders', response.data);
        },
        async fetchOrder({ commit }, id) {
            const response = await axios.get(`http://localhost:8083/orders/${id}`);
            commit('setOrder', response.data);
        },
        async createOrder({ dispatch }, order) {
            await axios.post('http://localhost:8083/orders', order);
            dispatch('fetchOrders');
        },
        async updateOrder({ dispatch }, { id, order }) {
            await axios.put(`http://localhost:8083/orders/${id}`, order);
            dispatch('fetchOrders');
        },
        async deleteOrder({ dispatch }, id) {
            await axios.delete(`http://localhost:8083/orders/${id}`);
            dispatch('fetchOrders');
        },
    },
});
