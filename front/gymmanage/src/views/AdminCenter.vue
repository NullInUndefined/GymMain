<template>
  <div class="common-layout">
    <el-container >
      <el-header class="el-header-main">
        <h3>健身房管理系统</h3>
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
            <router-link to="/AdminMem">
              <el-menu-item index="1">
                <template #title>
                  <el-icon><location /></el-icon>
                  <span>会员管理</span>
                </template>
              </el-menu-item>
            </router-link>

            <router-link to="/AdminCurse">
              <el-menu-item index="2">
                <el-icon><Menu /></el-icon>
                <span>课程管理</span>
              </el-menu-item>
            </router-link>

            <router-link to="/AdminCoach">
              <el-menu-item index="3">
                <el-icon><Document /></el-icon>
                <span>教练管理</span>
              </el-menu-item>
            </router-link>

            <router-link to="/AdminOrder">
              <el-menu-item index="4">
                <el-icon><Avatar /></el-icon>
                <span>订单查询</span>
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
import {Location, Menu ,Document,Avatar} from '@element-plus/icons'
export default {
  components:{
    Location,
    Menu,
    Document,
    Avatar
  },
  name: "AdminCenter",
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
