<template>
  <div >

    <div class="content-header">

      <h1>教练管理系统</h1>

    </div>

    <div class="app-container">

      <div class="box">

        <div class="filter-container">
          <el-row>

            <el-col :span="3"><el-input  placeholder="教练号" v-model="pagination.queryString"  class="filter-item"></el-input></el-col>

            <el-col :span="2"><el-button  @click="getAll()" class="butT">查询</el-button></el-col>

            <el-col :span="1"><el-button type="primary" class="butT" @click="handleCreate()">新增</el-button></el-col>

            <!--            <el-col :span="18"><el-button type="primary" class="butT" @click="turnCon()">Back</el-button></el-col>-->
          </el-row>


        </div>

        <el-table size="small" current-row-key="id" :data="dataList" stripe highlight-current-row>

          <el-table-column  fixed prop="coachid" align="center" label="教练号"></el-table-column>

          <el-table-column prop="name" label="教练姓名" align="center"></el-table-column>

          <!--          <el-table-column prop="passwd" label="密码"  align="center"></el-table-column>-->

          <el-table-column prop="gender" label="性别"  align="center"></el-table-column>

          <el-table-column prop="age" label="年龄" align="center"></el-table-column>

          <el-table-column prop="goodat" label="擅长方向" align="center" ></el-table-column>

          <el-table-column prop="selfintro" label="自我介绍" align="center"></el-table-column>

          <el-table-column prop="chargestandard" label="收费标准" align="center"></el-table-column>

          <el-table-column prop="phnum" label="手机号" align="center"></el-table-column>

<!--          <el-table-column prop="comment" label="备注" align="center"></el-table-column>-->

          <el-table-column  fixed="right" label="操作" align="center">

            <template #default={row}>

              <el-button type="primary" circle size="mini" @click="handleUpdate(row)">编辑</el-button>

              <el-button type="danger" circle size="mini" @click="handleDelete(row)">删除</el-button>

            </template>

          </el-table-column>

        </el-table>

        <!-- 新增标签弹层 -->

        <div class="add-form">

          <el-dialog title="新增教练信息" v-model="dialogFormVisible">
            <!--                    ref,相当于id,在此范围内的表单验证有效-->
            <el-form ref="dataAddForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="教练号" prop="coachid">

                    <el-input type="text" v-model="formData.coachid"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="教练名" prop="name">

                    <el-input  type="text" v-model="formData.name"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="性别" prop="gender">

                    <el-input  type="text" v-model="formData.gender"/>

                  </el-form-item>

                </el-col>

              </el-row>

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="年龄" prop="age">

                    <el-input type="text" v-model="formData.age"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="擅长" prop="goodat">

                    <el-input  type="text" v-model="formData.goodat"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="手机号码" prop="phnum">

                    <el-input type="text" v-model="formData.phnum"/>

                  </el-form-item>

                </el-col>
              </el-row>

<!--              <el-row>-->

<!--                <el-col :span="8">-->
<!--                  &lt;!&ndash;                                prop="model 的键名"&ndash;&gt;-->
<!--                  <el-form-item label="卡类型" prop="type">-->

<!--                    <el-radio v-model="formData.type" label="储蓄卡">储蓄卡</el-radio>-->
<!--                    <el-radio v-model="formData.type" label="折扣卡">折扣卡</el-radio>-->

<!--                    &lt;!&ndash;                                    <el-input  type="text" v-model="formData.state"/>&ndash;&gt;-->

<!--                  </el-form-item>-->

<!--                </el-col>-->

<!--                <el-col :span="8">-->

<!--                  <el-form-item label="状态" prop="status">-->

<!--                    <el-radio v-model="formData.status" label="正常">正常</el-radio>-->
<!--                    <el-radio v-model="formData.status" label="禁用">禁用</el-radio>-->
<!--                    <el-radio v-model="formData.status" label="注销">注销</el-radio>-->
<!--                    &lt;!&ndash;                                    <el-input  type="text" v-model="formData.state"/>&ndash;&gt;-->

<!--                  </el-form-item>-->

<!--                </el-col>-->

