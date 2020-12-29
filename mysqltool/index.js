var db = require('../db/dbConfig')
var filetool = require('../file/index')
var entitymodel = require('../templatefiles/entity')
var daomodel = require('../templatefiles/ibusiness')
var tool = require('../utils/tool')


// 数据名字
var mysqldb = 'NewProject'
// 生成文件的类型
var fileType = ['entity', 'IBusiness', 'Business', 'controller', 'vue']
// 生成文件的后缀
var files = ['.java', '.cs']


function main_a() {
    getTABLE()
}

// 获取所有字段
function getZD() {
    var data = db.querySql(`SELECT
a.table_name 表名,
a.table_comment 表说明,
b.COLUMN_NAME 字段名,
b.column_comment 字段说明,
b.column_type 字段类型,
b.column_key 约束 
FROM
information_schema. TABLES a
LEFT JOIN information_schema. COLUMNS b ON a.table_name = b.TABLE_NAME
WHERE
b.table_schema = '${mysqldb}'
ORDER BY
a.table_name`)
    return data
}

// 获取所有表明明
function getTABLE() {
    var data = db.querySql(`SELECT
    a.table_name 表名,
    a.table_comment 表说明
    FROM
    information_schema. TABLES a
    WHERE
    a.table_schema = '${mysqldb}'`)
    data.then((tableRES) => {
        getZD().then((fieldRES) => {
            // 遍历所有表
            for (var index in tableRES) {
                // 遍历所有创建文件的类型
                fileType.forEach(type => {
                    createEntity(tableRES[index].表名, tableRES[index].表说明, type, fieldRES)
                })
            }
        }).catch((err) => {
            console.log(err)
            console.log("读取数据库的所有字段失败")
        })
    }).catch((err) => {
        console.log("读取数据库的所有表名失败")
    })
}

function createEntity(tableName, tablePrompt, type, fields) {
    //console.log("-----------"+tableName, tablePrompt, filetype)
    var data = []
    fields.forEach(field => {
        if (field.表名 == tableName) {
            data.push(field)
        }
    })

    //创建实体类需要用到的参数
    var entityobj = {
        fields: data,
        name: tableName,
        tableName: tableName,
        tablePrompt: tablePrompt
    }
    console.log(tableName+'------------')
    tableName = tool.首字母转大写(tool.toHump(tableName))
    if (type == 'entity') {
        // 拼接内容
        files.forEach(suffix => {
            var text = entitymodel.model(tableName,entityobj,suffix)
            if(suffix == '.java'){
                filetool.createFile(tableName, text, suffix,"entity/java")
            }
            if(suffix == '.cs'){
                filetool.createFile(tableName, text, suffix,"entity/c#")
            }
        })
    }
    if(type == 'IBusiness'){
         // 拼接内容
         files.forEach(suffix => {
            console.log(tableName)
            var text = daomodel.model(tableName,entityobj,suffix)
            if(suffix == '.cs'){
                var entityName ='I'+tableName+'Business'
                filetool.createFile(entityName, text, suffix,'IBusiness')
            }
            if(suffix == '.java'){
                var entityName = tableName +'Dao'
                filetool.createFile(entityName, text, suffix,'dao')
            }
        })
    }
    if(type == 'Business'){

    }
}


module.exports = {
    main_a
}