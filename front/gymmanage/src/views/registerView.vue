<template>
  <el-row type="flex" justify="center">
    <el-form :model="formData" :rules="rules" label-width="80px" >
      <el-form-item prop="account" label="用户名"><el-input v-model="formData.account" placeholder="请输入用户名" prefix-icon="icon-login_user" clearable></el-input></el-form-item>
      <el-form-item prop="passwd" label="密码"><el-input v-model="formData.passwd" placeholder="请输入密码" type="password" prefix-icon="icon-login_pwd" clearable></el-input></el-form-item>
<!--      <el-form-item prop="checkPassword" label="确认密码"><el-input placeholder="再次输入密码" type="password" prefix-icon="icon-login_pwd" clearable></el-input></el-form-item>-->
      <el-form-item prop="type" label="账号类型">
<!--        <el-input v-model="formData.password" placeholder="请输入密码" type="password" prefix-icon="icon-login_pwd" clearable></el-input>-->
        <el-radio v-model="formData.type" label="Admin">管理员</el-radio>
        <el-radio v-model="formData.type" label="Member">会员</el-radio>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleAdd('formData')" icon="el-icon-upload">注册</el-button>
<!--        <el-button @click="resetForm('formData')">重置</el-button>-->
      </el-form-item>
      <router-link to="loginView">已有密码？登录</router-link>

    </el-form>
  </el-row>
</template>
<script>
import axios from "axios";

export default {
  name:"registerView",
  data() {
    return {
      formData: {},
      rules: {
        account: [{ required: true, message: '用户名不能为空', trigger: 'blur' }],
        passwd: [{ required: true, message: '密码不能为空', trigger: 'blur' }],
        // checkPassword: [{ required: true, message:'请再次输入密码',trigger: 'blur' }]
      }
    };
  },
  methods: {
    handleAdd() {
      //发送ajax请求
      axios.post('http://localhost:8080/loginAndRegister/addUser', this.formData).then((res) => {
        console.log(res);
        if(res.data=="1"){
          alert("注册成功")
          this.$router.push({path:'/LoginView'})
        }
        else alert("账号重复")
        //如果操作成功，关闭弹层，显示数据
        // this.dialogFormVisible = false;
      })
    },
  },
}
</script>