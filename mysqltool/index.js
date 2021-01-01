var db = require('../db/dbConfig')
var filetool = require('../file/index')
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
            生成的类型: ['List', 'EditForm', 'update', 'delete']
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
                var fields = []
                fieldRES.forEach(field => {
                    if (field.表名 == tableRES[index].表名) {
                        fields.push(field)
                    }
                })
                createEntity(tableRES[index].表名, tableRES[index].表说明, fields)
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
            idobj: tool.getId(fields, tableName),
            package: 'CMSIBusiness'
        }
        item.生成的类型.forEach(filetype => {
            var res = getdir(item.语言 + '\\' + filetype)
            res.then((fun) => {
                if (fun) {
                    var text = fun(entityobj)
                    filetool.createFile(matchType(filetype, entityobj.className), text, item.文件后缀, item.语言 + "/" + filetype)
                }
            }).catch((err) => {
                console.log(err)
                console.log(item.语言 + "未配置" + filetype + "模板")
            })
        })

    })
}

function matchType(type, className) {
    className = tool.首字母转大写(className)
    if ("IBusiness" == type) {
        return "I" + className + "Business"
    }
    if ("entity" == type) {
        return className
    }
    return className + tool.首字母转大写(type)
}



module.exports = {
    main_a
}