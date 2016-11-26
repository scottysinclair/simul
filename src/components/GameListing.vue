<template>
  <div>
    <h2>Types of games:</h2>
    <ul>
     <li v-for="gameType in gameTypes">
          <router-link v-bind:to="'/report/' + gameType">{{gameType}}</router-link>
    </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'types-of-games',
  data () {
    return {
      gameTypes: ['Prisoner\'s dilemma', 'chess']}
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

a {
  color: #42b983;
}
</style>
