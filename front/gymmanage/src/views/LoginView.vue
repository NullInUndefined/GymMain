<template>
  <el-row type="flex" justify="center">
    <el-form ref="loginData" :model="formData" :rules="rules" label-width="80px" >
      <el-form-item prop="account" label="账号"><el-input v-model="formData.account" placeholder="请输入用户名" ></el-input></el-form-item>
      <el-form-item prop="password" label="密码"><el-input v-model="formData.passwd" placeholder="请输入密码" type="password" ></el-input></el-form-item>
<!--      <el-form-item prop="type" label="账号类型">-->
        <!--        <el-input v-model="formData.password" placeholder="请输入密码" type="password" prefix-icon="icon-login_pwd" clearable></el-input>-->
<!--        <el-radio v-model="formData.type" label="Admin" >管理员</el-radio>-->
<!--        <el-radio v-model="formData.type" label="Member" >会员</el-radio>-->
<!--      </el-form-item>-->
      <el-form-item><el-button type="primary" class="btn" @click="login('formData')" icon="el-icon-upload">登录</el-button>
      <router-link to="registerView">没有账号？注册</router-link>
      </el-form-item>
    </el-form>
  </el-row>
</template>
<script>
import axios from "axios";
import {mapState} from "vuex";
export default {
  name:"LoginView",
  computed:{
    ...mapState(["userAccount"])
  },
  data() {
    return {
      formData: {},
      rules: {
        account: [{ required: true, message: '用户名不能为空', trigger: 'blur' }],
        passwd: [{ required: true, message: '密码不能为空', trigger: 'blur' }]
      }
    };
  },

  methods:{
      login:function () {
        this.$store.state.userAccount = this.formData.account;
        //发送ajax请求
        axios.post('http://localhost:8080/loginAndRegister/selectUserName', this.formData).then((res) => {
          console.log(res);
          //如果操作成功，关闭弹层，显示数据
          if(res.data=="Admin")
            this.$router.push({path:'/AdminCenter'})
          else
            this.$router.push({path:'/MemCenter'})
        })
      },
      //   axios.post('http://localhost:8080/loginAndRegister/selectUserName', {
      //     account: this.account,
      //     passwd: this.passwd,
      //     // type:this.type,
      //     // headers: {'Content-Type': 'application/x-www-form-urlencoded'}   //跨域
      //   }).then(function (dat) {
      //     console.log(dat)
      //     if (dat.data == '0')
      //       alert("用户不存在")
      //     else if (dat.data == '1')
      //       alert("登录失败，账号或密码错误")
      //     else if (dat.data == '2'){
      //       //当前窗体跳转
      //       if(dat.data.type=="Member")
      //       this.$router.push({name:'mainPage'});
      //       else if(dat.data.type=="Admin")
      //       this.$router.push({name:'AdminCenter'})
      //     }
      //   }).catch(function () {
      //     console.log("传输失败")
      //   })
      // },

      // register:function () {
      //   this.$router.push({name:'registerView'})
      //   // window.location.href = "user/register"
      // }
    }
}
</script>