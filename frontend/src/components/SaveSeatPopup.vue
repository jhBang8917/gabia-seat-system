<template>
  <v-layout justify-center column ma-3>
    <v-flex>
      <v-text-field
        v-model="userId"
        label="userId">
      </v-text-field>
      <v-text-field
        v-model="userName"
        label="userName">
      </v-text-field>
    </v-flex>
    <!--<v-autocomplete
      v-model="selectItem"
      :items="items"
      :search-input.sync="search"
      clearable
      hide-details
      hide-selected
      item-text="name"
      item-value="symbol"
      label="Search for a member..."
      solo
    >
      <template slot="no-data">
        <v-list-tile>
          <v-list-tile-title>
            No Member
          </v-list-tile-title>
        </v-list-tile>
      </template>
      <template
        slot="item"
        slot-scope="{ item }"
      >
        <v-list-tile-avatar
          color="indigo"
          class="headline font-weight-light white&#45;&#45;text"
        >
          {{ item.name.charAt(0) }}
        </v-list-tile-avatar>
        <v-list-tile-content>
          <v-list-tile-title v-text="item.name"></v-list-tile-title>
          <v-list-tile-sub-title v-text="item.symbol"></v-list-tile-sub-title>
        </v-list-tile-content>
        <v-list-tile-action>
          <v-icon>mdi-coin</v-icon>
        </v-list-tile-action>
      </template>
    </v-autocomplete>-->
    <v-btn block color="secondary" dark @click="saveSeat">save</v-btn>
  </v-layout>
</template>

<script>
export default {
  name: 'SaveSeatPopup',
  props: {
    items: {
      type: Array,
      require: true,
      default: () => []
    }
  },
  data () {
    return {
      search: '',
      selectItem: null,
      userName: '',
      userId: ''
    }
  },
  watch: {
    search (val) {
      if (!val || val.length < 1) return
      this.$eventBus.$emit('searchUser', val)
    }
  },
  methods: {
    saveSeat: function () {
      /* this.$eventBus.$emit('saveSeatEvent', this.selectItem) */
      this.$eventBus.$emit('saveSeatEvent', {'userId': this.userId, 'userName': this.userName})
    }
  }

}
</script>
<style scoped>

</style>
