<template>
  <div >

    <div class="content-header">

      <h1>交易查询系统</h1>

    </div>

    <div class="app-container">

      <div class="box">

        <div class="filter-container">
          <el-row >

            <el-col :span="3"><el-button  @click="changePage" class="butT">查询私教预约记录</el-button></el-col>

            <el-col :span="3"><el-button  @click="changePage" class="butT">查询公开课购买记录</el-button></el-col>

            <el-col :span="3"><el-input  placeholder="会员账号" v-model="pagination.queryString"  class="filter-item"></el-input></el-col>

            <el-col :span="2"><el-button  @click="changePage" class="butT">查询</el-button></el-col>

          </el-row>


        </div>

        <el-table size="small" current-row-key="id" :data="coaDataList" :key="Pagenum" stripe highlight-current-row>

          <el-table-column  fixed prop="orderid" align="center" label="订单号" v-if="isAll"></el-table-column>

          <el-table-column prop="coachid" label="教练号" align="center" v-if="isAll"></el-table-column>

          <el-table-column prop="cardnum" label="会员号" align="center" v-if="isAll"></el-table-column>

          <el-table-column prop="costtime" label="消费时间" align="center" v-if="isAll"></el-table-column>

          <el-table-column prop="costmoney" label="花费金额"  align="center" v-if="isAll"></el-table-column>

          <el-table-column prop="comment" label="备注" align="center" v-if="isAll"></el-table-column>

        </el-table>

        <el-table size="small" current-row-key="id" :data="curDataList" :key="Pagenum" stripe highlight-current-row>

          <el-table-column  fixed prop="orderid" align="center" label="订单号" v-if="!isAll"></el-table-column>

          <el-table-column prop="curseid" label="课程号" align="center" v-if="!isAll"></el-table-column>

          <el-table-column prop="cardnum" label="会员号" align="center" v-if="!isAll"></el-table-column>

          <el-table-column prop="costtime" label="消费时间" align="center" v-if="!isAll"></el-table-column>

          <el-table-column prop="costmoney" label="花费金额"  align="center" v-if="!isAll"></el-table-column>

          <el-table-column prop="comment" label="备注" align="center" v-if="!isAll"></el-table-column>

        </el-table>

      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
axios.defaults.withCredentials = true// 允许当前axios携带cookie
export default {
  name: "AdminOrder",
  data(){
    return{
      curDataList: [],  //课程购买记录
      coaDataList: [], //教练购买记录
      pagination:{},
      Pagenum:0,
      isAll:true
    }
  },
  created() {
    this.getAllCoa();
  },
  methods:{
    getAllCur() {
      //发送ajax请求
      axios.get('http://localhost:8080/adminorder/GetAllCur').then((res) => {
        this.curDataList = res.data;
        console.log(res.data)
      });
    },

    getAllCoa() {
      //发送ajax请求
      axios.get('http://localhost:8080/adminorder/GetAllCoa').then((res) => {
        this.coaDataList = res.data;
        console.log(res.data)
      });
    },

    changePage(){
      this.isAll=!this.isAll;
      this.Pagenum=Math.random();
      this.getAllCur();
    },

  }
}
</script>

<style scoped>

</style>