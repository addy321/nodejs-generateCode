
var express = require('express')
var connectquery = require('../dao/connectquery')
var service = require('../service/index')
var jsonutil = require('../utils/jsontool/index')

var associate = express.Router()

/**
 *  查询数据中的所有表
 */
associate.get('/allTable', function (req, res) {
    connectquery.MysqlallTable(tables => {
        jsonutil.getJSONFile("/jsonConfig/itemConfig.json", function (err,itemConfig) {
            jsonutil.getJSONFile("/jsonConfig/templateConfig.json", function (err,templateConfig) {
                var data = {
                    items: itemConfig,
                    templates:templateConfig,
                    tables: tables
                }
                res.render('table.html', data)
            })
        })
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

/**
 *  根据选中的表名和项目模板生成代码
 */
 associate.post('/itemgenerateCode', function (req, res) {
    var data = req.body
    console.log(data)
    var itemid = data.itemid
    var tableNames =JSON.parse(data.tableNames)

    jsonutil.getJSONFile("/jsonConfig/itemConfig.json", function (err,itemConfig) {
        for (var i in itemConfig) {
            if (itemid == itemConfig[i].id) {
                itemConfig[i].status = 1
            }else{
                itemConfig[i].status = 0
            }
        }
        if(itemConfig == "" || itemConfig.length == 0){
            res.send("error")
            return
        }
        jsonutil.setJSONFile('/jsonConfig/itemConfig.json', itemConfig)
        tableNames.forEach(tableobj => {
            connectquery.MysqlallField(tableobj.tableName,fieids => {
                service.startTemplateConfig(tf=>{
                    service.outputFile(tableobj,fieids,tf)
                })
            })
        });
        res.send("success")
    })
})

/**
 *  根据选中的表名和项目模板生成代码
 */
 associate.post('/templatesCode', function (req, res) {
    var data = req.body
    var intemplates = JSON.parse(data.intemplates) 
    var tableNames = JSON.parse(data.tableNames)
    service.selectedTB(intemplates,tableNames)
    res.send("success")
})

module.exports = associate