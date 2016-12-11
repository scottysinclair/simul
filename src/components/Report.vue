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
    <div id="chartdiv" style="width: 1240px; height: 400px;"></div>
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
        var xx = {
          'type': 'serial',
          'theme': 'light',
          'dataProvider': [ {
            'country': 'USA',
            'visits': 2025
          }, {
            'country': 'China',
            'visits': 1882
          }, {
            'country': 'Japan',
            'visits': 1809
          }, {
            'country': 'Germany',
            'visits': 1322
          }, {
            'country': 'UK',
            'visits': 1122
          }, {
            'country': 'France',
            'visits': 1114
          }, {
            'country': 'India',
            'visits': 984
          }, {
            'country': 'Spain',
            'visits': 711
          }, {
            'country': 'Netherlands',
            'visits': 665
          }, {
            'country': 'Russia',
            'visits': 580
          }, {
            'country': 'South Korea',
            'visits': 443
          }, {
            'country': 'Canada',
            'visits': 441
          }, {
            'country': 'Brazil',
            'visits': 395
          } ],
          'valueAxes': [ {
            'gridColor': '#FFFFFF',
            'gridAlpha': 0.2,
            'dashLength': 0
          } ],
          'gridAboveGraphs': true,
          'startDuration': 1,
          'graphs': [ {
            'balloonText': '[[category]]: <b>[[value]]</b>',
            'fillAlphas': 0.8,
            'lineAlpha': 0.2,
            'type': 'column',
            'valueField': 'visits'
          } ],
          'chartCursor': {
            'categoryBalloonEnabled': false,
            'cursorAlpha': 0,
            'zoomable': false
          },
          'categoryField': 'country',
          'categoryAxis': {
            'gridPosition': 'start',
            'gridAlpha': 0,
            'tickPosition': 'start',
            'tickLength': 20
          },
          'export': {
            'enabled': true
          }
        }
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
