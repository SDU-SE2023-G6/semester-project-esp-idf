<script setup lang="ts">
import { defineProps, computed } from 'vue';

//from https://www.npmjs.com/package/vue-loading-spinner

const props = defineProps({
    size: {
        type: String,
        default: "60px"
    }
});

// Define computed properties
const innerStyles = computed(() => {
    const parsedSize = parseInt(props.size);
    return {
        transform: 'scale(' + (parsedSize / 220) + ')',
    };
});

const styles = computed(() => ({
    width: props.size,
    height: props.size,
}));

</script>

<template>
    <div v-bind:style="styles" class="spinner spinner--socker">
      <div v-bind:style="innerStyles" class="spinner-inner">
        <div class="gel center-gel">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c1 r1">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c2 r1">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c3 r1">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c4 r1">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c5 r1">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c6 r1">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
  
        <div class="gel c7 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
  
        <div class="gel c8 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c9 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c10 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c11 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c12 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c13 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c14 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c15 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c16 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c17 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c18 r2">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c19 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c20 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c21 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c22 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c23 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c24 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c25 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c26 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c28 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c29 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c30 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c31 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c32 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c33 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c34 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c35 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c36 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
        <div class="gel c37 r3">
          <div class="hex-brick h1"></div>
          <div class="hex-brick h2"></div>
          <div class="hex-brick h3"></div>
        </div>
      </div>
    </div>
  </template>
  
<style scoped>
    .spinner{
      overflow: hidden;
      display: flex;
      justify-content: center;
      align-items: center;
      * {
        line-height: 0;
        box-sizing: border-box;
      }
    }
    .spinner-inner{
      transform-origin: center center;
      width: 200px;
      height: 200px;
      position: relative;
    }
  
    .hex-brick{
      background: #41b883;
      width: 30px;
      height: 17px;
      position: absolute;
      top: 5px;
      animation-name: socket-fade;
      animation-duration: 2s;
      animation-iteration-count: infinite;
    }
  
    .h2{
      transform: rotate(60deg);
    }
  
    .h3{
      transform: rotate(-60deg);
    }
  
    .gel{
      height: 30px;
      width: 30px;
      transition: all .3s;
      position: absolute;
      top: 50%;
      left: 50%;
    }
  
    .center-gel{
      margin-left: -15px;
      margin-top: -15px;
  
      animation-name: socket-pulse;
      animation-duration: 2s;
      animation-iteration-count: infinite;
    }
  
    .c1{
      margin-left: -47px;
      margin-top: -15px;
    }
  
    .c2{
      margin-left: -31px;
      margin-top: -43px;
    }
  
    .c3{
      margin-left: 1px;
      margin-top: -43px;
    }
  
    .c4{
      margin-left: 17px;
      margin-top: -15px;
    }
    .c5{
      margin-left: -31px;
      margin-top: 13px;
    }
  
    .c6{
      margin-left: 1px;
      margin-top: 13px;
    }
  
    .c7{
      margin-left: -63px;
      margin-top: -43px;
    }
  
    .c8{
      margin-left: 33px;
      margin-top: -43px;
    }
  
    .c9{
      margin-left: -15px;
      margin-top: 41px;
    }
  
    .c10{
      margin-left: -63px;
      margin-top: 13px;
    }
  
    .c11{
      margin-left: 33px;
      margin-top: 13px;
    }
  
    .c12{
      margin-left: -15px;
      margin-top: -71px;
    }
  
    .c13{
      margin-left: -47px;
      margin-top: -71px;
    }
  
    .c14{
      margin-left: 17px;
      margin-top: -71px;
    }
  
    .c15{
      margin-left: -47px;
      margin-top: 41px;
    }
  
    .c16{
      margin-left: 17px;
      margin-top: 41px;
    }
  
    .c17{
      margin-left: -79px;
      margin-top: -15px;
    }
  
    .c18{
      margin-left: 49px;
      margin-top: -15px;
    }
  
    .c19{
      margin-left: -63px;
      margin-top: -99px;
    }
  
    .c20{
      margin-left: 33px;
      margin-top: -99px;
    }
  
    .c21{
      margin-left: 1px;
      margin-top: -99px;
    }
  
    .c22{
      margin-left: -31px;
      margin-top: -99px;
    }
  
    .c23{
      margin-left: -63px;
      margin-top: 69px;
    }
  
    .c24{
      margin-left: 33px;
      margin-top: 69px;
    }
  
    .c25{
      margin-left: 1px;
      margin-top: 69px;
    }
  
    .c26{
      margin-left: -31px;
      margin-top: 69px;
    }
  
    .c27{
      margin-left: -79px;
      margin-top: -15px;
    }
  
    .c28{
      margin-left: -95px;
      margin-top: -43px;
    }
  
    .c29{
      margin-left: -95px;
      margin-top: 13px;
    }
  
    .c30{
      margin-left: 49px;
      margin-top: 41px;
    }
  
    .c31{
      margin-left: -79px;
      margin-top: -71px;
    }
  
    .c32{
      margin-left: -111px;
      margin-top: -15px;
    }
  
    .c33{
      margin-left: 65px;
      margin-top: -43px;
    }
  
    .c34{
      margin-left: 65px;
      margin-top: 13px;
    }
  
    .c35{
      margin-left: -79px;
      margin-top: 41px;
    }
  
    .c36{
      margin-left: 49px;
      margin-top: -71px;
    }
  
    .c37{
      margin-left: 81px;
      margin-top: -15px;
    }
  
    .r1{
      animation-name: socket-pulse;
      animation-duration: 2s;
      animation-iteration-count: infinite;
      animation-delay: .2s;
    }
  
    .r2{
      animation-name: socket-pulse;
      animation-duration: 2s;
      animation-iteration-count: infinite;
      animation-delay: .4s;
    }
  
    .r3{
      animation-name: socket-pulse;
      animation-duration: 2s;
      animation-iteration-count: infinite;
      animation-delay: .6s;
    }
  
    .r1 > .hex-brick{
      animation-name: socket-fade;
      animation-duration: 2s;
      animation-iteration-count: infinite;
      animation-delay: .2s;
    }
  
    .r2 > .hex-brick{
      animation-name: socket-fade;
      animation-duration: 2s;
      animation-iteration-count: infinite;
      animation-delay: .4s;
    }
  
    .r3 > .hex-brick{
      animation-name: socket-fade;
      animation-duration: 2s;
      animation-iteration-count: infinite;
      animation-delay: .6s;
    }
  
  
    @keyframes socket-pulse{
      0%{
        transform: scale(1);
      }
  
      50%{
        transform: scale(0.01);
      }
  
      100%{
        transform: scale(1);
      }
    }
  
    @keyframes socket-fade{
      0%{
        background: #41b883;
      }
  
      50%{
        background: #286b4b;
      }
  
      100%{
        background: #41b883;
      }
    }
</style>
  