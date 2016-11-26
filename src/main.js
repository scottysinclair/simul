import Vue from 'vue'
import Router from 'vue-router'
import GameListing from './components/GameListing.vue'
import Report from './components/Report.vue'

Vue.config.debug = true
// install router
Vue.use(Router)

const routes = [
  { path: '/', component: GameListing },
  { path: '/report/:reportType', component: Report }
]

// routing
var router = new Router({
  routes // short for routes: routes
})

// router.beforeEach(function () {
//  window.scrollTo(0, 0)
// })

// router.redirect({
//  '*': '/home/index.html'
// })

// 4. Create and mount the root instance.
// Make sure to inject the router with the router option to make the
// whole app router-aware.
new Vue({
  router
}).$mount('#app')
