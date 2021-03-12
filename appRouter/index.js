
var express = require('express')
var fs = require('fs')
var main = require('../main/index')

var router = express.Router()
var itempath = process.cwd()

/**
 * 首页模板列表
 */
router.get('/', function (req, res) {
    fs.readFile(itempath + '/jsonConfig/templateConfig.json', 'utf8', function (err1, templateConfig) {
        if (err1) throw new Error("读取模板配置文件失败!");
        var data = {
            templateConfig: JSON.parse(templateConfig)
        }
        res.render('index.html', data)
        main.main_a()
    })
})

/**
 * 编辑模板
 */
router.get('/editTemplateConfig', function (req, res) {
    fs.readFile(itempath + '/jsonConfig/templateConfig.json', 'utf8', function (err1, templateConfig) {
        if (err1) throw new Error("读取模板配置文件失败!");
        var data = {
            templateConfig: JSON.parse(templateConfig)
        }
        res.render('index.html', data)
    })
})

module.exports = router