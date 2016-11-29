<template>
  <div>
    <h1>{{report.name }}</h1>
    <div v-if="report.parentReport !== undefined && report.parentReport !== null">
    Parent Report <router-link :to="'/report/' + report.parentReport">
    {{state.getReport( report.parentReport ).name}}
    </router-link>
    </div>
    <br/>
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

/* eslint-disable no-unused-vars */
var chart = window.AmCharts.makeChart('chartdiv', {
  'type': 'serial',
  'theme': 'light',
  'marginTop': 0,
  'marginRight': 80,
  'dataProvider': [{
    'year': '1950',
    'value': -0.307
  }, {
    'year': '1951',
    'value': -0.168
  }, {
    'year': '1952',
    'value': -0.073
  }, {
    'year': '1953',
    'value': -0.027
  }],
  'valueAxes': [{
    'axisAlpha': 0,
    'position': 'left'
  }],
  'graphs': [{
    'id': 'g1',
    'balloonText': '[[category]]<br><b><span style=\'font-size:14px;\'>[[value]]</span></b>',
    'bullet': 'round',
    'bulletSize': 8,
    'lineColor': '#d1655d',
    'lineThickness': 2,
    'negativeLineColor': '#637bb6',
    'type': 'smoothedLine',
    'valueField': 'value'
  }],
  'chartScrollbar': {
    'graph': 'g1',
    'gridAlpha': 0,
    'color': '#888888',
    'scrollbarHeight': 55,
    'backgroundAlpha': 0,
    'selectedBackgroundAlpha': 0.1,
    'selectedBackgroundColor': '#888888',
    'graphFillAlpha': 0,
    'autoGridCount': true,
    'selectedGraphFillAlpha': 0,
    'graphLineAlpha': 0.2,
    'graphLineColor': '#c2c2c2',
    'selectedGraphLineColor': '#888888',
    'selectedGraphLineAlpha': 1
  },
  'chartCursor': {
    'categoryBalloonDateFormat': 'YYYY',
    'cursorAlpha': 0,
    'valueLineEnabled': true,
    'valueLineBalloonEnabled': true,
    'valueLineAlpha': 0.5,
    'fullWidth': true
  },
  'dataDateFormat': 'YYYY',
  'categoryField': 'year',
  'categoryAxis': {
    'minPeriod': 'YYYY',
    'parseDates': true,
    'minorGridAlpha': 0.1,
    'minorGridEnabled': true
  },
  'export': {
    'enabled': true
  }
})

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
