<template>
  <div class="card-list">
    <el-card
      shadow="hover"
      v-for="(item, index) in cardData"
      :key="index"
      class="card-item"
      @click="handleClick(item, index)"
    >
      <el-image 
        style="width: 100px; height: 100px" 
        :src="item.avatar" 
      />
      <div class="info-wrapper">
        <div class="name">姓名：{{ item.name }}</div>
        <div class="speciality">特长：{{ item.speciality }}</div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'card-list',
  props: {
    cardData: {
      type: Array,
      default: () => ([])
    }
  },
  data () {
    return {

    };
  },
  methods: {
    /**
     * 卡片点击回调
     * @param { Object } item 点击的卡片项数据
     * @param { index } index 点击的卡片下标
     */
    handleClick (item, index) {
      this.$emit('handleClick', item, index)
    }
  }
}
</script>

<style scoped>
.card-list {
  display: flex;
  flex-wrap: wrap;
}
:deep(.el-card__body) {
  background: #f7f4c9;
}
.card-item {
  width: 200px;
  height: 200px;
  margin-right: 20px;
  cursor: pointer;
}
.name, .speciality {
  text-align: left;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  margin-top: 10px;
  font-family: "PingFang SC";
}
</style>