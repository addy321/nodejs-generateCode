var filetool = require('../utils/filetool/index')
var tool = require('../utils/tool')
var getdir = require('../utils/load_dir')
var connectquery = require('../dao/connectquery')
var jsonutil = require('../utils/jsontool/index')
var itempath = process.cwd()
var fs = require('fs')
var template = require('art-template');

/**
 * 获取启用中的模板
 * @param {Function} callback 返回可用模板List
 */
function startTemplateConfig(callback) {
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
            callback(templates)
        })
    });
}

/**
 * 生成启用项目的所以模板文件
 */
function main_a() {
    startTemplateConfig(templates=>{
        queryMysql(templates)
    })
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
 * 调用模板生成代码
 * @param {{}} table 表的信息
 * @param {[]} fieids  表中字段信息
 * @param {[]} templates  生成模板
 */
function outputFile(table,fieids,templates){
    templates.forEach(t=>{
        var thclassName = tool.toHump(table.tableName)
        var BgthclassName = tool.首字母转大写(thclassName)
        var fileobje ={
            classNameAddtext:BgthclassName+t.addtext, // 表名转驼峰首字母大写追加文件类型
            BigclassName: BgthclassName, //表名转驼峰首字母大写
            className: table.tableName, // 表名
            thclassName: thclassName, //表名转驼峰
            classCaption:table.tableDirections, // 类注释
            packageName:t.packageName, // 包名
            PRI:tool.getPRI(fieids), //主键字段信息
            fields:fieids,  // 所有字段 [] 数组形式
            type:t.type // 语言
        }
        if(t.tftype == 1){
            var res = getdir(t.path)
            res.then((fun) => {
                var text = fun(fileobje) // 调用模板生成字符串
                filetool.createFile(text,t.Pathdiameter,fileobje.classNameAddtext,t.suffix) // 生成文件
            }).catch((err) => {
                console.log(err)
                console.log(t.path + "生成时发生错误")
            })
        }else{
            try{
                var reslet = {
                    tf: fileobje
                }
                var text = template(itempath+"\\"+t.path, reslet);
                filetool.createFile(text,t.Pathdiameter,fileobje.classNameAddtext,t.suffix) // 生成文件
            }catch(e){
                console.log("模板调用失败：",e)
            }
            
        }
    })
}
/**
 * 根据项目生成模板
 * @param {String} itemid  项目配置的Id
 * @param {Function} callback err,res  
 */
function useTemplatefiles(itemid,callback){
    jsonutil.getJSONFile("/jsonConfig/itemConfig.json", function (err,JSONData) {
        if(err)callback(err,null)
        var item = null
        for (var i in JSONData) {
            if (itemid == JSONData[i].id) {
                item =  JSONData[i]
                break
            }
        }
        jsonutil.getJSONFile("/jsonConfig/templateConfig.json", function (err,templateConfig) {
            if(err)callback(err,null)
            var tlist = []
             // 获取对应的模板
            var ts = item.filetype
            ts.forEach(t=>{
                for (var i in templateConfig) {
                    if (t == templateConfig[i].id) {
                        tlist.push(templateConfig[i])
                        break
                    }
                }
            })
            queryMysql(tlist)
        })

    })
}

module.exports = {
    main_a,useTemplatefiles,outputFile,startTemplateConfig
}