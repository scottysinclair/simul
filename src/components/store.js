console.log('------------- PROCESSING STORE.JS -----------------------------')
export default {
  state: {
    reports: {
      '1': {
        id: 1,
        name: 'Report Types',
        columns: [
          {
            name: 'Name',
            type: 'string'
          }
        ],
        data: [
         ['Prisoner\'s Dilemma']
        ],
        subReports: [2]
      },
      '2': {
        id: 1,
        name: 'TitForTat vs TitFor2Tats',
        columns: [
          {
            name: 'Round',
            type: 'number'
          },
          {
            name: 'Payer A Card',
            type: 'string'
          },
          {
            name: 'Player B Card',
            type: 'string'
          },
          {
            name: 'Player A Balance',
            type: 'number'
          },
          {
            name: 'Player A Delta',
            type: 'number'
          },
          {
            name: 'Player B Balance',
            type: 'number'
          },
          {
            name: 'Player B Delta',
            type: 'number'
          }
        ],
        data: [
         [1, 'COOPERATE', 'COOPERATE', 0, 300, 0, 300],
         [2, 'COOPERATE', 'COOPERATE', 0, 600, 0, 600],
         [3, 'COOPERATE', 'COOPERATE', 0, 900, 0, 900],
         [4, 'COOPERATE', 'COOPERATE', 0, 1000, 0, 1000],
         [5, 'COOPERATE', 'COOPERATE', 0, 1300, 0, 1300],
         [6, 'COOPERATE', 'COOPERATE', 0, 1600, 0, 1600],
         [7, 'COOPERATE', 'COOPERATE', 0, 1800, 0, 1800],
         [8, 'COOPERATE', 'COOPERATE', 0, 2000, 0, 2000]
        ],
        subReports: []
      }

    },
    getReport: function (id) {
      return this.reports[ id ]
    }
  }
}
