<template>
  <form class="form-horizontal" v-on:submit.prevent="login(userinfo)">
    <span class="heading">用户登录</span>
    <div class="form-group">
      <input type="text" class="form-control" name="name" placeholder="用户名" v-model="userinfo.username">
      <i class="fa fa-user"></i>
    </div>
    <div class="form-group help">
      <input type="password" class="form-control" name="password" placeholder="密码" v-model="userinfo.password">
      <i class="fa fa-lock"></i>
      <a href="#" class="fa fa-question-circle"></a>
    </div>
    <div style="color:red;margin: -5px 0px 6px">
      {{info}}
    </div>
    <div class="form-group">
      <div class="main-checkbox">
        <input type="checkbox" value="None" id="checkbox1" name="check"/>
        <label for="checkbox1"></label>
      </div>
      <span class="text">Remember me</span>
      <button type="submit" class="btn btn-default">登录</button>
    </div>
  </form>
</template>

<script>

export default {
  name: 'login',
  data: function () {
    return {
      info: '',
      userinfo: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    login (userinfo) {
      var params = new URLSearchParams()
      params.append('username', userinfo.username.trim())
      params.append('password', userinfo.password.trim())
      this.$api.post('/user/login', params, r => {
        var msg = JSON.stringify(r)
        if (msg.indexOf('200') !== -1) {
          localStorage.data = msg
          this.$router.push('/index')
        } else {
          this.info = msg.substr(22, 4)
        }
      })
    }
  }
}
</script>

<style scoped>
  @import '../../static/css/bootstrap.min.css';
  @import '../../static/css/login.css';
</style>
