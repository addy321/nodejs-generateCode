

/*
类型转化
typeText = 数据的类型
type = 语言类型
 */
module.exports = function (typeText, type) {
    if (type == 'java') {
        if (typeText.indexOf('decimal') != -1) {
            return "Double"
        }
        if (typeText.indexOf('varchar') != -1) {
            return "String"
        }
        if (typeText.indexOf('datetime') != -1) {
            return "java.util.Date"
        }
        if (typeText.indexOf('int') != -1) {
            return "Integer"
        }
    }

    if (type == 'c#') {
        if (typeText.indexOf('decimal') != -1) {
            return "decimal"
        }
        if (typeText.indexOf('varchar') != -1) {
            return "string"
        }
        if (typeText.indexOf('bit') != -1) {
            return "int"
        }
        if (typeText.indexOf('bigint') != -1) {
            return "int"
        }
        if (typeText.indexOf('int') != -1) {
            return "int"
        }
        if (typeText.indexOf('datetime') != -1) {
            return "DateTime"
        }
    }
    return typeText
}


