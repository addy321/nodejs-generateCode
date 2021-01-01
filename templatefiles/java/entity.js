


module.exports = function(entityobj){

    var typeTostring = require('../../utils/TypeConversion')
    var tool = require('../../utils/tool')
    
    // 所有字段拼接
    var fieldtext1 = ''
    var fieldtext2 = ''
    var fieldtext3 = ''
        fieldtext3 += ` 
    @Override
    public String toString() {
        return "${entityobj.className}[` 

        entityobj.fields.forEach(fieldObje => {
        // 获取类型
        var fieldString = typeTostring(fieldObje.字段类型,entityobj.type)
        
        //拼接字段
            fieldtext1 += `
    //${fieldObje.字段说明}
    private ${fieldString} ${tool.toHump(fieldObje.字段名)};
        `
        // getset 方法拼接
        fieldtext2 += `
    public ${fieldString} get${tool.toHump(tool.toHump(tool.首字母转大写(fieldObje.字段名)))}() {
        return ${tool.toHump(tool.首字母转大写(fieldObje.字段名))};
    }
    public void set${tool.toHump(tool.首字母转大写(fieldObje.字段名))}(${fieldString} ${tool.toHump(tool.首字母转大写(fieldObje.字段名))}) {
        this.${tool.toHump(tool.首字母转大写(fieldObje.字段名))} = ${tool.toHump(tool.首字母转大写(fieldObje.字段名))};
    }
            `
        // tostring 方法拼接
        fieldtext3 += `${tool.toHump(fieldObje.字段名)}=" + ${tool.toHump(fieldObje.字段名)} + ",`

        });

        fieldtext3 = tool.字符串去除最后一个字符(fieldtext3)
        fieldtext3+=`]";
    }
        `

        return `
package entity;
// ${entityobj.tablePrompt}
public class ${entityobj.className}  extends BaseDomain{
    public ${entityobj.className}() {

    }
    ${fieldtext1+fieldtext2+fieldtext3}
    
}
        `

}