<!--              </el-row>-->

              <el-row>

                <el-col :span="12">

                  <el-form-item label="自我介绍">

                    <el-input v-model="formData.selfintro" type="textarea"></el-input>

                  </el-form-item>

                </el-col>

                <el-col :span="12">

                  <el-form-item label="收费标准">

                    <el-input v-model="formData.chargestandard" type="textarea"></el-input>

                  </el-form-item>

                </el-col>

              </el-row>

            </el-form>

            <div  class="dialog-footer">

              <el-button @click="dialogFormVisible = false">取消</el-button>

              <el-button type="primary" @click="handleAdd()">确认</el-button>

            </div>

          </el-dialog>

        </div>

        <!-- 编辑标签弹层 -->

        <div class="add-form">

          <el-dialog title="编辑教练信息" v-model="dialogFormVisible4Edit">

            <el-form ref="dataEditForm" :model="formData" :rules="rules" label-position="right" label-width="100px">

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="教练号" prop="coachid">

                    <el-input type="text" v-model="formData.coachid"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="教练名" prop="name">

                    <el-input  type="text" v-model="formData.name"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="性别" prop="gender">

                    <el-input  type="text" v-model="formData.gender"/>

                  </el-form-item>

                </el-col>

              </el-row>

              <el-row>

                <el-col :span="8">
                  <!--                                prop="model 的键名"-->
                  <el-form-item label="年龄" prop="age">

                    <el-input type="text" v-model="formData.age"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="擅长" prop="goodat">

                    <el-input  type="text" v-model="formData.goodat"/>

                  </el-form-item>

                </el-col>

                <el-col :span="8">

                  <el-form-item label="手机号码" prop="phnum">

                    <el-input type="text" v-model="formData.phnum"/>

                  </el-form-item>

                </el-col>
              </el-row>

              <!--              <el-row>-->

              <!--                <el-col :span="8">-->
              <!--                  &lt;!&ndash;                                prop="model 的键名"&ndash;&gt;-->
              <!--                  <el-form-item label="卡类型" prop="type">-->

              <!--                    <el-radio v-model="formData.type" label="储蓄卡">储蓄卡</el-radio>-->
              <!--                    <el-radio v-model="formData.type" label="折扣卡">折扣卡</el-radio>-->

              <!--                    &lt;!&ndash;                                    <el-input  type="text" v-model="formData.state"/>&ndash;&gt;-->

              <!--                  </el-form-item>-->

              <!--                </el-col>-->

              <!--                <el-col :span="8">-->

              <!--                  <el-form-item label="状态" prop="status">-->

              <!--                    <el-radio v-model="formData.status" label="正常">正常</el-radio>-->
              <!--                    <el-radio v-model="formData.status" label="禁用">禁用</el-radio>-->
              <!--                    <el-radio v-model="formData.status" label="注销">注销</el-radio>-->
              <!--                    &lt;!&ndash;                                    <el-input  type="text" v-model="formData.state"/>&ndash;&gt;-->

              <!--                  </el-form-item>-->

              <!--                </el-col>-->

              <!--              </el-row>-->

              <el-row>

                <el-col :span="12">

                  <el-form-item label="自我介绍">

                    <el-input v-model="formData.selfintro" type="textarea"></el-input>

                  </el-form-item>

                </el-col>

                <el-col :span="12">

                  <el-form-item label="收费标准">

                    <el-input v-model="formData.chargestandard" type="textarea"></el-input>

                  </el-form-item>

                </el-col>

              </el-row>

            </el-form>

            <div  class="dialog-footer">

              <el-button @click="dialogFormVisible4Edit = false">取消</el-button>

              <el-button type="primary" @click="handleEdit()">确认</el-button>

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
  name: "AdminCoach",
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
    // turnCon() {
    //   window.location.href = "main_page.html";
    // },

    //列表
    getAll() {
      //发送ajax请求
      axios.get('http://localhost:8080/AdminCoa/getAll').then((res) => {
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
    handleAdd() {
      //发送ajax请求
      axios.post('http://localhost:8080/AdminCoa/', this.formData).then((res) => {
        console.log(res.data);
        //如果操作成功，关闭弹层，显示数据
        this.dialogFormVisible = false;
      }).finally(() => {
        this.getAll();
      });
    },

    //弹出编辑窗口
    handleUpdate(row) {
      // console.log(row);   //row.id 查询条件
      //查询数据，根据id查询
      axios.get('http://localhost:8080/AdminCoa/' + row.coachid).then((res) => {
        // console.log(res.data.data);
        //展示弹层，加载数据
        this.formData = res.data;
        this.dialogFormVisible4Edit = true;

      });
    },

    //编辑
    handleEdit() {
      //发送ajax请求
      axios.put('http://localhost:8080/AdminCoa', this.formData).then((res) => {
        //如果操作成功，关闭弹层，显示数据
        console.log(res.data)
        this.dialogFormVisible4Edit = false;
      }).finally(() => {
        this.getAll();
      });
    },

    // 删除
    handleDelete(row) {
      //1.弹出提示框
      this.$confirm("This action will delete it forever,Confirm?", "warning", {
        type: 'info'
      }).then(() => {
        //2.做删除业务
        axios.delete('http://localhost:8080/AdminCoa/' + row.coachid).then((res) => {
          res.data
        }).finally(() => {
          this.getAll();
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