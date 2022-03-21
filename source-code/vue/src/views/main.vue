<template>
  <div class="zhuyebox">
    <div class="zhuyeleft">
      <div class="zuos"></div>
      <div class="yous"></div>
      <div class="zhuyeleftshang">
        <div class="zhuyeleftshangzuo">{{ shuoshuonum }}<br />说说</div>
        <div class="zhuyeleftshangyou">{{ rizhinum }}<br />日志</div>
      </div>
    </div>
    <div class="zhuyeright"></div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      shuoshuonum: '',
      rizhinum: '',
      shuoshuoexit: '',
      titleimg: require('../assets/headimg1.jpg')
    }
  },
  mounted() {
    this.getshuoshuonum()
    this.getrizhinum()
  },
  methods: {
    getshuoshuonum() {
      let userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/countss/' + userid)
        .then((res) => {
          let data = res.data
          this.shuoshuonum = data
        })
        .catch((err) => {})
    },
    getrizhinum() {
      let userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/countRz/' + userid)
        .then((res) => {
          let data = res.data
          this.rizhinum = data
        })
        .catch((err) => {})
    }
  }
}
</script>
<style lang="less" scoped>
.zhuyebox {
  height: 1000px;
  width: 900px;
  background: url(../assets/good1.jpg) no-repeat;
  zoom: 1;
  background-size: length(100%, 100%);
  -webkit-background-size: cover;
  -o-background-size: cover;
  background-position: center, center;
  .zhuyeleft {
    float: left;
    min-height: 400px;
    // width: 285px;
    // background: aquamarine;
    .zuos {
      float: left;
      height: 330px;
      width: 5px;
      background: rgb(102, 97, 75);
      margin-left: 520px;
    }
    .yous {
      float: left;
      height: 330px;
      width: 5px;
      background: rgb(102, 97, 75);
      margin-left: 115px;
    }
    .zhuyeleftshang {
      float: left;
      height: 90px;
      width: 283px;
      // background: wheat;
      // border: 1px solid rgb(210, 200, 230);
      margin-left: 440px;
      // margin-top: 330px;
      -webkit-background-size: 50px 50px;
      -moz-background-size: 50px 50px;
      background-size: 50px 50px;
      -moz-box-shadow: 1px 1px 8px gray;
      -webkit-box-shadow: 1px 1px 8px gray;
      box-shadow: 1px 1px 8px gray;
      background: repeating-radial-gradient(
        circle closest-side,
        rgba(112, 86, 55, 0.6) 0%,
        rgba(107, 92, 65, 0.6) 20%,
        rgba(94, 87, 51, 0.6) 40%,
        rgba(82, 69, 42, 0.6) 60%
      );
      .zhuyeleftshangzuo {
        float: left;
        height: 90px;
        width: 140px;
        text-align: center;
        padding-top: 16px;
        // line-height: 45px;
        font-size: 21px;
        color: rgb(47, 46, 51);
        // background: goldenrod;
        position: relative;
      }
      .zhuyeleftshangyou {
        float: left;
        height: 90px;
        width: 140px;
        text-align: center;
        padding-top: 16px;
        font-size: 21px;
        color: rgb(47, 46, 51);
        // background: greenyellow;
      }
    }
  }
}
</style>
