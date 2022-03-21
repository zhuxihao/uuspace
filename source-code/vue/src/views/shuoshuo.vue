<template>
  <div class="shuoshuobox">
    <div class="shuoshuotitle">我的说说</div>
    <div class="shuoshuowhite">
      <el-input
        type="textarea"
        :rows="4"
        placeholder="请输入内容"
        v-model="shuoshuoexit.sstext"
      >
      </el-input>
      <el-button size="mini" @click="hairshuo">发表</el-button>
    </div>
    <div class="shuoshuomain">
      <div
        class="shuoshuolist"
        v-for="(item, idx) in shuoshuolist"
        :key="item.id"
      >
        <div class="shuoshuolistlife">
          <div class="shuoshuolistlifeimg">
            <img class="imgtitle" :src="headimg" alt="" />
          </div>
        </div>
        <div class="shuoshuolistright">
          <div class="shuoshuolistlifetext">{{ item.sstext }}</div>
          <div class="shuoshuolistrighttime">
            {{ item.date1 }}
            <el-button
              size="mini"
              class="deletess"
              circle
              @click="deletess(idx)"
              icon="el-icon-delete"
            ></el-button>
          </div>
        </div>
      </div>
    </div>
    <div class="shuoshuoright"></div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      headimg: '',
      shuoshuoexit: {
        userid: '',
        sstext: '',
        data1: ''
      },
      // titleimg: require('../assets/headimg1.jpg'),
      shuoshuolist: []
    }
  },
  mounted() {
    this.getshuoshuolist()
    this.getcurrimg()
  },
  methods: {
    // 添加说说
    hairshuo() {
      let newtime = new Date()
      var yy = newtime.getFullYear()
      var mm = newtime.getMonth() + 1
      var dd = newtime.getDate()
      this.shuoshuoexit.date1 = yy + '-' + mm + '-' + dd
      this.shuoshuoexit.userid = window.sessionStorage.getItem('userid')
      this.$axios
        .post('/api/addss/', this.shuoshuoexit)
        .then((res) => {
          if (data.info.code === '0' && data.data === 'OK') {
            this.$message.success('添加成功')
            this.getshuoshuolist()
            this.shuoshuoexit = {}
          } else {
            this.$message.error('添加失败')
            this.getshuoshuolist()
            this.shuoshuoexit = {}
          }
          this.getshuoshuolist()
        })
        .catch((err) => {
          this.$message.success('添加成功')
          this.getshuoshuolist()
          this.shuoshuoexit = {}
        })
    },
    // 显示所有说说
    getshuoshuolist() {
      var userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/queryssList/' + userid)
        .then((res) => {
          console.log('wzjsb')
          let data = res.data.ssList
          this.shuoshuolist = data
          if (this.shuoshuolist == null) {
            this.$message.erroe('获取说说列表失败')
          }
        })
        .catch((err) => {
          console.log('sslist222')
        })
    },
    // 删除说说
    deletess(idx) {
      var id = this.shuoshuolist[idx].id
      console.log(id)
      this.$axios
        .delete('/api/delssbyid/' + id)
        .then((res) => {
          let data = res.data.LyList
          if (data.info.code === '0' && data.data === 'OK') {
            this.$message.success('删除成功')
            this.getshuoshuolist()
          } else {
            this.$message.error('删除失败')
          }
          this.getrizhilist()
        })
        .catch((err) => {
          this.$message.success('删除成功')
          this.getshuoshuolist()
        })
    },
    // 获取头像
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
    }
  }
}
</script>
<style lang="less" scoped>
.shuoshuobox {
  .shuoshuotitle {
    float: left;
    position: relative;
    height: 48px;
    width: 860px;
    line-height: 48px;
    margin-left: 20px;
    padding-left: 2px;
    // background: yellowgreen;
    font-size: 15px;
    font-weight: 700;
    color: rgb(128, 74, 146);
    border-bottom: 2px solid rgb(210, 200, 230);
    &::before {
      position: absolute;
      content: '';
      width: 65px;
      height: 3px;
      bottom: -2px;
      left: 0%;
      //   background: red;
      border-bottom: 3px solid rgb(93, 74, 146);
    }
  }
  .shuoshuowhite {
    float: left;
    height: 125px;
    width: 600px;
    margin-left: 20px;
    margin-top: 20px;
    // background: aquamarine;
    .el-button {
      margin-left: 100%;
      transform: translate(-100%);
      background: rgb(156, 133, 204);
      color: white;
    }
  }
  .shuoshuomain {
    float: left;
    width: 600px;
    height: 800px;
    // background: orange;
    margin-left: 20px;
    margin-top: 35px;
    border-top: 1px solid rgb(223, 216, 240);
    // border-bottom: 1px solid rgb(210, 200, 230);
    .shuoshuolist {
      width: 600px;
      min-height: 200px;

      // background: red;
      .shuoshuolistlife {
        float: left;
        min-height: 200px;
        width: 100px;
        // background: aquamarine;
        .shuoshuolistlifeimg {
          height: 60px;
          width: 60px;
          margin-left: 18px;
          margin-top: 17px;
          // background: orange;
          .imgtitle {
            height: 100%;
            width: 100%;
          }
        }
      }
      .shuoshuolistright {
        position: relative;
        float: left;
        min-height: 170px;
        width: 490px;
        margin-top: 15px;
        border-radius: 5px;
        border: 1px solid rgb(223, 216, 240);
        box-shadow: 0px 3px 3px rgb(223, 216, 240);
        // background: greenyellow;
        &::before {
          position: absolute;
          content: '';
          height: 20px;
          width: 20px;
          margin-left: -10px;
          margin-top: 20px;
          background: rgb(250, 248, 255);
          // transform-origin: left top;
          transform: rotate(45deg);
          -webkit-transform: rotate(45deg);
          border-bottom: 1px solid rgb(229, 223, 243);
          border-left: 1px solid rgb(229, 223, 243);
        }
        .shuoshuolistlifetext {
          width: 450px;
          min-height: 125px;
          // background: red;
          margin-left: 15px;
          padding-top: 5px;
          border-bottom: 1px solid rgb(223, 216, 240);
        }
        .shuoshuolistrighttime {
          height: 30px;
          width: 450px;
          line-height: 30px;
          margin-left: 15px;
          // background: greenyellow;
          font-size: 12px;
          .deletess {
            margin-left: 300px;
            margin-top: 5px;
          }
        }
      }
    }
  }
  .shuoshuoright {
    float: left;
    height: 500px;
    width: 250px;
    margin-left: 20px;
    margin-top: -125px;
    // background: yellowgreen;
    background: url(../assets/right1.jpg) no-repeat;
    // z-index: -10;
    zoom: 1;
    background-size: length(100%, 100%);
    -webkit-background-size: cover;
    -o-background-size: cover;
    background-position: center, center;
  }
}
</style>
