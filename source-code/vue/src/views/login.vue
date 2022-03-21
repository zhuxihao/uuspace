<template>
  <div class="box">
    <div class="loginicon">UU空间</div>
    <div class="loginiconimg"></div>
    <div class="loginicontext">开 心 生 活 每 一 天</div>
    <div class="loginfrom">
      <div class="loginfromtitle">帐号密码登陆</div>
      <div class="loginregister" @click="showregisterform">注册新账号</div>
      <div class="loginfroml">
        <el-form
          :model="loginfromdata"
          :rules="loginfromrules"
          class="demo-ruleForm"
        >
          <el-form-item prop="username">
            <el-input
              v-model="loginfromdata.userName"
              placeholder="请输入账号"
            ></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input
              v-model="loginfromdata.password"
              placeholder="密码"
              show-password
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="success" :loading="loading" @click="loginrequest"
              >登陆</el-button
            >
          </el-form-item>
        </el-form>
      </div>
    </div>
    <!-- 注册账号弹出框区域 -->
    <el-dialog
      title="注册一个新的帐户"
      :visible.sync="isshowregister"
      width="50%"
    >
      <!-- 内容主体区域 -->
      <el-form
        :model="registerformdata"
        :rules="registerformrules"
        label-width="70px"
      >
        <el-form-item label="账号" prop="账号">
          <el-input v-model="registerformdata.userName"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="密码">
          <el-input
            v-model="registerformdata.password"
            show-password
          ></el-input>
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
// import { commonAPI } from '@/api/commonAPI'
export default {
  data() {
    return {
      loading: false,
      loginfromdata: {
        userName: '',
        password: ''
      },
      loginfromrules: {
        账号: [
          {
            required: true,
            message: '请输入正确的帐号',
            trigger: 'blur'
          },
          {
            min: 6,
            max: 10,
            message: '请输入正确的帐号',
            trigger: 'blur'
          }
        ]
      },
      txurll: require('../assets/headimg3.jpg'),
      registerformdata: {
        userName: '',
        password: '',
        uName: '',
        sex: '',
        age: '',
        job: '',
        txurl: ''
      },
      registerformrules: {
        账号: [
          {
            required: true,
            message: '请输入正确的帐号',
            trigger: 'blur'
          },
          {
            min: 6,
            max: 10,
            message: '请输入正确的帐号',
            trigger: 'blur'
          }
        ],
        年龄: [
          {
            type: 'integer',
            message: '年龄只能为数字',
            trigger: 'blur'
          }
        ]
      },
      isshowregister: false
    }
  },
  methods: {
    showregisterform() {
      this.isshowregister = true
    },
    exitregisterform() {
      this.isshowregister = false
      this.registerformdata = {}
    },
    // 登陆方法
    loginrequest() {
      this.loading = true
      setTimeout(() => {
        this.$axios
          .post('/api/queryUser/', this.loginfromdata)
          .then((res) => {
            let userid = res.data
            window.sessionStorage.setItem('userid', userid)
            if (userid != null) {
              this.$router.push('/home')
            } else {
              this.$message.error('用户名或密码错误')
            }
            // this.$router.push('/home')
          })
          .catch((err) => {
            // console.log(err)
            this.$message.error('登陆失败，请检查网络环境')
          })
        this.loading = false
      }, 2000)
    },
    // 注册方法
    registerrequest() {
      this.registerformdata.txurl = this.txurll
      this.$axios
        .get('/api/checkuser/' + this.registerformdata.userName)
        .then((res) => {
          let data = res.data
          if (data == 0) {
            this.$axios
              .post('/api/addUser/', this.registerformdata)
              .then((res) => {
                this.isshowregister = false
                this.registerformdata = {}
                if (res.data.info.code === '0' && res.data.data === 'OK') {
                  this.$message.success('注册成功')
                } else {
                  this.$message.error('注册失败')
                }
              })
              .catch((err) => {
                this.$message.error('注册失败')
              })
          } else {
            this.$message.error('该用户名已存在')
          }
        })
        .catch((err) => {
          this.$message.error('注册失败')
        })
    }
  }
}
</script>
<style lang="less" scoped>
.box {
  position: absolute;
  width: 100%;
  height: 100%;
  background: url(//qzonestyle.gtimg.cn/qzone/qzactStatics/imgs/20171123181522_c48800.jpg)
    no-repeat;
  // z-index: -10;
  zoom: 1;
  background-size: length(100%, 100%);
  -webkit-background-size: cover;
  -o-background-size: cover;
  background-position: center, center;
  // 固定背景图
  background-attachment: fixed;
  .loginicon {
    position: absolute;
    width: 300px;
    height: 80px;
    font-size: 50px;
    color: rgb(255, 255, 255);
    text-shadow: rgb(132, 134, 131) 0 0 20px;
    margin-left: 390px;
    margin-top: 110px;
  }
  .loginiconimg {
    position: absolute;
    height: 96px;
    width: 96px;
    background: url(../assets/iconimg.png);
    margin-left: 270px;
    margin-top: 74px;
  }
  .loginicontext {
    position: absolute;
    height: 30px;
    width: 500px;
    font-size: 25px;
    color: rgb(233, 229, 222);
    white-space: pre;
    margin-left: 298px;
    margin-top: 189px;
  }
  // opacity: 85%;
  .loginfrom {
    background: rgb(255, 255, 255);
    height: 312px;
    width: 413px;
    border-radius: 5px;
    border: 2px solid rgb(238, 238, 238);
    margin-left: 51.5%;
    margin-top: 8.5%;
    .loginfromtitle {
      position: absolute;
      height: 40px;
      font-size: 18px;
      line-height: 40px;
      margin-left: 150px;
    }
    .loginregister {
      position: absolute;
      cursor: pointer;
      height: 20px;
      margin-left: 329px;
      margin-top: 290px;
      width: 89px;
      font-size: 12px;
    }
    .el-button {
      height: 40px;
      width: 266px;
      margin-left: 1px;
    }
    .loginfroml {
      margin-left: 71px;
      .el-form {
        // width: 370px;
        margin-top: 98px;
        // margin-right: 111px;
        .el-form-item {
          // white-space: pre-line;
          .el-input {
            white-space: pre;
            height: 30px;
            width: 266px;
            margin-left: 1px;
            // pointer-events: none;
            // z-index: 10;
          }
        }
      }
    }
  }
}
</style>
