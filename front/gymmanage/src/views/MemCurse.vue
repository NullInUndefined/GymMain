<template>
  <div>
    <div class="content-header">
      <h1>公开课购买</h1>
    </div>
    <div class="app-container">
      <!-- 列表项 -->
      <card-list
        :cardData="cardData"
        @handleClick="handleClick"
      />
    </div>

    <!-- 分页 -->
    <el-pagination
      class="pagination"
      v-model:current-page="currentPage"
      v-model:page-size="pageSize"
      :page-sizes="[10, 20, 50, 100]"
      :small="false"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="getData"
      @current-change="getData"
    />

    <!-- 详情框 -->
    <el-dialog v-model="dialogFormVisible" title="教练详情信息" width="500">
      <el-image 
        class="detail-form-avatar"
        style="width: 100px; height: 100px" 
        :src="detailForm.avatar" 
      />
      <el-form :model="detailForm" label-width="100px">
        <el-form-item label="教练id">
          <el-input v-model="detailForm.id" readonly />
        </el-form-item>
        <el-form-item label="教练姓名">
          <el-input v-model="detailForm.name" readonly />
        </el-form-item>
        <el-form-item label="教练性别">
          <el-input v-model="detailForm.gender" readonly />
        </el-form-item>
        <el-form-item label="教练特长">
          <el-input v-model="detailForm.speciality" readonly />
        </el-form-item>
        <el-form-item label="自我介绍">
          <el-input 
            v-model="detailForm.introduction" 
            readonly 
            :autosize="{ minRows: 2, maxRows: 4 }"
            type="textarea"
          />
        </el-form-item>
        <el-form-item label="收费标准">
          <el-input v-model="detailForm.feeStandards" readonly />
        </el-form-item>
        <el-form-item label="电话号码">
          <el-input v-model="detailForm.phone" readonly />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="purchaseCourse">
            订购
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>
<script>
import CardList from '@/components/card-list'
export default {
  name: "MemCurse",
  data() {
    return {
      // 卡片列表数据
      cardData: [
        {
          id: '123',
          name: 'zhengy',
          gender: '男',
          speciality: '跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步跑步',
          introduction: '我是一个练习时长两年半的实习生',
          feeStandards: '每小时300$',
          phone: '110',
          avatar: require('@/assets/logo.png')
        },
        {
          id: '123',
          name: 'zhengy',
          gender: '男',
          speciality: '跑步',
          introduction: '我是一个练习时长两年半的实习生',
          feeStandards: '每小时300$',
          phone: '110',
          avatar: require('@/assets/logo.png')
        },
      ],
      // 控制详情框显隐
      dialogFormVisible: false,
      // 详情信息表单
      detailForm: {},
      // 当前页
      currentPage: 1,
      // 每页数据长度
      pageSize: 10,
      // 数据总长度
      total: 0,
    }
  },
  components: {
    CardList
  },
  created() {
    // this.getData();
  },
  methods: {
    /**
     * 卡片点击回调
     * @param { Object } item 点击的卡片项数据
     * @param { index } index 点击的卡片下标
     */
    handleClick (item) {
      this.detailForm = item
      this.dialogFormVisible = true
    },
    /**
     * 请求列表数据
     */
    getData () {
      
    },
    /**
     * 订购课程
     */
    purchaseCourse () {
      
    }
  }
}
</script>
<style scoped>
.pagination {
  justify-content: center;
  margin-top: 20px;
}
.detail-form-avatar {
  margin-bottom: 20px;
}
</style>