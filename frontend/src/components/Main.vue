<template>
  <v-layout id="map"/>
</template>

<script>
import Vue from 'vue'
import mapImage from '../assets/floor5_2.svg'
/* import SaveSeatPopup from './SaveSeatPopup' */
import SeatInfoPopup from './SeatInfoPopup'
export default {
  name: 'Main',
  data () {
    return {
      map: null,
      imageOverlay: null,
      layers: [],
      mapImage: mapImage,
      searchItems: [],
      searchStr: ''
    }
  },
  methods: {
    searchUser: function (val) {
      console.log(val)
    },
    saveSeat: function (item) {
      console.log('searchUser')
    },
    OccupiedSeat: function (data) {
      const L = window['L']
      L.circle([-77.7, 55.2], {color: 'green', radius: 5})
        .addTo(this.map).bindTooltip('Name B', {permanent: true, direction: 'center'}).openTooltip().bindPopup('iwatsuki <br />IT Support Department')
    }
  },
  computed: {
  },
  created () {
    this.$eventBus.$on('searchUser', this.searchUser)
    this.$eventBus.$on('saveSeatEvent', this.saveSeat)
  },
  mounted () {
    const L = window['L']
    this.map = L.map('map', {
      minZoom: 1,
      maxZoom: 4,
      center: [0, 0],
      zoom: 1,
      crs: L.CRS.Simple
    })

    const w = 6000
    const h = 2500
    const southWest = this.map.unproject([0, h], this.map.getMaxZoom() - 1)
    const northEast = this.map.unproject([w, 0], this.map.getMaxZoom() - 1)
    let bounds = new L.LatLngBounds(southWest, northEast)

    this.imageOverlay = L.imageOverlay(
      mapImage, bounds
    )
    const overlay = this.imageOverlay.addTo(this.map)
    this.map.setMaxBounds(bounds)
    let popup = L.popup({minWidth: 300})
    this.map.on('click', (e) => {
      console.log(e)
      let ComponentClass = Vue.extend(SeatInfoPopup)
      let instance = new ComponentClass()
      /*
      let ComponentClass = Vue.extend(SaveSeatPopup)
      let instance = new ComponentClass({propsData: {items: this.searchItems}})
      */
      instance.$mount()
      popup
        .setLatLng(e.latlng)
        .setContent(instance.$el)
        .openOn(this.map)
    })
    this.OccupiedSeat()
    console.log(overlay)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  #map {
    z-index: 100;
    height: 600px;
    background-color: white;
  }
</style>
