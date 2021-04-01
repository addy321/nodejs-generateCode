
var typeTostr = require('../utils/TypeConversion')

/**
 * 获取主键的名字和主键的类型
 * @param {[]} array 所有字段
 * @param {String} type 语言类型
 * @returns {} 主键对象
 */
function getPRI(array,type) {
    for (var i in array) {
        if (array[i].FieldPK.indexOf('PRI') != -1 || array[i].FieldPK.indexOf('true') != -1) {
            var pri = array[i]
            pri.dataType = typeTostr.typeText(pri.FieldType,type)
            return pri
        }
    }
}

/*
首字母转大写
str = 字符串
 */
function 首字母转大写(str) {
    newStr = str.slice(0, 1).toUpperCase() + str.slice(1);
    return newStr;
}
/*
 区分表的字段
 database = 数组 从数据库中查出来的表和字段信息
*/
function 根据表名或者表下面的所有字段(database, 表名) {
    var array = []
    database.forEach(model => {
        if (model.表名 == 表名) {
            array.push(model)
        }
    })
    return array;
}
/*
 区分表的字段
 database = 数组 从数据库中查出来的表和字段信息
*/
function 字符串去除最后一个字符(text) {
    return text.substring(0, text.length - 1);
}

// 下划线转换驼峰
function toHump(name) {
    var text = name
    if(text.indexOf('_') != -1){
        text = name.replace(/\_(\w)/g, function(all, letter){
            return letter.toUpperCase();
        });
    }
    return text
}


module.exports = {
    getPRI, 首字母转大写, 根据表名或者表下面的所有字段, 字符串去除最后一个字符,toHump
}
