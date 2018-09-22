new Vue({
    el: '#app',
    data: {
        message: 'Hello World',
        info: '',
        todos: [
            {
                id:1,
                title:'learn Vuejs',
                isFinished: true
            }
        ],
        newTodo:{
            id:null,
            title:'',
            isFinished: false
        }
    },
    methods:{
        addTodo(newTodo){
            this.todos.push(newTodo)
            this.newTodo={id:null,title:'',isFinished: false}
        },
        deleteTodo(index){
            this.todos.splice(index,1)
        },
        activeTodo(index) {
            this.todos[index].isFinished = !this.todos[index].isFinished;
        }
    },
})