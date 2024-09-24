<!--父级页面:控制除了登录页以外所有页面共有的头部与左侧菜单栏-->
<template>
  <!-- display: flex;给父元素使用弹性布局
   效果:所有子元素横置,且父元素会根据子元素的实际高度自动填充高度-->
  <div style="display: flex;">
    <!--isCollapse为true:折叠左侧菜单栏,左侧菜单栏宽度为64px,右侧主体宽度为calc(100% - 64px)-->
    <!--isCollapse为false:不折叠左侧菜单栏,左侧菜单栏宽度为208px,右侧主体宽度为calc(100% - 208px)-->
    <!-- 左侧菜单栏 -->
    <div :style="{width:(isCollapse ? '64px' : '208px')}">
      <el-menu
          background-color="#3C82F5"
          text-color="#fff"
          active-text-color="#ff0"
          style="width:100%;height:100vh;"
          unique-opened
          :collapse="isCollapse"
          :collapse-transition="false"
          router
          @select="selectMenu"
      >
        <el-row style="padding-top: 10px;">
          <el-col :span="2"></el-col>
          <el-col :span="7" style="padding-left: 7px;">
            <el-avatar src="/imgs/admin/logo.png" style="width: 35px;height: 35px;"></el-avatar>
          </el-col>
          <el-col :span="isCollapse ? 0 : 13">
            <router-link to="/"
                         style="text-decoration:none;color:#fff;font-weight:bold;position:relative;top:8px;left:2px;">
              SAST-Todo
            </router-link>
          </el-col>
        </el-row>
        <el-sub-menu index="1">
          <template #title>
            <el-icon style="font-size: 21px;"><User/></el-icon>
            <span>用户管理</span>
          </template>
          <el-menu-item index="/user">用户列表</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="2">
          <template #title>
            <el-icon style="font-size: 21px;"><Van/></el-icon>
            <span>任务管理</span>
          </template>
          <el-menu-item index="/vehicle">基本信息</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </div>
    <!-- 右侧主体内容 -->
    <div :style="{width:(isCollapse ? 'calc(100% - 64px)' : 'calc(100% - 208px)')}">
      <!-- 右侧顶部条:折叠按钮+用户名 -->
      <el-header style="padding-top:22px;height:10vh;background-color:#fff;">
        <el-row :gutter="10">
          <el-col :span="18">
            <el-icon style="font-size:20px;" @click="changeCollapse"><Expand/></el-icon>
          </el-col>
          <el-col :span="6" style="position: relative;">
            <el-dropdown trigger="click" style="position: absolute;right: 20px;">
              <span style="font-size: 19px;font-weight: bold;">
                {{user.student_id}}
                <el-icon><arrow-down/></el-icon>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </el-col>
        </el-row>
        <!-- 面包屑导航 -->
        <el-breadcrumb separator="/" style="position:relative;top:20px;">
          <el-breadcrumb-item>首页</el-breadcrumb-item>
          <el-breadcrumb-item v-for="item in breadcrumb">{{item}}</el-breadcrumb-item>
        </el-breadcrumb>
      </el-header>
      <!-- 右侧主体内容:除顶部条与面包屑之外的可变区域,具体的部分在子页面中写! -->
      <el-main style="height: 90vh;padding: 0;overflow-y:auto;">
        <router-view/>
      </el-main>
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";

//定义变量控制菜单栏是否折叠
const isCollapse = ref(false);

//修改左侧菜单折叠状态
const changeCollapse = () => {
  isCollapse.value = !isCollapse.value;
}

//获取当前登录的用户对象
const user = ref(getUser());

//定义数组用来保存面包屑导航显示的值
const breadcrumb = ref(
    JSON.parse(localStorage.getItem('breadCrumb')) || ['用户管理','用户列表']);
//维护面包屑导航与菜单项index的对应关系
let map = {
  "/user": ['用户管理','用户列表'],
  "/task": ['任务管理','基本信息']
}
//只要选择菜单项,就切换面包屑的值
const selectMenu = (index)=>{
  breadcrumb.value = map[index];
  //解决面包屑刷新丢失问题:存到localStorage中
  localStorage.setItem('breadCrumb',JSON.stringify(breadcrumb.value));
}

//退出登录功能
const logout = ()=>{
  if(confirm('您确认要退出登录吗?')){
    //退出时要清空用户与面包屑数据
    localStorage.removeItem('user');
    localStorage.removeItem('breadCrumb');
    //退出后要去到登录页
    window.location.href = '/login';
    //也需要把已经取出来的user对象清空
    user.value = '';
  }
}
</script>
