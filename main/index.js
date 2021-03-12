var filetool = require('../utils/filetool/index')
var tool = require('../utils/tool')
var getdir = require('../utils/load_dir')
var connectquery = require('./connectquery')
var fs = require('fs')



/*
查询要生成的类型
 */
function main_a() {
    var itempath = process.cwd()
    fs.readFile(itempath + '/jsonConfig/templateConfig.json', 'utf8', function (err1, templateConfig) {
        if (err1) throw new Error("读取模板配置文件失败!");
        
        fs.readFile(itempath + '/jsonConfig/itemConfig.json', 'utf8', function (err2, itemConfig) {
            if (err2) throw new Error("读取项目配置失败!");

            // 读取模板配置
            var fileTypes = JSON.parse(templateConfig);
            var templates = []

            // 读取项目配置
            var items= JSON.parse(itemConfig);
            var templates = []
    
            items.forEach(x=>{
                if(x.status == false) return
                x.filetype.forEach(typeid=>{
                    fileTypes.forEach(f=>{
                        if(typeid == f.id) {
                            templates.push(f)
                        }
                    })
                })
            })
            queryMysql(templates)
        })
    });
}

/**
 * msyql 生成文件
 * @param {[]} templates 生产的模板信息
 */
function queryMysql(templates) {
    // 所有表名和注释
    connectquery.MysqlallTable(tables => {
        tables.forEach(table => {
            // 查询表下面的所有字段信息
            connectquery.MysqlallField(table.tableName, fieids => {
                outputFile(table, fieids,templates)
            })
        })
    })
}

/**
 * 
 * @param {{}} table 表的信息
 * @param {[]} fieids  表中字段信息
 * @param {[]} templates  生成模板
 */
function outputFile(table,fieids,templates){
    templates.forEach(t=>{
        var fileobje ={
            BigclassName:tool.首字母转大写(table.tableName),
            className:table.tableName, // 类名
            classCaption:table.tableDirections, // 类注释
            packageName:t.packageName, // 包名
            PRI:tool.getPRI(fieids), //主键字段信息
            fields:fieids,  // 所有字段 [] 数组形式
            type:t.type // 语言
        }
        var res = getdir(t.path)
        res.then((fun) => {
            var text = fun(fileobje) // 调用模板生成字符串
            filetool.createFile(text,t.Pathdiameter,fileobje.BigclassName+t.addtext,t.suffix) // 生成文件
        }).catch((err) => {
            console.log(err)
            console.log(t.path + "生成时发生错误")
        })
    })
}

function matchType(type, className, isaddtype) {
    className = tool.首字母转大写(className)
    if ("IBusiness" == type) {
        return "I" + className + "Business"
    }
    if ("entity" == type) {
        return className
    }
    if (isaddtype === true) {
        return className
    }
    return className + tool.首字母转大写(type)
}

module.exports = {
    main_a
}