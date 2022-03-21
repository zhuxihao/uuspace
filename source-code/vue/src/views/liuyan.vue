<template>
  <div class="liulanbox">
    <div class="liulantitle">留言板</div>
    <div class="liuyanjiyutitle">
      <div class="liuyanjiyutitlezhuren">心情寄语</div>
      <!-- <div class="liuyanjiyubianji" v-if="jiyushow" @click="bianjijiyu">
        编辑您的寄语
      </div> -->
    </div>
    <div class="liulanjiyushow" v-if="jiyushow">{{ selfjiyu }}</div>
    <div class="liuyanjiyubianji" v-if="bianjishow">
      <el-input
        type="textarea"
        :rows="7"
        placeholder="请输入内容"
        v-model="exitjiyu"
      >
      </el-input>
      <el-button class="qvxiao" size="mini" @click="qvxiao">取消</el-button>
      <el-button class="baocun" size="mini" @click="baocun">保存</el-button>
    </div>
    <div class="whiteliuyan" v-if="isshowfaliuyan">
      <div class="exitliuyantitle">发表您的留言</div>
      <el-input
        type="textarea"
        :rows="6"
        placeholder="请输入内容"
        v-model="liuyantext.lytext"
      >
      </el-input>
      <el-button class="faliuyan" size="mini" @click="faliuyanrequest"
        >发表</el-button
      >
      <el-button class="faliuyan" size="mini" @click="exitfaliuyan"
        >取消</el-button
      >
    </div>
    <div class="liulanliuyantitle">
      <div class="liuyantiaoshu">留言 ({{ liuyannum }})</div>
      <div class="woyaoliuyan" @click="faliuyan">我要留言</div>
    </div>
    <div class="liulanmain">
      <div
        class="liulanmainlist"
        v-for="(item, idx) in liuyanlist"
        :key="item.id"
      >
        <div class="liulanmainlistleft">
          <div class="liulanmainlistleftimg">
            <img class="imgmain" :src="headimg" alt="" />
          </div>
        </div>
        <div class="liulanmainlistright">
          <div class="liulanmainlistrighttop">{{ dangan.uName }}</div>
          <div class="liulanmainlistrightcenter">{{ item.lytext }}</div>
          <div class="liulanmainlistrightdown">
            <div class="liulanmainlistrightdowntime">{{ item.lydate }}</div>
            <div class="liulanmainlistrightdowndel">
              <el-button size="mini" @click="dialogVisibles(idx)"
                >删除</el-button
              >
            </div>
            <el-dialog
              title="提示"
              :visible.sync="dialogVisible"
              width="30%"
              :modal="false"
            >
              <span>确认要删除嘛</span>
              <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="deleteliuyan"
                  >确 定</el-button
                >
              </span>
            </el-dialog>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      idxidx: '',
      dangan: {},
      dialogVisible: false,
      isshowfaliuyan: false,
      jiyushow: true,
      bianjishow: false,
      // 主人寄语
      selfjiyu: '',
      //   编辑寄语
      exitjiyu: '',
      //留言条数
      liuyannum: '',
      liuyantext: {
        userid: '',
        lytext: '',
        lydate: ''
      },
      liuyanlist: [],
      headimg: ''
    }
  },
  mounted() {
    this.getliulanlist()
    this.getuserlist()
    this.getjiyu()
    this.getcurrimg()
    this.getrizhinum()
  },
  methods: {
    dialogVisibles(idx) {
      this.dialogVisible = true
      this.idxidx = idx
    },
    // 获取寄语
    getjiyu() {
      this.$axios
        .get('/api/queryJy/')
        .then((res) => {
          let data = res.data
          this.selfjiyu = data.jytext
        })
        .catch((err) => {
          // console.log(err)
          this.$message.error('获取寄语失败，请检查网络环境')
        })
    },
    // 删除留言
    deleteliuyan() {
      // console.log(idx)
      var id = this.liuyanlist[this.idxidx].id
      this.$axios
        .delete('/api/delLy/' + id)
        .then((res) => {
          let data = res.data.LyList
          if (data.info.code === '0' && data.data === 'OK') {
            this.$message.success('删除成功')
            this.getliulanlist()
            this.getrizhinum()
            this.dialogVisible = false
          } else {
            this.$message.error('删除失败')
          }
        })
        .catch((err) => {
          // console.log(err)
          this.$message.success('删除成功')
          this.dialogVisible = false
          this.getliulanlist()
          this.getrizhinum()
        })
    },
    // 取消发留言
    exitfaliuyan() {
      this.isshowfaliuyan = false
      this.liuyantext = {}
    },
    // 发表留言请求
    faliuyanrequest() {
      this.liuyantext.userid = window.sessionStorage.getItem('userid')
      let newtime = new Date()
      var yy = newtime.getFullYear()
      var mm = newtime.getMonth() + 1
      var dd = newtime.getDate()
      this.liuyantext.lydate = yy + '-' + mm + '-' + dd
      this.$axios
        .post('/api/addLy/', this.liuyantext)
        .then((res) => {
          let userid = res.data
          if (data.info.code === '0' && data.data === 'OK') {
            this.$message.success('发表成功')
            this.isshowfaliuyan = false
            this.getliulanlist()
            this.getrizhinum()
            this.liuyantext = {}
          } else {
            this.$message.error('发表失败')
          }
          // this.$router.push('/home')
        })
        .catch((err) => {
          // console.log(err)
          this.isshowfaliuyan = false
          this.getliulanlist()
          this.getrizhinum()
          this.$message.success('发表成功')
          this.liuyantext = {}
        })
    },
    // 写留言区域显示
    faliuyan() {
      this.isshowfaliuyan = true
    },
    // 获取留言列表
    getliulanlist() {
      let userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/queryLyList/' + userid)
        .then((res) => {
          let data = res.data.LyList
          this.liuyanlist = data
          if (this.liuyanlist == null) {
            this.$message.error('获取留言列表失败')
          }
        })
        .catch((err) => {
          // console.log(err)
          this.$message.error('获取留言列表失败，请检查网络环境')
        })
    },
    bianjijiyu() {
      this.jiyushow = false
      this.bianjishow = true
      this.exitjiyu = this.selfjiyu
    },
    qvxiao() {
      this.jiyushow = true
      this.bianjishow = false
      this.bianjishow = null
    },
    baocun() {
      this.jiyushow = true
      this.bianjishow = false
      this.selfjiyu = this.exitjiyu
      this.exitjiyu = null
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
          this.dangan = data
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
    },
    getrizhinum() {
      let userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/countLy/' + userid)
        .then((res) => {
          let data = res.data
          this.liuyannum = data
        })
        .catch((err) => {})
    }
  }
}
</script>
<style lang="less" scoped>
.liulanbox {
  .liulantitle {
    float: left;
    height: 50px;
    width: 856px;
    margin-left: 22px;
    line-height: 50px;
    color: rgb(202, 176, 214);
    border-bottom: 2px solid rgb(227, 206, 246);
    // background: yellowgreen;
  }
  .liuyanjiyutitle {
    float: left;
    width: 844px;
    height: 42px;
    line-height: 42px;
    // background: red;
    margin-left: 28px;
    border-bottom: 1px solid rgb(220, 198, 241);
    .liuyanjiyutitlezhuren {
      float: left;
      height: 42px;
      line-height: 42px;
      font-weight: 600;
      color: rgb(68, 68, 68);
      font-size: 15px;
    }
    .liuyanjiyubianji {
      float: left;
      height: 22px;
      width: 100px;
      margin-top: 12px;
      line-height: 22px;
      margin-left: 10px;
      font-size: 12px;
      color: rgb(163, 118, 184);
      cursor: pointer;
      //   background: red;
    }
  }
  .liulanjiyushow {
    height: 100px;
    width: 844px;
    float: left;
    // background: yellowgreen;
    margin-left: 28px;
    margin-top: 11px;
    font-size: 13px;
  }
  .liuyanjiyubianji {
    height: 200px;
    width: 844px;
    float: left;
    // background: yellowgreen;
    margin-left: 28px;
    margin-top: 11px;
    font-size: 13px;
    .qvxiao {
      margin-top: 5px;
      background: rgb(211, 153, 240);
    }
    .baocun {
      background: rgb(211, 153, 240);
    }
  }
  .whiteliuyan {
    float: left;
    height: 200px;
    width: 844px;
    // background: turquoise;
    // border: 1px solid rgb(221, 221, 221);
    margin-left: 22px;
    .faliuyan {
      margin-top: 1px;
      background: rgb(211, 153, 240);
      color: white;
    }
  }
  .liulanliuyantitle {
    float: left;
    height: 40px;
    width: 844px;
    line-height: 40px;
    margin-left: 28px;
    font-size: 14px;
    font-weight: 600;
    color: rgb(68, 68, 68);
    border-bottom: 1px solid rgb(220, 198, 241);
    .liuyantiaoshu {
      float: left;
    }
    .woyaoliuyan {
      float: left;
      margin-left: 30px;
      font-size: 12px;
      margin-top: 3px;
      margin-left: 720px;
      color: rgb(172, 118, 184);
      cursor: pointer;
    }
  }
  .liulanmain {
    float: left;
    height: 600px;
    width: 844px;
    // background: yellowgreen;
    margin-left: 28px;
    margin-top: 1px;
    .liulanmainlist {
      float: left;
      width: 844px;
      height: 190px;
      border-bottom: 1px solid rgb(220, 198, 241);
      //   background: antiquewhite;
      .liulanmainlistleft {
        float: left;
        height: 190px;
        width: 83px;
        // background: aqua;
        .liulanmainlistleftimg {
          height: 52px;
          width: 52px;
          margin-left: 10px;
          margin-top: 18px;
          .imgmain {
            height: 100%;
            width: 100%;
          }
        }
      }
      .liulanmainlistright {
        float: left;
        width: 761px;
        height: 190px;
        // background: orange;
        .liulanmainlistrighttop {
          height: 50px;
          width: 761px;
          line-height: 50px;
          color: rgb(163, 118, 184);
          font-size: 14px;
        }
        .liulanmainlistrightcenter {
          width: 761px;
          height: 100px;
          font-size: 13px;
          color: rgb(68, 68, 68);
        }
        .liulanmainlistrightdown {
          width: 761px;
          height: 40px;
          //   background: aquamarine;
          font-size: 10px;
          color: rgb(181, 155, 155);
          .liulanmainlistrightdowntime {
            float: left;
          }
          .liulanmainlistrightdowndel {
            float: left;
            margin-left: 680px;
            .el-button {
              float: left;
              margin-top: -10px;
            }
          }
        }
      }
    }
  }
}
</style>
