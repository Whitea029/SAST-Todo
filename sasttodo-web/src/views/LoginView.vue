<template>
<div style="height:100vh;background-image:linear-gradient(135deg,#1352F2,#3C82F5);overflow:hidden;">
  <el-container style="padding: 30px;">
    <el-header>
      <el-row :gutter="10">
        <el-col :span="3">
          <img src="/imgs/admin/logo.png" style="height: 50px;">
        </el-col>
        <el-col :span="1">
          <img src="/imgs/login/verticalLine.png" style="height: 50px;">
        </el-col>
        <el-col :span="19">
          <span style="color:#fff;font-weight:bold;font-size:30px;">SAST-Todo</span>
        </el-col>
      </el-row>
    </el-header>
    <el-main>
      <el-row :gutter="40">
        <el-col :span="16">
          <img src="/imgs/login/bg.jpg" style="width:100%;margin-top:60px;">
        </el-col>
        <el-col :span="8">
          <el-card style="margin-top: 80px;">
            <h3 style="text-align: center;">用户登录</h3>
            <el-form label-position="top">
              <el-form-item label="用户名">
                <el-input placeholder="请输入学号" v-model="user.student_id"></el-input>
              </el-form-item>
              <el-form-item label="密码">
                <el-input placeholder="请输入密码" type="password" v-model="user.password"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" style="width: 100%;" @click="login">登录</el-button>
              </el-form-item>
            </el-form>
          </el-card>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</div>
</template>

<script setup>
  import {ref} from "vue";
  import axios from "axios";
  import {ElMessage} from "element-plus";
  import router from "@/router";

  //1.定义响应式对象用来保存登录表单中的数据
  const user = ref({student_id: '', password: ''});
  //2.定义登录方法(点击登录按钮时触发)
  const login = ()=>{
    console.log(user.value);
    //3.发出登录请求
    axios.post(BASE_URL+'/user/login',user.value)
        .then((response)=>{
          //回调函数：服务器响应后才执行此处代码
          //response是响应对象，我们可以通过response.data得到服务器的响应数据
          console.log(response.data);
          if(response.data.code==2000){
            ElMessage.success('登录成功！');
            //登录成功后向localStorage中存入用户信息
            //注意:必须是字符串类型的键值对!
            //JSON.stringify(response.data.data)将后端响应的userVO转为JSON格式的字符串
            localStorage.setItem('user',JSON.stringify(response.data.data));
            //登录成功后跳转至首页，并重定向到/user用户列表页
            router.push('/');
          }else{
            ElMessage.error(response.data.msg);
            //登录失败清空输入框
            user.value = {student_id: '', password: ''};
          }
        })
  }
</script>

<style scoped>

</style>