<template>
  <v-layout justify-center row ma-3>
    <v-flex xs12>
      <v-card>
        <v-card-title primary-title>
          <div class="headline">Seat Info</div>
        </v-card-title>
        <v-card-text class="text-xs-center">
          <v-img class="elevation-6"
                 src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
                 height="100px"
          >
          </v-img>
          <p>Oscar(박영준)</p>
          <p>하이웍스개발실 / 메일개발팀</p>
          <p>팀원 / 프로그래머</p>
          <p>내선번호 : 555</p>
        </v-card-text>
      </v-card>
    </v-flex>
  </v-layout>
</template>

<script>
export default {
  name: 'SeatInfoPopup'
}
</script>

<style scoped>

</style>
