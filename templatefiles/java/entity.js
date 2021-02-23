


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
        var fieldString = typeTostring(fieldObje.DATA_TYPE,entityobj.type)
        
        //拼接字段
            fieldtext1 += `
    //${fieldObje.COLUMN_COMMENT}
    private ${fieldString} ${tool.toHump(fieldObje.COLUMN_NAME)};
        `
        // getset 方法拼接
        fieldtext2 += `
    public ${fieldString} get${tool.toHump(tool.toHump(tool.首字母转大写(fieldObje.COLUMN_NAME)))}() {
        return ${tool.toHump(tool.首字母转大写(fieldObje.COLUMN_NAME))};
    }
    public void set${tool.toHump(tool.首字母转大写(fieldObje.COLUMN_NAME))}(${fieldString} ${tool.toHump(tool.首字母转大写(fieldObje.COLUMN_NAME))}) {
        this.${tool.toHump(tool.首字母转大写(fieldObje.COLUMN_NAME))} = ${tool.toHump(tool.首字母转大写(fieldObje.COLUMN_NAME))};
    }
            `
        // tostring 方法拼接
        fieldtext3 += `${tool.toHump(fieldObje.COLUMN_NAME)}=" + ${tool.toHump(fieldObje.COLUMN_NAME)} + ",`

        });

        fieldtext3 = tool.字符串去除最后一个字符(fieldtext3)
        fieldtext3+=`]";
    }
        `
    var fileText = `
${entityobj.packageName}
// ${entityobj.classCaption}
public class ${entityobj.className}  extends BaseDomain{
    public ${entityobj.className}() {

    }
    ${fieldtext1+fieldtext2+fieldtext3}
    
}
    `
        return  fileText

}
