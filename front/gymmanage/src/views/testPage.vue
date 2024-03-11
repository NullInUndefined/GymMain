<template>
  <div >

    <div class="content-header">

      <h1>会员管理系统</h1>

    </div>

    <div class="app-container">

      <div class="box">

        <div class="filter-container">
          <el-row>

            <el-col :span="3"><el-input  placeholder="会员卡号" v-model="pagination.queryString"  class="filter-item"></el-input></el-col>

            <el-col :span="2"><el-button  @click="getAll()" class="butT">Check</el-button></el-col>

            <el-col :span="1"><el-button type="primary" class="butT" @click="handleCreate()">Creat</el-button></el-col>

<!--            <el-col :span="18"><el-button type="primary" class="butT" @click="turnCon()">Back</el-button></el-col>-->
          </el-row>


        </div>

        <el-table size="small" current-row-key="id" :data="dataList" stripe highlight-current-row>

          <el-table-column  fixed prop="cardnum" align="center" label="会员卡号"></el-table-column>

          <el-table-column prop="name" label="会员姓名" align="center"></el-table-column>

          <el-table-column prop="passwd" label="密码"  align="center"></el-table-column>

          <el-table-column prop="idnum" label="身份证号"  align="center"></el-table-column>

          <el-table-column prop="discount" label="折扣" align="center"></el-table-column>

          <el-table-column prop="phnum" label="手机号" align="center" ></el-table-column>

          <el-table-column prop="type" label="卡类型" align="center"></el-table-column>

          <el-table-column prop="allmoney" label="余额" align="center"></el-table-column>

          <el-table-column prop="status" label="状态" align="center"></el-table-column>

          <el-table-column prop="comment" label="备注" align="center"></el-table-column>

          <el-table-column  fixed="right" label="Operation" align="center">

            <template #default={row}>

              <el-button type="primary" circle size="mini" @click="handleUpdate(row)">Edit</el-button>

              <el-button type="danger" circle size="mini" @click="handleDelete(row)">Delete</el-button>

            </template>

          </el-table-column>

        </el-table>

        <!-- 新增标签弹层 -->

        <div class="add-form">

          <el-dialog title="Add Activity" v-model="dialogFormVisible">
            <!--                    ref,相当于id,在此范围内的表单验证有效-->
            <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="会员账号" prop="cardnum">

                    <el-input type="text" v-model="formData.cardnum"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="会员名" prop="name">

                    <el-input  type="text" v-model="formData.name"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="密码" prop="passwd">

                    <el-input type="text" v-model="formData.passwd"/>

                  </el-form-item>

                </el-col>
              </el-row>

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="身份证号" prop="idnum">

                    <el-input type="text" v-model="formData.idnum"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="折扣" prop="discount">

                    <el-input  type="text" v-model="formData.discount"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="手机号码" prop="phnum">

                    <el-input type="text" v-model="formData.phnum"/>

                  </el-form-item>

                </el-col>
              </el-row>

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="卡类型" prop="type">

                    <el-radio v-model="formData.type" label="储蓄卡">储蓄卡</el-radio>
                    <el-radio v-model="formData.type" label="折扣卡">折扣卡</el-radio>

                    <!--                                    <el-input  type="text" v-model="formData.state"/>-->

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="余额" prop="discount">

                    <el-input  type="text" v-model="formData.discount"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="状态" prop="status">

                    <el-radio v-model="formData.status" label="正常">正常</el-radio>
                    <el-radio v-model="formData.status" label="禁用">禁用</el-radio>
                    <el-radio v-model="formData.status" label="注销">注销</el-radio>
                    <!--                                    <el-input  type="text" v-model="formData.state"/>-->

                  </el-form-item>

                </el-col>

              </el-row>

              <el-row>

                <el-col :span="24">

                  <el-form-item label="备注">

                    <el-input v-model="formData.comment" type="textarea"></el-input>

                  </el-form-item>

                </el-col>

              </el-row>

            </el-form>

            <div  class="dialog-footer">

              <el-button @click="dialogFormVisible = false">Cancel</el-button>

              <el-button type="primary" @click="handleAdd()">Confirm</el-button>

            </div>

          </el-dialog>

        </div>

        <!-- 编辑标签弹层 -->

        <div class="add-form">

          <el-dialog title="EditCheckedOne" v-model="dialogFormVisible4Edit">

            <el-form ref="dataEditForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="会员账号" prop="cardnum">

                    <el-input type="text" v-model="formData.cardnum"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="会员名" disabled prop="name">

                    <el-input  type="text" v-model="formData.name"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="密码" prop="passwd">

                    <el-input type="text" v-model="formData.passwd"/>

                  </el-form-item>

                </el-col>
              </el-row>

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="身份证号" prop="idnum">

                    <el-input type="text" v-model="formData.idnum"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="折扣" prop="discount">

                    <el-input  type="text" v-model="formData.discount"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="手机号码" prop="phnum">

                    <el-input type="text" v-model="formData.phnum"/>

                  </el-form-item>

                </el-col>
              </el-row>

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="卡类型" prop="type">

                    <el-radio v-model="formData.type" label="储蓄卡">储蓄卡</el-radio>
                    <el-radio v-model="formData.type" label="折扣卡">折扣卡</el-radio>

                    <!--                                    <el-input  type="text" v-model="formData.state"/>-->

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="余额" disabled prop="discount">

                    <el-input  type="text" v-model="formData.discount"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="状态" prop="status">

                    <el-radio v-model="formData.status" label="正常">正常</el-radio>
                    <el-radio v-model="formData.status" label="禁用">禁用</el-radio>
                    <el-radio v-model="formData.status" label="注销">注销</el-radio>
                    <!--                                    <el-input  type="text" v-model="formData.state"/>-->

                  </el-form-item>

                </el-col>

              </el-row>

              <el-row>

                <el-col :span="24">

                  <el-form-item label="备注">

                    <el-input v-model="formData.comment" type="textarea"></el-input>

                  </el-form-item>

                </el-col>

              </el-row>

            </el-form>

            <div  class="dialog-footer">

              <el-button @click="dialogFormVisible4Edit = false">Cancel</el-button>

              <el-button type="primary" @click="handleEdit()">Confirm</el-button>

            </div>

          </el-dialog>

        </div>

      </div>

    </div>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "testPage",
  data(){
    return{
    pagination: {},
    dataList: [],//当前页要展示的列表数据
    formData: {},//表单数据
    dialogFormVisible: false,//控制表单是否可见
    dialogFormVisible4Edit:false,//编辑表单是否可见
    // rules: {//校验规则
    //     activityName: [{ required: true, message: 'must fill', trigger: 'blur' }],
    //     activityId: [{ required: true, message: 'must fill', trigger: 'blur' }]
    // }
    }
  },

  //钩子函数，VUE对象初始化完成后自动执行
  created() {
    this.getAll();
  },

  methods: {
    //返回control界面
    turnCon(){
      window.location.href="main_page.html";
    },

    //列表
    getAll() {
      //发送ajax请求
      axios.get('http://localhost:8080/mainpage/getAll').then((res)=>{
        this.dataList = res.data;
        console.log(res.data)
      });
    },

    //弹出添加窗口
    handleCreate() {
      this.dialogFormVisible = true;
      this.resetForm();
    },

    //重置表单
    resetForm() {
      this.formData = {};
    },

    //添加
    handleAdd () {
      //发送ajax请求
      axios.post("mainpage",this.formData).then((res)=>{
        console.log(res.data);
        //如果操作成功，关闭弹层，显示数据
        this.dialogFormVisible = false;
      }).finally(()=>{
        this.getAll();
      });
    },

    //弹出编辑窗口
    handleUpdate(row) {
      // console.log(row);   //row.id 查询条件
      //查询数据，根据id查询
      axios.get("/mainpage/"+row.cardnum+".action").then((res)=>{
        // console.log(res.data.data);
        //展示弹层，加载数据
        this.formData = res.data;
        this.dialogFormVisible4Edit = true;

      });
    },

    //编辑
    handleEdit() {
      //发送ajax请求
      axios.put("/mainpage.action",this.formData).then((res)=>{
        //如果操作成功，关闭弹层，显示数据
        res.data
        this.dialogFormVisible4Edit = false;
      }).finally(()=>{
        this.getAll();
      });
    },

    // 删除
    handleDelete(row) {
      //1.弹出提示框
      this.$confirm("This action will delete it forever,Confirm?","warning",{
        type:'info'
      }).then(()=>{
        //2.做删除业务
        axios.delete("/mainpage/"+row.cardnum+".action").then((res)=>{
          res.data
        }).finally(()=>{
          this.getAll();
        });
      }).catch(()=>{
        //3.取消删除
        this.$message.info("取消删除操作");
      });
    },

},
}


</script>

<style scoped>

</style>