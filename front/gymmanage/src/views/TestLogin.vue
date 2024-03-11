<template>
    <nav>
      <router-link to="AdminCenter">Administrator</router-link>|
      <router-link to="MemCenter">Member</router-link>|
      <router-link to="registerView">register</router-link>|
      <router-link to="LoginView">login</router-link>
      <router-view/>
      <el-button onclick="location.href='/mainhtml/index.html'">首页</el-button>
    </nav>
</template>

<script>
export default {
  name: "TestLogin"
}
</script>

<style scoped>

</style>