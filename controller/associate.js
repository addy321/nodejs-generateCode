
var express = require('express')
var connectquery = require('../dao/connectquery')
var service = require('../service/index')

var associate = express.Router()

/**
 *  查询数据中的所有表
 */
associate.get('/allTable', function (req, res) {
    connectquery.MysqlallTable(tables => {
        var data = {
            tables: tables
        }
        res.render('table.html', data)
    })
})
/**
 *  查询数据中的表中字段
 */
associate.get('/allTablefieids', function (req, res) {
    var tableName = req.query.tableName
    connectquery.MysqlallField(tableName,fieids => {
        res.json(fieids)
    })
})

/**
 *  生成单个表的代码
 */
associate.post('/tableCode', function (req, res) {
    var tableobj = req.body
    connectquery.MysqlallField(tableobj.tableName,fieids => {
        service.startTemplateConfig(x=>{
            service.outputFile(tableobj,fieids,x)
        })
        res.send("success")
    })
})

module.exports = associate