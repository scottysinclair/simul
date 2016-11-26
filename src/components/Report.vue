<template>
  <div>
    <h1>{{report.name }}</h1>
    <table>
    <thead>
      <tr>
        <th v-for="column in report.columns">{{column.name}}</th>
      </tr>
    </thead>
    <tbody>
    <tr v-for="row in report.data">
      <td v-for="item in row">{{item}}</td>
    </tr>
    </tbody>
    </table>
    <hr/>
    <ul>
      <li v-for="subReport in report.subReports"><router-link :to="'/report/' + subReport">{{state.getReport(subReport).name}}</router-link></li>
    </ul>
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
  },
  computed: {
    report: function () {
      return this.state.getReport(this.$route.params.reportType) // eslint-disable-line
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

table,  tr, td, th  {
  border: 1px solid black;
}
td, th {
  padding: 5px 5px 5px 5px;
}

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
