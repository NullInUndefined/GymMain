<template >
<!--  <nav>-->
<!--    <router-link to="AdminCenter">Administrator</router-link>|-->
<!--    <router-link to="MemCenter">Member</router-link>|-->
<!--    <router-view/>-->
<!--    <el-button onclick="location.href='/mainhtml/index.html'">跳转</el-button>-->
<!--  </nav>-->
<div style="height: 98vh;width: 100%">

  <iframe src="/mainhtml/index.html"  width="100%" height="95%"></iframe>
  <el-affix :offset="0" >
    <el-button type="primary" round @click="login">登录</el-button>
    <el-button type="success" round @click="register">注册</el-button>
  </el-affix>
</div>



</template>

<script>
export default {
  name: "mainPage",

  methods:{
    login(){
      this.$router.push('/LoginView')
    },
    register(){
      this.$router.push('/registerView')
    }
  }
}
</script>

<style scoped>

</style>