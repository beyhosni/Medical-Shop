<template>
    <div class="not-found">
        <h1>404</h1>
        <h2>Page non trouvée</h2>
        <router-link to="/">Retour à l'accueil</router-link>
    </div>
</template>

<script>
export default {
    name: 'NotFoundView'
}
</script>

<style scoped>
.not-found {
    text-align: center;
    padding: 50px;
}

h1 {
    font-size: 72px;
    color: #e74c3c;
}

a {
    color: #3498db;
    text-decoration: none;
}
</style> 