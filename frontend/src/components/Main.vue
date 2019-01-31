<template>
  <div id="map">

  </div>
</template>

<script>
import mapImage from '../assets/F5.svg'
export default {
  name: 'Main',
  data () {
    return {
      map: null,
      imageOverlay: null,
      layers: [],
      mapImage: mapImage
    }
  },
  computed: {
  },
  created () {
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

    L.circle([-99.762, 349.24], {color: 'green', radius: 4}).addTo(this.map)
      // .bindTooltip('iwatsuki', {permanent: true, direction: 'center'}).openTooltip()
      .bindPopup('iwatsuki <br />IT Support Department')

    this.map.setMaxBounds(bounds)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  #map {
    height: 600px;
    background-color: white;
  }
</style>
