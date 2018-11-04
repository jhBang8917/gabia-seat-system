<template>
  <div id="map">

  </div>
</template>

<script>
import mapImage from '../assets/Asset 20.svg'
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

    const w = 4000
    const h = 2500
    const southWest = this.map.unproject([0, h], this.map.getMaxZoom() - 1)
    const northEast = this.map.unproject([w, 0], this.map.getMaxZoom() - 1)
    let bounds = new L.LatLngBounds(southWest, northEast)

    this.imageOverlay = L.imageOverlay(
      mapImage, bounds
    )
    this.imageOverlay.addTo(this.map)
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
