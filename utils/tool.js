
/*
获取主键的名字和主键的类型
array = 所有字段
tableName = 表名
用于mysql
 */
function getId(array, tableName) {
    for (var i in array) {
        if (array[i].约束.indexOf('PRI') != -1 && array[i].表名.indexOf(tableName) != -1) {
            return array[i]
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
    var text = name.replace(/\_(\w)/g, function(all, letter){
        return letter.toUpperCase();
    });
    return text
}


module.exports = {
    getId, 首字母转大写, 根据表名或者表下面的所有字段, 字符串去除最后一个字符,toHump
}
