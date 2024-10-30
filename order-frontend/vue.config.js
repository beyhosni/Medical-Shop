const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})


module.exports = {
  devServer: {
      proxy: {
          '/api': {
              target: 'http://localhost:8083',
              changeOrigin: true,
              pathRewrite: { '^/api': '' },
          },
      },
  },
};
