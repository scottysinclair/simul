<template>
  <div>
    <h1>Report for {{$route.params.reportType}} </h1>
    {{state.name}}
    <a v-on:click="changeName()">change it </a>
  </div>
</template>
<script>
import store from 'components/store.js'
console.log('imported store into Report.vue')
console.log(store)

export default {
  name: 'report',
  data () {
    return {
      state: store.state
    }
  },
  methods: {
    changeName: function (event) {
      this.state.name = 'Hello World Report'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
