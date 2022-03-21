<template>
  <div class="shuoshuobox">
    <div class="shuoshuoboxtitle">个人档</div>
    <div class="shuoshuoboxmain">
      <div class="shuoshuoboxleft">
        <div class="shuoshuoboxleftimg">
          <img class="imghead" :src="headimg" alt="" />
        </div>
        <!-- <div class="shuoshuoboxleftxiugai">修改头像</div> -->
      </div>
      <div class="shuoshuoboxright">
        <div class="shuoshuoboxrighttitle">{{ titlename }}</div>
        <div class="shuoshuoboxrightimg">
          <div
            class="shuoshuoboxrightimglist"
            v-for="(item, idx) in imglist"
            :key="item.id"
            @click="xiugaitouxiang(idx)"
          >
            <img class="imglist" :src="item.imgurl" alt="" />
          </div>
        </div>
        <div class="shuoshuoboxrightbasic">
          <div class="shuoshuoboxrightbasic1">基本资料</div>
          <div class="shuoshuoboxrightbasic2" @click="xiugaidangan">修改</div>
        </div>
        <div class="shuoshuoboxrightmain">
          <div
            class="shuoshuoboxrightmainlist"
            v-for="item in danganData"
            :key="item.id"
          >
            <div class="shuoshuoboxrightmainlistleft">{{ item.name }}</div>
            <div class="shuoshuoboxrightmainlistright">{{ item.data }}</div>
          </div>
        </div>
      </div>
    </div>
    <el-dialog
      title="修改个人信息"
      :visible.sync="isshowregister"
      width="50%"
      :modal="false"
    >
      <!-- 内容主体区域 -->
      <el-form
        :model="registerformdata"
        :rules="registerformrules"
        label-width="70px"
      >
        <el-form-item label="账号" prop="账号">
          <el-input v-model="registerformdata.userName" disabled></el-input>
        </el-form-item>
        <el-form-item label="昵称" prop="昵称">
          <el-input v-model="registerformdata.uName"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="registerformdata.sex" placeholder="请选择性别">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="年龄" prop="年龄">
          <el-input v-model="registerformdata.age"></el-input>
        </el-form-item>
        <el-form-item label="职业" prop="职业">
          <el-input v-model="registerformdata.job"></el-input>
        </el-form-item>
      </el-form>
      <!-- 底部区域 -->
      <span slot="footer" class="dialog-footer">
        <el-button @click="exitregisterform">取 消</el-button>
        <el-button type="primary" @click="registerrequest">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      isshowregister: false,
      registerformdata: {},
      titlename: '精选头像',
      // tttt: 'headimg1',
      // headimg: require('../assets/headimg1.jpg'),
      headimg: '',
      imglist: [
        { id: 1, imgurl: require('../assets/headimg1.jpg') },
        { id: 2, imgurl: require('../assets/headimg2.jpg') },
        { id: 3, imgurl: require('../assets/headimg3.jpg') },
        { id: 4, imgurl: require('../assets/headimg4.jpg') },
        { id: 5, imgurl: require('../assets/headimg5.jpg') }
      ],
      danganData: [
        { id: 1, name: '账号:', data: '' },
        { id: 1, name: '昵称:', data: '' },
        { id: 1, name: '性别:', data: '' },
        { id: 1, name: '年龄:', data: '' },
        { id: 1, name: '职业:', data: '' }
      ],
      // 修改头像
      // userid: '',
      txurl: require('../assets/headimg3.jpg')
    }
  },
  mounted() {
    this.getuserlist()
    this.getcurrimg()
    this.headimg = this.txurl
  },
  methods: {
    getuserlist() {
      let userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/getuser/' + userid)
        .then((res) => {
          let data = res.data
          this.registerformdata = data
          this.danganData[0].data = data.userName
          this.danganData[1].data = data.uName
          this.danganData[2].data = data.sex
          this.danganData[3].data = data.age
          this.danganData[4].data = data.job
          if (this.danganData[0].data == null) {
            this.$message.error('获取个人档案失败')
          }
        })
        .catch((err) => {
          // console.log(err)
          this.$message.error('获取个人档案失败，请检查网络环境')
        })
    },
    xiugaidangan() {
      this.isshowregister = true
      // this.headimg1 = this.headimg
      // this.headimg = this.imglist[0].imgurl
    },
    exitregisterform() {
      this.isshowregister = false
      // this.registerformdata = {}
    },
    registerrequest() {
      this.isshowregister = false
      this.$axios
        .put('/api/editUser/', this.registerformdata)
        .then((res) => {
          let data = res.data
          if (data.info.code === '0' && data.data === 'OK') {
            this.$message.success('修改成功')
            this.getuserlist()
            this.isshowregister = false
          } else {
            this.$message.error('修改失败')
          }
        })
        .catch((err) => {
          // console.log(err)
          this.$message.error('修改个人档案失败，请检查网络环境')
          this.getuserlist()
          this.isshowregister = false
        })
    },
    // 修改头像
    xiugaitouxiang(idx) {
      let userid = window.sessionStorage.getItem('userid')
      this.txurl = this.imglist[idx].imgurl
      // this.headimg = this.txurl
      this.$axios
        .put('/api/edittx/' + userid, this.txurl)
        .then((res) => {
          this.getcurrimg()
        })
        .catch((err) => {
          this.getcurrimg()
        })
    },
    // 获取当前头像
    getcurrimg() {
      let userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/gettxurl/' + userid)
        .then((res) => {
          let data = res.data
          // this.headimg = data
          this.headimg = data
        })
        .catch((err) => {})
    }
  }
}
</script>
<style lang="less" scoped>
.shuoshuobox {
  height: 1000px;
  .shuoshuoboxtitle {
    height: 38px;
    width: 882px;
    line-height: 38px;
    font-weight: 600;
    font-size: 15px;
    color: rgb(68, 68, 68);
    background: rgb(227, 206, 251);
    padding-left: 18px;
  }
  .shuoshuoboxmain {
    width: 100%;
    .shuoshuoboxleft {
      float: left;
      height: 962px;
      width: 156px;
      background: rgb(254, 251, 255);
      border-right: 1px solid rgb(220, 198, 241);
      //   padding-top: 22px;
      .shuoshuoboxleftimg {
        float: left;
        width: 110px;
        height: 110px;
        background: rgb(254, 251, 55);
        margin-left: 23px;
        margin-top: 22px;
        .imghead {
          width: 100%;
          height: 100%;
        }
      }
      .shuoshuoboxleftxiugai {
        float: left;
        margin-left: 50%;
        transform: translate(-50%);
        margin-top: 20px;
        height: 20px;
        width: 50px;
        font-size: 12px;
        color: rgb(163, 118, 184);
        // background: yellowgreen;
      }
    }
    .shuoshuoboxright {
      float: left;
      .shuoshuoboxrighttitle {
        float: left;
        margin-top: 36px;
        margin-left: 26px;
        height: 30px;
        line-height: 30px;
        font-size: 14px;
        font-weight: 800;
        color: rgb(68, 68, 68);
        // background: yellowgreen;
      }
      .shuoshuoboxrightimg {
        // float: left;
        height: 100px;
        width: 600px;
        // background: yellowgreen;
        margin-top: 73px;
        margin-left: 20px;
        display: flex;
        .shuoshuoboxrightimglist {
          flex: 1;
          width: 100px;
          margin-left: 7px;
          border: 2px solid rgb(221, 199, 240);
          .imglist {
            height: 100%;
            width: 100%;
          }
        }
      }
      .shuoshuoboxrightbasic {
        height: 44px;
        width: 700px;
        line-height: 44px;
        font-weight: 700;
        color: rgb(68, 68, 68);
        margin-top: 30px;
        margin-left: 20px;
        border-top: 1px solid rgb(221, 199, 240);
        border-bottom: 1px solid rgb(221, 199, 240);
        // background: yellowgreen;
        .shuoshuoboxrightbasic1 {
          float: left;
        }
        .shuoshuoboxrightbasic2 {
          float: left;
          margin-left: 580px;
          color: rgb(227, 206, 251);
          font-size: 14px;
          cursor: pointer;
        }
      }
      .shuoshuoboxrightmain {
        height: 600px;
        width: 600px;
        // background: yellowgreen;
        margin-left: 27px;
        margin-top: 10px;
        .shuoshuoboxrightmainlist {
          width: 600px;
          height: 40px;
          display: flex;
          .shuoshuoboxrightmainlistleft {
            flex: 1;
            height: 40px;
            line-height: 40px;
            font-size: 13px;
            // background: red;
          }
          .shuoshuoboxrightmainlistright {
            flex: 3;
            height: 40px;
            line-height: 40px;
            font-size: 13px;
            // background: gold;
          }
        }
      }
    }
  }
}
</style>
