<template>
  <el-container>
    <el-header>
      <el-page-header @back="goBack" content=""> </el-page-header>
    </el-header>
    <el-main>
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <!-- <el-tab-pane label="我的相册" name="first">
          <div>
            <ul>
              <li>
                <div class="tra">
                  <div>
                    <a href=""
                      ><img
                        class="js-cover-img"
                        src="http://qzonestyle.gtimg.cn/aoi/img/photo/logic/pic-none.png?rf=albumlist&amp;t=5"
                        onload="this.onload=null;preLoadNoScale(this,'http://qzonestyle.gtimg.cn/aoi/img/photo/logic/pic-none.png',167,162);"
                        style="
                          width: 172.125px;
                          height: 162px;
                          margin-top: 0px;
                          margin-left: -3px;
                        "
                    /></a>
                  </div>
                  <div>
                    <div class="album-desc">
                      <div class="album-tit">
                        <a
                          href="javascript:;"
                          class="c-tx2 js-album-desc-a"
                          title="未命名"
                          data-hottag="list.albumtitle"
                          >未命名</a
                        >
                      </div>
                    </div>
                  </div>
                </div>
              </li>
              <li>
                <div class="tra">
                  <div>
                    <a href=""
                      ><img
                        class="js-cover-img"
                        src="../assets/5.png"
                        onload="this.onload=null;preLoadNoScale(this,'http://qzonestyle.gtimg.cn/aoi/img/photo/logic/pic-none.png',167,162);"
                        style="
                          width: 172.125px;
                          height: 162px;
                          margin-top: 0px;
                          margin-left: -3px;
                        "
                    /></a>
                  </div>
                  <div>
                    <div class="album-desc">
                      <div class="album-tit">
                        <a
                          href="javascript:;"
                          class="c-tx2 js-album-desc-a"
                          title="未命名"
                          data-hottag="list.albumtitle"
                          >未命名</a
                        >
                      </div>
                    </div>
                  </div>
                </div>
              </li>
              <li>
                <div class="tra">
                  <div>
                    <a href=""
                      ><img
                        class="js-cover-img"
                        src="../assets/5.png"
                        onload="this.onload=null;preLoadNoScale(this,'http://qzonestyle.gtimg.cn/aoi/img/photo/logic/pic-none.png',167,162);"
                        style="
                          width: 172.125px;
                          height: 162px;
                          margin-top: 0px;
                          margin-left: -3px;
                        "
                    /></a>
                  </div>
                  <div>
                    <div class="album-desc">
                      <div class="album-tit">
                        <a
                          href="javascript:;"
                          class="c-tx2 js-album-desc-a"
                          title="未命名"
                          data-hottag="list.albumtitle"
                          >未命名</a
                        >
                      </div>
                    </div>
                  </div>
                </div>
              </li>
              <li>
                <div class="tra">
                  <div>
                    <a href=""
                      ><img
                        class="js-cover-img"
                        src="../assets/6.png"
                        onload="this.onload=null;preLoadNoScale(this,'http://qzonestyle.gtimg.cn/aoi/img/photo/logic/pic-none.png',167,162);"
                        style="
                          width: 172.125px;
                          height: 162px;
                          margin-top: 0px;
                          margin-left: -3px;
                        "
                    /></a>
                  </div>
                  <div>
                    <div class="album-desc">
                      <div class="album-tit">
                        <a
                          href="javascript:;"
                          class="c-tx2 js-album-desc-a"
                          title="未命名"
                          data-hottag="list.albumtitle"
                          >未命名</a
                        >
                      </div>
                    </div>
                  </div>
                </div>
              </li>
              <li>
                <div></div>
              </li>
              <li>
                <div></div>
              </li>
            </ul>
          </div>
        </el-tab-pane> -->
        <el-tab-pane label="照片墙" name="second">
          <el-container>
            <el-header></el-header>
            <el-main>
              <el-carousel :interval="4000" type="card" height="200px">
                <el-carousel-item v-for="item in imagebox" :key="item.id">
                  <img :src="item.img" class="image" />
                </el-carousel-item>
              </el-carousel>
            </el-main>
          </el-container>
        </el-tab-pane>
        <!-- 二级路由出口 -->

        <div class="line"></div>
      </el-tabs>
    </el-main>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      activeName: 'second',
      imagebox: [
        { id: 0, img: require('../assets/1.png') },
        { id: 1, img: require('../assets/2.png') },
        { id: 2, img: require('../assets/3.png') },
        { id: 3, img: require('../assets/4.png') },
        { id: 4, img: require('../assets/5.png') },
        { id: 5, img: require('../assets/6.png') }
      ],
      dialogImageUrl: '',
      dialogVisible: false,
      activeIndex: '1',
      // 浏览器宽度
      screenWidth: 0
    }
  },
  methods: {
    goBack() {
      console.log('go back')
    },
    handleClick(tab, event) {
      console.log(tab, event)
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    },
    goBack() {
      console.log('go back')
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath)
    },
    handleRemove(file, fileList) {
      console.log(file, fileList)
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    setSize: function () {
      // 通过浏览器宽度(图片宽度)计算高度
      this.bannerHeight = (400 / 1920) * this.screenWidth
    }
  },
  mounted() {
    // 首次加载时,需要调用一次
    this.screenWidth = window.innerWidth
    this.setSize()
    // 窗口大小发生改变时,调用一次
    window.onresize = () => {
      this.screenWidth = window.innerWidth
      this.setSize()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
* {
  margin: 0;
  padding: 0;
}
.el-header {
  height: 30px !important;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
img {
  /*设置图片宽度和浏览器宽度一致*/
  width: 100%;
  height: inherit;
}
.js-album-desc-a {
  color: #000000;
  text-decoration: none;
}
li {
  padding-left: 20px;
  float: left;
  display: list-item;
  text-align: -webkit-match-parent;
}
li .tra {
  border-color: #e6e6e6;
  border-width: 1px;
  border-style: solid;
  padding: 6px;

  border-width: 0;

  box-shadow: inset 0px 0px 17px 1px rgba(0, 0, 0, 0.15);
  -webkit-transition: all 300ms ease-in-out;

  transition: all 300ms ease-in-out;
}
</style>
