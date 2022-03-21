<template>
  <div class="rizhibox">
    <!-- 我的日志盒子 -->
    <div class="rizhilistbox" v-if="whiteorlookr">
      <div class="rizhititle">我的日志</div>
      <div class="rizhiwhitebutton">
        <el-button icon="el-icon-edit" class="whitebutton" @click="whiteorlook"
          >写日志</el-button
        >
      </div>
    </div>
    <!-- 写日志盒子 -->
    <div class="rizhiwhitebox" v-if="whiteorlookw">
      <div class="rizhiwhiteboxtitle">
        <div class="rizhibiaoti">日志标题</div>
        <el-input
          class="inputtitle"
          v-model="rizhiwhitetexttext.rzname"
          placeholder="请输入标题"
          :disabled="isdisabled"
        ></el-input>
      </div>
      <div class="rizhiwhiteboxmain">
        <el-input
          type="textarea"
          :rows="14"
          placeholder="请输入内容"
          :disabled="isdisabled"
          v-model="rizhiwhitetexttext.rztext"
        >
        </el-input>
      </div>
      <div class="rizhiwhiteorexitbutton">
        <el-button class="addandexit" type="info" @click="exitwhite"
          >取消</el-button
        >
        <el-button class="addandexit" type="success" @click="addwhite"
          >保存</el-button
        >
      </div>
    </div>
    <!-- 日志列表盒子 -->
    <div class="rizhilist" v-if="whiteorlookr">
      <div
        class="rizhilistdet"
        v-for="(item, idx) in rizhiwhitetextlist"
        :key="item.idx"
      >
        <div class="rizhilisttext">
          {{ item.rzname }}
        </div>
        <div class="rizhilisttexttime">
          {{ item.date1 }}
        </div>
        <el-button
          class="bianji"
          icon="el-icon-edit-outline"
          circle
          size="mini"
          @click="bianjirizhi(idx)"
        ></el-button>
        <el-button
          class="shanchu"
          icon="el-icon-delete"
          circle
          size="mini"
          @click="shanchu(idx)"
        ></el-button>
      </div>
    </div>
    <!-- 日志侧栏盒子 -->
    <div class="rizhisidebox" v-if="whiteorlookr">
      <div class="rizhisiderili">
        <el-calendar v-model="value" :range="['2020-12-21', '2021-1-10']">
        </el-calendar>
      </div>
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
        <el-button type="primary" @click="querenshanchu()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      // 删除日志索引值
      shanchurizhisuoyin: '',
      isdisabled: false,
      dialogVisible: false,
      whiteorlookw: false,
      whiteorlookr: true,
      rizhiwhitetextlist: [],
      rizhiwhitetexttext: {
        userid: '',
        rzname: '',
        rztext: '',
        date1: ''
      },
      value: new Date(),
      bianjiorxinde: true
    }
  },
  mounted() {
    this.getrizhilist()
  },
  methods: {
    // 显示写日志或者日志列表
    whiteorlook() {
      this.whiteorlookw = true
      this.whiteorlookr = false
      this.isdisabled = false
    },
    // 取消编写
    exitwhite() {
      this.whiteorlookw = false
      this.whiteorlookr = true
      this.rizhiwhitetexttext = {}
    },
    // 保存日志并返回
    addwhite() {
      let newtime = new Date()
      var yy = newtime.getFullYear()
      var mm = newtime.getMonth() + 1
      var dd = newtime.getDate()
      this.rizhiwhitetexttext.date1 = yy + '-' + mm + '-' + dd
      this.rizhiwhitetexttext.userid = window.sessionStorage.getItem('userid')
      this.$axios
        .post('/api/addRz', this.rizhiwhitetexttext)
        .then((res) => {
          console.log(this.rizhiwhitetexttext, '111')
          let data = res.data
          if (data.info.code === '0' && data.data === 'OK') {
            this.$message.success('发表成功')
          } else {
            this.$message.error('发表失败')
          }
          this.getrizhilist()
        })
        .catch((err) => {
          this.$message.success('发表成功')
          this.getrizhilist()
        })
      this.rizhiwhitetexttext = {}
      this.whiteorlookw = false
      this.whiteorlookr = true
    },
    // 查看日志
    bianjirizhi(idx) {
      this.rizhiwhitetexttext = this.rizhiwhitetextlist[idx]
      this.whiteorlookw = true
      this.whiteorlookr = false
      this.isdisabled = true
    },
    // 删除日志
    shanchu(idx) {
      this.shanchurizhisuoyin = idx
      this.dialogVisible = true
    },
    // 确认删除日志
    querenshanchu() {
      var id = this.rizhiwhitetextlist[this.shanchurizhisuoyin].id
      this.$axios
        .delete('/api/delRzbyid/' + id)
        .then((res) => {
          console.log('111')
          let data = res.data
          if (data.info.code === '0' && data.data === 'OK') {
            this.$message.success('删除成功')
            this.getrizhilist()
          } else {
            this.$message.error('删除失败')
          }
          // this.getrizhilist()
          // this.$router.push('/home')
        })
        .catch((err) => {
          // console.log(err)
          this.$message.success('删除成功')
          this.getrizhilist()
        })
      this.shanchurizhisuoyin = null
      this.dialogVisible = false
      this.getrizhilist()
    },
    // 获取日志列表
    getrizhilist() {
      // window.sessionStorage.setItem('userid', 1)
      var userid = window.sessionStorage.getItem('userid')
      this.$axios
        .get('/api/queryRznameList/' + userid)
        .then((res) => {
          console.log('111')
          let data = res.data.Rzlist
          this.rizhiwhitetextlist = data
          if (this.rizhiwhitetextlist == null) {
            this.$message.error('获取日志列表失败')
          }
        })
        .catch((err) => {
          // console.log(err)
          this.$message.error('获取日志列表失败')
        })
    }
  }
}
</script>
<style lang="less" scoped>
.rizhibox {
  // 我的日志盒子
  .rizhilistbox {
    .rizhititle {
      width: 860px;
      height: 50px;
      line-height: 50px;
      color: rgb(163, 118, 200);
      font-weight: 600;
      margin-left: 20px;
      border-bottom: 2px solid rgb(227, 206, 246);
    }
    .rizhiwhitebutton {
      margin-left: 20px;
      margin-top: 20px;
      width: 680px;
      height: 43px;
      border-bottom: 1px solid rgb(227, 206, 246);
      .whitebutton {
        border-radius: 6px;
        height: 38px;
        width: 110px;
        background: rgb(211, 153, 240);
        margin-top: -9px;
      }
    }
  }
  //   写日志盒子
  .rizhiwhitebox {
    margin-top: 20px;
    height: 96px;
    width: 900px;
    .rizhiwhiteboxtitle {
      height: 40px;
      line-height: 40px;
      width: 79%;
      margin-left: 1%;
      font-size: 18px;
      display: flex;
      margin-top: 6px;
      .rizhibiaoti {
        color: rgb(51, 44, 34);
        flex: 1;
      }
      .inputtitle {
        flex: 8;
      }
    }
    .rizhiwhiteboxmain {
      margin-top: 30px;
      width: 70%;
      margin-left: 10%;
    }
    .rizhiwhiteorexitbutton {
      margin-top: 10px;
      margin-left: 560px;
      width: 158px;
    }
  }
  // 日志列表盒子
  .rizhilist {
    float: left;
    height: 500px;
    // background: orange;
    width: 690px;
    .rizhilistdet {
      float: left;
      margin-top: 20px;
      line-height: 35px;
      height: 40px;
      width: 660px;
      margin-left: 20px;
      background: rgb(230, 238, 213);
      .rizhilisttext {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        margin-left: 10px;
        float: left;
        width: 400px;
        height: 40px;
        line-height: 40px;
      }
      .rizhilisttexttime {
        float: left;
        width: 100px;
        height: 40px;
        line-height: 40px;
        margin-left: 70px;
        font-size: 15px;
        // background: red;
      }
      .bianji {
        margin-top: 5px;
        float: left;
        margin-left: 5px;
      }
    }
  }
  //   日志侧栏盒子
  .rizhisidebox {
    float: left;
    width: 210px;
    height: 400px;
    .rizhisiderili {
      width: 210px;
      height: 300px;
      .el-calendar {
        font-size: 10px;
        text-align: center;
      }
    }
  }
}
</style>
