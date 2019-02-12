<template>
  <v-layout id="map"/>
</template>

<script>
import Vue from 'vue'
import mapImage from '../assets/floor5_2.svg'
import SaveSeatPopup from './SaveSeatPopup'
/* import SeatInfoPopup from './SeatInfoPopup' */
export default {
  name: 'Main',
  data () {
    return {
      map: null,
      imageOverlay: null,
      layers: [],
      mapImage: mapImage,
      searchItems: [],
      searchStr: '',
      location: ''
    }
  },
  methods: {
    searchUser: function (val) {
      console.log(val)
    },
    saveSeat: function (item) {
      let data = {'location': this.location, 'userId': item.userId, 'userName': item.userName}
      this.occupiedSeat(data)
      /* this.$http.post('/api/seats', data)
        .then((res) => {
          this.occupiedSeat(data)
        })
      console.log('searchUser') */
    },
    occupiedSeat: function (data) {
      window['L'].circle([data.location.lat, data.location.lng], {color: 'green', radius: 5})
        .addTo(this.map).bindTooltip(data.userName, {permanent: true, direction: 'center'}).openTooltip()
        .bindPopup(data.userId + '<br/>' + data.userName)
    },
    getLocation: function () {
      this.$http.get('/api/seats')
        .then((res) => {
          this.occupiedSeat(res.data)
        })
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
    this.imageOverlay.addTo(this.map)
    this.map.setMaxBounds(bounds)
    this.map.on('click', (e) => {
      let popup = L.popup({minWidth: 300})
      this.location = e.latlng
      let ComponentClass = Vue.extend(SaveSeatPopup)
      let instance = new ComponentClass({propsData: {items: this.searchItems}})
      instance.$mount()
      popup
        .setLatLng(e.latlng)
        .setContent(instance.$el)
        .openOn(this.map)
    })
    // this.getLocation()
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
