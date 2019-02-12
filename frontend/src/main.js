// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuetify from 'vuetify'
import 'vuetify/dist/vuetify.min.css'
import App from './App'
import router from './router'
import axios from 'axios'

Vue.config.productionTip = false
Vue.use(Vuetify)

Vue.prototype.$http = axios
/* component global bus event */
const event = function event (Vue) {
  Vue.prototype.$eventBus = Vue.$eventBus = new Vue()
}
Vue.use(event)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
