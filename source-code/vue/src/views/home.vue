<template>
  <div class="homebox">
    <!-- <div
      class="flower"
      :style="{ width: 1000 + 'px', height: 800 + 'px' }"
    ></div> -->
    <!-- 雪花区域 -->
    <div class="cartoon">
      <img class="cartoonimg" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon1">
      <img class="cartoonimg1" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon2">
      <img class="cartoonimg2" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon3">
      <img class="cartoonimg3" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon4">
      <img class="cartoonimg4" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon5">
      <img class="cartoonimg5" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon6">
      <img class="cartoonimg6" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon7">
      <img class="cartoonimg7" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon8">
      <img class="cartoonimg8" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon9">
      <img class="cartoonimg9" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon10">
      <img class="cartoonimg10" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon11">
      <img class="cartoonimg11" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon12">
      <img class="cartoonimg12" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon13">
      <img class="cartoonimg13" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon14">
      <img class="cartoonimg14" src="../assets/car1.png" alt="" />
    </div>
    <div class="cartoon15">
      <img class="cartoonimg15" src="../assets/car1.png" alt="" />
    </div>

    <!-- 雪花区域结束 -->
    <div class="homemain">
      <div class="homemaintitle">
        <div class="homemaintitlename">{{ dangan.uName }}</div>
        <div class="homemaintitleemail">
          http://{{ dangan.userName }}.qzone.uu.com
        </div>
      </div>
      <div class="homemainheadimg">
        <img class="img1" :src="headimg" alt="" />
      </div>
      <div class="homemaingoout">
        <router-link to="Main" tag="div" active-class="select"
          >主页</router-link
        >
        <router-link to="Rizhi" tag="div" active-class="select"
          >日志</router-link
        >
        <router-link to="Xiangce" tag="div" active-class="select"
          >相册</router-link
        >
        <router-link to="Liuyan" tag="div" active-class="select"
          >留言板</router-link
        >
        <router-link to="Shuoshuo" tag="div" active-class="select"
          >说说</router-link
        >
        <router-link to="Dangan" tag="div" active-class="select"
          >个人档</router-link
        >
      </div>
    </div>
    <div class="homeout"><router-view></router-view></div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      headimg: '',
      titlename: '这星空与你',
      titleemail: '2912369753',
      headimg: '',
      dangan: {},
      timer: ''
    }
  },
  mounted() {
    this.getcurrimg()
    this.timer = setInterval(this.getcurrimg, 500)
    this.getuserlist()
  },
  beforeDestroy() {
    clearInterval(this.timer)
  },
  methods: {
    getcurrimg() {
      let userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/gettxurl/' + userid)
        .then((res) => {
          let data = res.data
          this.headimg = data
          // this.headimg.require = data
        })
        .catch((err) => {})
    },
    getuserlist() {
      let userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/getuser/' + userid)
        .then((res) => {
          let data = res.data
          this.dangan = data
        })
        .catch((err) => {
          // console.log(err)
          this.dangan = data
        })
    }
  }
}
</script>
<style lang="less" scoped>
.homebox {
  //   display: inline-block;
  position: absolute;
  width: 100%;
  min-height: 100%;
  background: rgb(233, 233, 233);
  background: url(../assets/home3.jpg) no-repeat;
  // z-index: -10;
  zoom: 1;
  background-size: length(100%, 100%);
  -webkit-background-size: cover;
  -o-background-size: cover;
  background-position: center, center;
  // 固定背景图
  background-attachment: fixed;
  // 动画区域
  .cartoon {
    position: absolute;
    float: left;
    height: 30px;
    width: 30px;
    .cartoonimg {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 5s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon1 {
    position: absolute;
    float: left;
    margin-left: 100px;
    height: 30px;
    width: 30px;
    .cartoonimg1 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 3s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon2 {
    position: absolute;
    float: left;
    margin-left: 200px;
    height: 30px;
    width: 30px;
    .cartoonimg2 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 7s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon3 {
    position: absolute;
    float: left;
    margin-left: 300px;
    height: 30px;
    width: 30px;
    .cartoonimg3 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 8s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon4 {
    position: absolute;
    float: left;
    margin-left: 400px;
    height: 30px;
    width: 30px;
    .cartoonimg4 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 2s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon5 {
    position: absolute;
    float: left;
    margin-left: 400px;
    height: 30px;
    width: 30px;
    .cartoonimg5 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 4s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon6 {
    position: absolute;
    float: left;
    margin-left: 600px;
    height: 30px;
    width: 30px;
    .cartoonimg6 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 9s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon7 {
    position: absolute;
    float: left;
    margin-left: 700px;
    height: 30px;
    width: 30px;
    .cartoonimg7 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 3s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon8 {
    position: absolute;
    float: left;
    margin-left: 800px;
    height: 30px;
    width: 30px;
    .cartoonimg8 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 2s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon9 {
    position: absolute;
    float: left;
    margin-left: 900px;
    height: 30px;
    width: 30px;
    .cartoonimg9 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 6s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon10 {
    position: absolute;
    float: left;
    margin-left: 1000px;
    height: 30px;
    width: 30px;
    .cartoonimg10 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 7s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon11 {
    position: absolute;
    float: left;
    margin-left: 1100px;
    height: 30px;
    width: 30px;
    .cartoonimg11 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 6s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon12 {
    position: absolute;
    float: left;
    margin-left: 1200px;
    height: 30px;
    width: 30px;
    .cartoonimg12 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 8s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon13 {
    position: absolute;
    float: left;
    margin-left: 1300px;
    height: 30px;
    width: 30px;
    .cartoonimg13 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 4s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon14 {
    position: absolute;
    float: left;
    margin-left: 1200px;
    height: 30px;
    width: 30px;
    .cartoonimg14 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 5s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }
  .cartoon15 {
    position: absolute;
    float: left;
    margin-left: 1450px;
    height: 30px;
    width: 30px;
    .cartoonimg15 {
      height: 100%;
      width: 100%;
    }
    animation: rotate1 3s linear infinite;
    // animation: rotate2 1.5s linear infinite;
  }

  //   主页面区域
  .homemain {
    .homemaintitle {
      width: 300px;
      margin-left: 300px;
      margin-top: 60px;
      .homemaintitlename {
        height: 40px;
        font-size: 27px;
        color: rgb(93, 74, 146);
      }
      .homemaintitleemail {
        font-size: 15px;
        height: 20px;
        color: rgb(93, 74, 146);
      }
    }
    .homemainheadimg {
      height: 120px;
      width: 120px;
      margin-left: 300px;
      margin-top: 85px;
      border: 2px solid rgb(217, 217, 217);
      .img1 {
        float: left;
        width: 100%;
        height: 100%;
      }
    }
    .homemaingoout {
      width: 500px;
      height: 40px;
      margin-left: 465px;
      margin-top: -29px;
      display: flex;
      div {
        line-height: 40px;
        text-align: center;
        flex: 1;
        cursor: pointer;
      }
    }
  }
  .homeout {
    // float: left;
    margin-top: 32px;
    margin-left: 50%;
    transform: translate(-50%);
    min-height: 1000px;
    width: 900px;
    background: rgb(250, 248, 255);
    border: 1px solid rgb(227, 206, 246);
  }
}
@keyframes rotate1 {
  //动画效果 球体顺时针旋转 被map2调用
  form {
    margin-top: 0px;
    // margin-left: 0px;
    transform: rotate3d(1, 1, 1, 0deg);
  }
  to {
    margin-top: 700px;
    // margin-left: 80px;
    transform: rotate3d(1, 1, 1, 1080deg);
  }
}
@keyframes rotate2 {
  form {
    transform: rotate3d(1, 0, 0, 0deg);
  }
  to {
    transform: rotate3d(1, 0, 0, 360deg);
  }
}
</style>
