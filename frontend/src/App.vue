<template>
  <v-app>
    <div>
      <img src="./assets/Search.png" class="gnb">
    </div>
    <v-content>
      <v-container fluid>
      <router-view/>
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
.gnb {
  width: 150%;
  height: 100px
}
</style>
