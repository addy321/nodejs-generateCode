
exports.exports = function(entityobj){
    var util = require('../utils/TypeConversion')
    var tool = require('../utils/tool')
    
    var entityName = entityobj.className
    // 所有字段拼接
    var fieldtext1 = ''
    var fieldtext2 = ''
    var fieldtext3 = ''
    
    fieldtext3 += ` 
    @Override
    public String toString() {
        return "${entityName}[` 

        entityobj.fields.forEach(fieldObje => {
        // 获取类型
        var fieldString = util.typeTostring(fieldObje.字段类型,suffix)
        
        //拼接字段
            fieldtext1 += `
    //${entity.tablePrompt}
    private ${fieldString} ${fieldObje.字段名};
        `
        // getset 方法拼接
        fieldtext2 += `
    public ${fieldString} get${tool.首字母转大写(fieldObje.字段名)}() {
        return ${tool.首字母转大写(fieldObje.字段名)};
    }
    public void set${tool.首字母转大写(fieldObje.字段名)}(${fieldString} ${tool.首字母转大写(fieldObje.字段名)}) {
        this.${tool.首字母转大写(fieldObje.字段名)} = ${tool.首字母转大写(fieldObje.字段名)};
    }
            `
        // tostring 方法拼接
        fieldtext3 += `${fieldObje.字段名}=" + ${fieldObje.字段名} + ",`

        });

        fieldtext3 = tool.字符串去除最后一个字符(fieldtext3)
        fieldtext3+=`]";
    }
        `

        return `
package entity;
// ${entity.tablePrompt}
public class ${entityName}  extends BaseDomain{
    public ${entityName}() {

    }
    ${fieldtext1+fieldtext2+fieldtext3}
    
}
        `
}
