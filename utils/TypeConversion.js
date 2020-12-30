

/*
类型转化
typeText = 数据的类型
type = 语言类型
 */
exports.typeTostring = function(typeText,type){
    if(type == 'java'){
        if(typeText.indexOf('decimal') != -1){
            return "double"
        }
        if(typeText.indexOf('varchar') != -1){
            return "String"
        }
        if(typeText.indexOf('datetime') != -1){
            return "Date"
        }
    }

    if(type == 'c#'){
        if(typeText.indexOf('decimal') != -1){
            return "decimal"
        }
        if(typeText.indexOf('varchar') != -1){
            return "string"
        }
        if(typeText.indexOf('bit')!=-1){
            return "bool"
        }
        if(typeText.indexOf('bigint')!=-1){
            return "int"
        }
        if(typeText.indexOf('int')!=-1){
            return "int"
        }
        if(typeText.indexOf('datetime')!=-1){
            return "DateTime"
        }
    }
    return typeText
}


