<template>
  <div>
    <h1>{{report.name }}</h1>
    <div v-if="report.parentReport !== undefined && report.parentReport !== null">
    Parent Report <router-link :to="'/report/' + report.parentReport">
    {{state.getReport( report.parentReport ).name}}
    </router-link>
    </div>
    <br/>
    <p>{{report.description}}</p>
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
    <div id="chartdiv" style="width: 640px; height: 400px;"></div>
  </div>
</template>
<script>
import store from 'components/store.js'
/* eslint-disable no-unused-vars */
import amcharts from 'amcharts3/amcharts/amcharts.js'
/* eslint-disable no-unused-vars */
import serial from 'amcharts3/amcharts/serial.js'

console.log('imported store into Report.vue')
console.log(store)

export default {
  name: 'report',
  data () {
    return {
      state: store.state,
      chart: null
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

  },
  beforeUpdate: function () {
    console.log('before update')
    console.log('BF creating chart???')
    const that = this
    if (this.report.chart !== null) {
      window.fetch('/gamesrv/chart/' + this.$route.params.reportType)
      .then(function (response) {
        return response.json()
      })
      .then(function (chart) {
        console.log(chart)
        that.chart = window.AmCharts.makeChart('chartdiv', chart)
      })
    }
  }
/*  watch: {
    $route: function (route) {
      if (this.chart !== null) {
        this.chart.clear()
      }
      console.log('creating chart???')
      if (this.report.chart !== null) {
        this.chart = window.AmCharts.makeChart('chartdiv', this.report.chart)
      }
    }
  } */
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
