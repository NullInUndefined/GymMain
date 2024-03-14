<template>
  <div >

    <div class="content-header">

      <h1>私教预约</h1>

    </div>

    <div class="app-container">

      <div class="box">

        <div class="filter-container">
          <el-row>

<!--            <el-col :span="3"><el-input  placeholder="教练号" v-model="pagination.queryString"  class="filter-item"></el-input></el-col>-->
            <el-col :span="2"><el-button  @click="changePage" class="butT">我的预约</el-button></el-col>
<!--            <el-col :span="2"><el-button @click="resetPage" class="butT">全部</el-button> </el-col>-->
            <!--            <el-col :span="18"><el-button type="primary" class="butT" @click="turnCon()">Back</el-button></el-col>-->
          </el-row>


        </div>

        <el-table size="small" current-row-key="id" :data="dataList" :key="Pagenum" stripe highlight-current-row>

          <el-table-column  fixed prop="coachid" align="center" label="教练号" v-if="isAll"></el-table-column>

          <el-table-column prop="name" label="教练姓名" align="center" v-if="isAll"></el-table-column>

          <!--          <el-table-column prop="passwd" label="密码"  align="center"></el-table-column>-->

          <el-table-column prop="gender" label="性别"  align="center" v-if="isAll"></el-table-column>

          <el-table-column prop="age" label="年龄" align="center" v-if="isAll"></el-table-column>

          <el-table-column prop="goodat" label="擅长方向" align="center" v-if="isAll" ></el-table-column>

          <el-table-column prop="selfintro" label="自我介绍" align="center" v-if="isAll"></el-table-column>

          <el-table-column prop="chargestandard" label="收费标准" align="center" v-if="isAll"></el-table-column>

          <el-table-column prop="phnum" label="手机号" align="center" v-if="isAll"></el-table-column>

          <!--          <el-table-column prop="comment" label="备注" align="center"></el-table-column>-->

          <el-table-column  fixed="right" label="操作" align="center" v-if="isAll">

            <template #default={row}>

              <el-button type="primary" circle size="mini" @click="handleCreate(row)">预定</el-button>

            </template>

          </el-table-column>

        </el-table>

          <el-table size="small" current-row-key="id" :data="OdataList" :key="Pagenum" stripe highlight-current-row>
          //展示订单页面
          <el-table-column  fixed prop="orderid" align="center" label="订单号" v-if="!isAll"></el-table-column>

          <el-table-column prop="cardnum" label="会员卡号" align="center" v-if="!isAll"></el-table-column>

          <el-table-column prop="coachid" label="教练号"  align="center" v-if="!isAll"></el-table-column>

          <el-table-column prop="costtime" label="交易时间" align="center" v-if="!isAll"></el-table-column>

          <el-table-column prop="costmoney" label="交易金额" align="center" v-if="!isAll" ></el-table-column>

          <el-table-column prop="comment" label="备注" align="center" v-if="!isAll"></el-table-column>

          <el-table-column  fixed="right" label="Operation" align="center" v-if="!isAll">

            <template #default={row}>

              <el-button type="danger" circle size="mini" @click="handleDelete(row)">删除</el-button>

            </template>

          </el-table-column>

        </el-table>

        <!-- 新增标签弹层 -->

        <div class="add-form">

          <el-dialog title="私教预约" v-model="dialogFormVisible">
            <!--                    ref,相当于id,在此范围内的表单验证有效-->
            <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="订单号" prop="orderid">

                    <el-input type="text" v-model="formData.orderid"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="会员卡号" prop="cardnum">

                    <el-input  type="text" v-model="formData.cardnum"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="教练号" prop="coachid">

                    <el-input  type="text" v-model="formData.coachid"/>

                  </el-form-item>

                </el-col>

              </el-row>

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="所需金额" prop="costmoney">

                    <el-input type="text" v-model="formData.costmoney"/>

                  </el-form-item>

                </el-col>

              </el-row>



              <el-row>

                <el-col :span="12">

                  <el-form-item label="备注">

                    <el-input v-model="formData.comment" type="textarea"></el-input>

                  </el-form-item>

                </el-col>

              </el-row>

            </el-form>

            <div  class="dialog-footer">

              <el-button @click="dialogFormVisible = false">取消</el-button>

              <el-button type="primary" @click="handleAdd()">确定</el-button>

            </div>

          </el-dialog>

        </div>

      </div>

    </div>

  </div>
</template>

<script>
import axios from "axios";
axios.defaults.withCredentials = true// 允许当前axios携带cookie
export default {
  name: "MemCoach",
  data(){
    return{
      OdataList:[],
      dataList: [],//当前页要展示的列表数据
      formData: {},//表单数据
      dialogFormVisible: false,//控制表单是否可见
      dialogFormVisible4Edit:false,//编辑表单是否可见
      isAll:true,
      Pagenum:0
    }
  },

  created() {
    this.getAll();
  },

  methods:{
    //列表
    getAll() {
      //发送ajax请求
      axios.get('http://localhost:8080/AdminCoa/getAll').then((res) => {
        this.dataList = res.data;
        console.log(res.data)
      });
    },

    //弹出添加窗口
    handleCreate(row) {
      this.dialogFormVisible = true;
      this.resetForm();
      this.formData.cardnum=this.$store.state.userAccount
      axios.get('http://localhost:8080/AdminCoa/' + row.coachid).then((res) => {
        // console.log(res.data.data);
        //展示弹层，加载数据
        this.formData.coachid=res.data.coachid
      });
    },

    //重置表单
    resetForm() {
      this.formData = {};
    },

    //添加
    handleAdd() {
      //发送ajax请求
      axios.post('http://localhost:8080/ordcoach/save', this.formData).then((res) => {
        console.log(res.data);
        //如果操作成功，关闭弹层，显示数据
        this.dialogFormVisible = false;
        alert("请求成功")
      }).finally(() => {
        this.getOrderAll();
      });
    },

    //订单相关
    getOrderAll(){
      axios.get('http://localhost:8080/ordcoach/'+this.$store.state.userAccount).then((res) => {
        this.OdataList = res.data;
        console.log(res.data)
      });
    },

    changePage(){
      this.isAll=!this.isAll;
      this.Pagenum=Math.random();
      this.getOrderAll();
    },

// 删除
  handleDelete(row) {
    //1.弹出提示框
    this.$confirm("This action will delete it forever,Confirm?", "warning", {
      type: 'info'
    }).then(() => {
      //2.做删除业务
      axios.delete('http://localhost:8080/ordcoach/' + row.orderid).then((res) => {
        res.data
      }).finally(() => {
        this.getOrderAll();
      });
    }).catch(() => {
      //3.取消删除
      this.$message.info("取消删除操作");
    });
  },


  }
}
</script>

<style scoped>

</style>