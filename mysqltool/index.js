var filetool = require('../file/index')
var tool = require('../utils/tool')
var getdir = require('../utils/load_dir')
var connectquery = require('./connectquery')
var fs = require('fs')


// 生成语言
var languages = [
    {
        name: 'java',
        status: true,
        filetype: [1,2]
    },
    {
        name: 'c#',
        status: false,
        filetype: 1
    },
    {
        name: 'vue',
        status: false,
        filetype: 1
    },
    {
        name: 'html',
        status: false,
        filetype: 1
    },
]

/*
查询要生成的类型
 */
function main_a() {
    fs.readFile(__dirname + '/filejson.json', 'utf8', function (err, data) {
        if (err) console.log(err);
        var fileTypes = JSON.parse(data);//读取的值

        var templates = []

        languages.forEach(x=>{
            if(x.status == false) return
            console.log(x)
            x.filetype.forEach(typeid=>{
                fileTypes.forEach(f=>{
                    if(typeid == f.id) {
                        templates.push(f)
                    }
                })
            })
        })
        console.log("要生成的模板>>>>>>>>>>>")
        console.log(templates)
        queryMysql(templates)
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
            className:tool.首字母转大写(table.tableName)+t.addtext, // 类名
            classCaption:table.tableDirections, // 类注释
            packageName:t.packageName, // 包名
            PRI:tool.getPRI(fieids), //主键字段信息
            fields:fieids,  // 所有字段 [] 数组形式
            type:t.type // 语言
        }
        var res = getdir(t.path)
        res.then((fun) => {
            var text = fun(fileobje) // 调用模板生成字符串
            filetool.createFile(text,t.Pathdiameter,fileobje.className+t.addtext,t.suffix) // 生成文件
        }).catch((err) => {
            console.log(err)
            console.log(t.path + "生成时发生错误")
        })
    })
}


/**
 * tableName = 表名
 * tablePrompt = 表说明
 * fields = 表中字段
 */
function createEntity(tableName, tablePrompt, fields) {
    fileobje.languages.forEach(item => {
        //创建实体类需要用到的参数
        var entityobj = {
            fields: fields,
            tableName: tableName,
            tablePrompt: tablePrompt,
            className: tool.首字母转大写(tool.toHump(tableName)),
            type: item.语言,
            idobj: tool.getId(fields, tableName),
            package: 'CMSIBusiness'
        }
        item.生成的类型.forEach(filetype => {
            var res = getdir(item.语言 + '\\' + filetype)
            res.then((fun) => {
                if (fun) {
                    var text = fun(entityobj)
                    filetool.createFile(matchType(filetype, entityobj.className, item.文件不追加类型), text, item.文件后缀, item.语言 + "/" + filetype)
                }
            }).catch((err) => {
                console.log(err)
                console.log(item.语言 + "未配置" + filetype + "模板")
            })
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