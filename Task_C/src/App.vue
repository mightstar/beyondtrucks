<template>
  <el-container>
    <!-- Header -->
    <el-header class="header">
      <h1>Student Management System</h1>
    </el-header>

    <el-container class="body">
      <!-- Menu -->
      <el-aside width="200px" class="menu">
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="/students">Students</a></li>
          <li><a href="/settings">Settings</a></li>
        </ul>
      </el-aside>

      <!-- Content -->
      <el-main class="content">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts">
export default {
  name: 'App',
};
</script>

<style scoped>
/* Header Styles */
.header {
  background-color: #409eff;
  color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 60px;
  font-size: 20px;
  font-weight: bold;
}

.body {
  height: 89vh;
}

/* Menu Styles */
.menu {
  background-color: #f0f2f5;
  padding: 10px;
  border-right: 1px solid #dcdcdc;
}

.menu ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.menu ul li {
  margin: 10px 0;
}

.menu ul li a {
  text-decoration: none;
  color: #333;
}

.menu ul li a:hover {
  color: #409eff;
}

/* Content Styles */
.content {
  padding: 20px;
}
</style>
