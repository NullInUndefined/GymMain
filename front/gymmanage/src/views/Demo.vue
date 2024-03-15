<template>
  <div>
    <el-button type="primary" @click="dialogFormVisible = true">打开弹框</el-button>

    <el-dialog v-model="dialogFormVisible" title="Shipping address" width="500">
      <el-upload
        class="avatar-uploader"
        action="#"
        list-type="picture-card"
        :http-request="httpRequest"
      >
        <el-icon><Plus /></el-icon>
      </el-upload>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="dialogFormVisible = false">Cancel</el-button>
          <el-button type="primary" @click="dialogFormVisible = false">
            Confirm
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { Plus } from '@element-plus/icons';
import axios from "axios";
axios.defaults.withCredentials = true// 允许当前axios携带cookie
export default {
  name: 'demo-views',
  data () {
    return {
      // 控制对话框显隐
      dialogFormVisible: false
    };
  },
  components: {
    Plus
  },
  methods: {
    /**
     * 重写element-plus上传方法
     * @param { Object } file 文件对象
     * @param { String } filename 文件名字
     * @param { Fuction } onError 错误回调，执行该方法则表示文件上传失败
     * @param { Fuction } onSuccess 成功回调，执行该方法表示文件上传成功
     */
    httpRequest ({file, filename, onError, onSuccess}) {
      // new一个formData对象
      const formData = new FormData()
      // 将文件等入参放入formData中
      formData.append('file', file)
      formData.append('filename', filename)
      //发送ajax请求 
      axios.post(
        '文件上传请求地址', 
        formData, 
        {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        }
      ).then((res) => {
        // 上传成功则调用onSuccess方法
        if (res.status == 'success') {
          onSuccess()
        } else {
          // 失败则调用onError方法
          onError()
        }
      });
    }
  },
}
</script>

<style scoped>

</style>