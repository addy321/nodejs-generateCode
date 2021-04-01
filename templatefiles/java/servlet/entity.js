var e = function(entityobj){
    var itempath = process.cwd()
    var typeTostr = require(itempath+'/utils/TypeConversion')
    var tool = require(itempath+'/utils/tool')
    
    // 所有字段拼接
    var fieldtext1 = ''
    var fieldtext2 = ''
    var fieldtext3 = ''
        fieldtext3 += ` 
    @Override
    public String toString() {
        return "${entityobj.BigclassName}[` 

        entityobj.fields.forEach(fieldObje => {
        // 获取类型
        var fieldString = typeTostr.typeText(fieldObje.FieldType,entityobj.type)
        
        //拼接字段
            fieldtext1 += `
    //${fieldObje.FieldSM}
    private ${fieldString} ${tool.toHump(fieldObje.Fieldname)};
        `
        // getset 方法拼接
        fieldtext2 += `
    public ${fieldString} get${tool.toHump(tool.toHump(tool.首字母转大写(fieldObje.Fieldname)))}() {
        return ${tool.toHump(fieldObje.Fieldname)};
    }
    public void set${tool.toHump(tool.首字母转大写(fieldObje.Fieldname))}(${fieldString} ${tool.toHump(tool.首字母转大写(fieldObje.Fieldname))}) {
        this.${tool.toHump(fieldObje.Fieldname)} = ${tool.toHump(tool.首字母转大写(fieldObje.Fieldname))};
    }
            `
        // tostring 方法拼接
        fieldtext3 += `${tool.toHump(fieldObje.Fieldname)}=" + ${tool.toHump(fieldObje.Fieldname)} + ",`

        });

        fieldtext3 = tool.字符串去除最后一个字符(fieldtext3)
        fieldtext3+=`]";
    }
        `
    var fileText = `
${entityobj.packageName}
// ${entityobj.classCaption}
public class ${entityobj.BigclassName}{
    public ${entityobj.BigclassName}() {

    }
    ${fieldtext1+fieldtext2+fieldtext3}
    
}
    `
        return  fileText

}

module.exports = e;