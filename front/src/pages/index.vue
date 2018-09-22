<template>
  <div class="container">
    <div class="row">
      <div class="col-md-8 col-md-offset-2" style="margin: 10% auto 120px;">
        <div class="panel panel-default">
          <div class="panel-heading">
            Welcome Huizhe TodoList
            <br>
            {{info}}
          </div>
          <div class="panel-body">
            <h1> Hello {{user.username}}</h1>
            <ul class="list-group">
              <li class="list-group-item" v-for="(todo,index) in todos" :key="todo.index">
                <label v-bind:class="{finished:todo.status}" v-on:click="activeTodo(index)">
                  {{todo.content}}
                </label>
                <button style="float: right;" class="btn btn-warning btn-xs pull-right" v-on:click="deleteTodo(index)">Delete</button>
              </li>
            </ul>
            <form v-on:submit.prevent="">
              <div class="form-group" style="margin: 10px 0px;">
                <input type="text" class="form-control" placeholder="Add a new todo" v-model="newTodo.content">
              </div>
              <div class="from-group">
                <button class="btn btn-success button-margin" v-on:click="showAll()">All Item</button>
                <button class="btn btn-success button-margin" v-on:click="showActive()">showActive</button>
                <button class="btn btn-success button-margin" v-on:click="showDis()">showDis</button>
                <button class="btn btn-success button-margin" v-on:click="showYesterday()">Yesterday</button>
                <button class="btn btn-success button-margin" v-on:click="addTodo(newTodo)">Add Todo</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'index',
  data: function () {
    return {
      info: '',
      date: new Date(),
      params: new URLSearchParams(),
      user: {
        id: '',
        username: 'World',
        token: ''
      },
      todos: [
      ],
      newTodo: {
        index: null,
        id: '',
        content: '',
        status: 0
      }
    }
  },
  methods: {
    addparams (content, status) {
      this.params.append('content', content)
      this.params.append('status', status === true ? 1 : 0)
    },
    deleteparams () {
      this.params.delete('content')
      this.params.delete('status')
    },
    addTodo (newTodo) {
      this.addparams(newTodo.content, 0)
      this.$api.post('/matters/add', this.params, r => {
        this.deleteparams()
        newTodo.id = r.data.id
        this.todos.push(newTodo)
        this.newTodo = {index: null, id: '', content: '', status: 0}
      }, this.user.token)
    },
    deleteTodo (index) {
      this.$api.delete('/matters/' + this.todos[index].id + '/' + this.user.id, this.params, r => {
        this.todos.splice(index, 1)
      }, this.user.token)
    },
    activeTodo (index) {
      this.addparams(this.todos[index].content, !this.todos[index].status)
      console.log(this.todos[index].id)
      this.$api.put('/matters/' + this.todos[index].id, this.params, r => {
        this.todos[index].status = !this.todos[index].status
        this.deleteparams()
      }, this.user.token)
    },
    getItemByDate (format) {
      this.todos = []
      this.$api.get('/matters/date/' + this.user.id + '/' + format, this.params, r => {
        var length = r.data.length
        for (var i = 0; i < length; ++i) {
          this.todos.push(r.data[i])
        }
      }, this.user.token)
    },
    getItemByStatus (status) {
      this.todos = []
      this.$api.get('/matters/status/' + this.user.id + '/' + status, this.params, r => {
        var length = r.data.length
        for (var i = 0; i < length; ++i) {
          this.todos.push(r.data[i])
        }
      }, this.user.token)
    },
    showAll () {
      var format = this.date.getFullYear() + '-' + (this.date.getMonth() + 1) + '-' + this.date.getDate()
      this.getItemByDate(format)
    },
    showActive () {
      this.getItemByStatus(1)
    },
    showDis () {
      this.getItemByStatus(0)
    },
    showYesterday () {
      var format = this.date.getFullYear() + '-' + (this.date.getMonth() + 1) + '-' + (this.date.getDate() - 1)
      this.getItemByDate(format)
    }
  },
  created () {
    if (localStorage.data) {
      this.user = JSON.parse(localStorage.data).data
      this.params.append('user_id', this.user.id)
      var format = this.date.getFullYear() + '-' + (this.date.getMonth() + 1) + '-' + this.date.getDate()
      this.getItemByDate(format)
    } else {
      this.$router.push('/')
    }
  }
}
</script>

<style scoped>
  .finished {
    text-decoration: line-through;
  }
  li{
    font-size: 30px;
    line-height: 30px;
    text-align: left;
  }
  .button-margin{
    margin-bottom: 6px;
    margin-right: 13px;
    float: left;
  }
</style>
<style scoped>
  @import "../../static/css/bootstrap.min.css";
</style>
