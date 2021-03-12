// 生成模块
var myquery = require('./main/index')

//app 核心包
var express = require('express')
//引入路由模块
var router = require('./appRouter/index')
// post 
const bodyParser = require('body-parser')

var path = require('path')

var app = express();

//开放静态资源
app.use('/public/', express.static(path.join(__dirname, './public/')))
app.use('/node_modules/', express.static(path.join(__dirname, './node_modules/')))

// 配置视图
app.engine('html', require('express-art-template'))

// 配置解析表单提交post 请求体插件(必须在挂载路由前)
app.use(bodyParser.urlencoded({extended:false}))
app.use(bodyParser.json())

// 挂载路由容器在app服务中
app.use(router)

app.listen(3000, function () {
    console.log("程序启动。。。。。 localhost:3000")
})

