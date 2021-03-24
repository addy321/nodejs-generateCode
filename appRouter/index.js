
var express = require('express')
var main = require('../main/index')
var jsonutil = require('../utils/jsontool/index')
var fileutil = require('../utils/filetool/index')
var itempath = process.cwd()


var router = express.Router()

/**
 * 首页模板列表
 */
router.get('/', function (req, res) {
    jsonutil.getJSONFile("/jsonConfig/templateConfig.json", function (err,JSONData) {
        var data = {
            templateConfig: JSONData
        }
        res.render('index.html', data)
    })
})

/**
 *项目列表
 */
router.get('/items', function (req, res) {
    jsonutil.getJSONFile("/jsonConfig/itemConfig.json", function (err,JSONData) {
        var data = {
            items: JSONData
        }
        res.render('items.html', data)
    })
})

/**
 * mysql数据库连接
 */
router.get('/mysqlConn', function (req, res) {
    jsonutil.getJSONFile("/jsonConfig/mysqlConn.json", function (err,JSONData) {
        var data = {
            conns: JSONData
        }
        res.render('mysqlConn.html', data)
    })
})

/**
 * 编辑mysql数据连接配置
 */
router.post('/editmysqlConn', function (req, res) {
    var param = req.body
    jsonutil.getJSONFile("/jsonConfig/mysqlConn.json", function (err,JSONData) {
        for (var i in JSONData) {
            if (param.id == JSONData[i].id) {
                JSONData[i] = param
            }
        }
        jsonutil.setJSONFile('/jsonConfig/mysqlConn.json', JSONData)
        res.send("success")
    })
})

/**
 * 编辑模板
 */
router.get('/getTemplateConfig', function (req, res) {
    var id = req.query.id
    jsonutil.getJSONFile("/jsonConfig/templateConfig.json", function (err,JSONData) {
        var data = null
        for (var i in JSONData) {
            if (id == JSONData[i].id) {
                data = JSONData[i]
                break
            }
        }
        var filepath = itempath + "/" + data.path + '.js'
        filepath = filepath.replace(/\//g, "\\");
        fileutil.getFile(filepath, function (err1,text) {
            var reslet = {
                data: data,
                text: err1 || text
            }
            res.render('editTemplateConfig.html', reslet)
        })

    })
})


/**
 * 编辑生成项目配置
 */
router.get('/getItem', function (req, res) {
    var id = req.query.id
    jsonutil.getJSONFile("/jsonConfig/itemConfig.json", function (err,itemConfig) {
        var data = null
        for (var i in itemConfig) {
            if (id == itemConfig[i].id) {
                data = itemConfig[i]
                break
            }
        }
        jsonutil.getJSONFile("/jsonConfig/templateConfig.json", function (err,templateConfig) {
            var tlist = []
             // 获取对应的模板
            var ts = data.filetype
            ts.forEach(t=>{
                for (var i in templateConfig) {
                    if (t == templateConfig[i].id) {
                        tlist.push(templateConfig[i])
                        templateConfig.splice(i,1);
                        break
                    }
                }
            })
            var reslet = {
                data: data,
                tlist: tlist,
                templateConfig: templateConfig
            }
            res.render('editItem.html', reslet)
        })
    })
})

/**
 * 保存模板信息
 */
router.post('/saveTemplateConfig', function (req, res) {
    var data = req.body
    jsonutil.getJSONFile("/jsonConfig/templateConfig.json", function (err,JSONData) {
        console.log(data)
        if(data.id){
            for (var i in JSONData) {
                if (data.id == JSONData[i].id) {
                    JSONData[i] = data
                    break
                }
            }
            jsonutil.setJSONFile('/jsonConfig/templateConfig.json', JSONData)
            res.redirect("/getTemplateConfig?id="+data.id)
        }
    })
})

/**
 * 保存项目配置
 */
router.post('/saveitem', function (req, res) {
    var data = req.body
    data.filetype = data.filetype || []
    jsonutil.getJSONFile("/jsonConfig/itemConfig.json", function (err,JSONData) {
        console.log(data)
        if(data.id){
            for (var i in JSONData) {
                if (data.id == JSONData[i].id) {
                    JSONData[i] = data
                    break
                }
            }
            jsonutil.setJSONFile('/jsonConfig/itemConfig.json', JSONData)
            res.redirect("/getItem?id="+data.id)
        }
    })
})

/**
 * 生成项目代码
 */
router.get('/generateCode', function (req, res) {
    var id = req.query.id
    main.useTemplatefiles(id,function(error,reslet){
        if(error){
            res.send("出现错误")
        }
    })
    res.send("生成成功")
})

module.exports = router