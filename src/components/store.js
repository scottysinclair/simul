console.log('------------- PROCESSING STORE.JS -----------------------------')

const store = {
  state: {
    reports: {
      '1': {
        id: 1,
        name: 'Placeholder',
        description: '',
        columns: [
          {
            name: 'Name',
            type: 'string'
          }
        ],
        data: [
         ['Prisoner\'s Dilemma Report', '2 mins ago']
        ]
      }
    },
    getReport: function (id) {
      return this.reports[ id ]
    }
  }
}

window.fetch('/gamesrv/report/1')
.then(function (response) {
  return response.json()
})
.then(function (report) {
  store.state.reports[report.id + ''] = report
})

export default store
