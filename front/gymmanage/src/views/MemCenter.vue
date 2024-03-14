<template>
  <div class="common-layout">
    <el-container >

      <el-header class="el-header-main">
        <h3>会员服务</h3>
      </el-header>

      <el-container>
        <el-aside width="200px">

          <el-menu
              default-active="1"
              active-text-color="#ffd04b"
              background-color="#545c64"
              class="el-menu-main"
              text-color="#fff"
          >

            <router-link to="/MemCoach">
              <el-menu-item index="1">
                <template #title>
                  <el-icon><location /></el-icon>
                  <span>预约教练</span>
                </template>
              </el-menu-item>
            </router-link>

            <router-link to="/MemCurse">
              <el-menu-item index="2">
                <el-icon><Menu /></el-icon>
                <span>购买课程</span>
              </el-menu-item>
            </router-link>

          </el-menu>

        </el-aside>

        <el-main>
          <router-view/>
        </el-main>
      </el-container>

    </el-container>
  </div>
</template>

<script>
import {Location, Menu } from '@element-plus/icons'

export default {
  components:{
    Location,
    Menu
  },
  name: "MemPage",
}
</script>

<style scoped>
  .el-header-main{
    color: aliceblue;
    background-color:#545c64
}
  .el-menu-main{
    height:100vh

}
</style>