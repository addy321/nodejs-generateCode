var db = require('../db/dbConfig')
var filetool = require('../file/index')
var entitymodel = require('../templatefiles/entity')
var daomodel = require('../templatefiles/ibusiness')
var tool = require('../utils/tool')
var getdir = require('../utils/load_dir')

var fileobje = {
    //数据名字
    mysqldb: 'NewProject',
    // 生成语言
    languages: [
        {
            语言: 'java',
            文件后缀: '.java',
            生成的类型: ['entity', 'dao', 'Service', 'ServiceImpl', 'Controller']
        },
        {
            语言: 'c#',
            文件后缀: '.cs',
            生成的类型: ['entity', 'IBusiness', 'Business', 'Controller']
        },
        {
            语言: 'html',
            文件后缀: '.html',
            生成的类型: ['list', 'add', 'update', 'delete']
        },
        {
            语言: 'vue',
            文件后缀: '.vue',
            生成的类型: ['list', 'add', 'update', 'delete']
        },
    ]
}


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
b.table_schema = '${fileobje.mysqldb}'
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
    a.table_schema = '${fileobje.mysqldb}'`)
    data.then((tableRES) => {
        getZD().then((fieldRES) => {
            // 遍历所有表
            for (var index in tableRES) {
                // 获取当前表的字段
                var data = []
                fieldRES.forEach(field => {
                    if (field.表名 == tableRES[index].表名) {
                        data.push(field)
                    }
                    createEntity(field.表名, tableRES[index].表说明, data)
                })
            }
        }).catch((err) => {
            console.log(err)
            console.log("失败")
        })
    }).catch((err) => {
        console.log("失败")
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
            idobj: tool.getId(fields, tableName)
        }

        console.log(entityobj)

        item.生成的类型.forEach(type => {
            var model = getdir(item.语言 + '\\' + type,type)
            if (model) {
                console.log(model)
                var text = model(entityobj)
                filetool.createFile(matchType(entityobj.className), text, item.文件后缀, item.语言 + "/" + type)
            }
        })

    })
}

function matchType(type, className) {
    if ("IBusiness" == type) {
        return "I" + className + "Business"
    }
    return className
}



module.exports = {
    main_a
}