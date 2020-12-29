
exports.model = function(entity,suffix){
    var util = require('../utils/TypeConversion')
    var tool = require('../utils/tool')

    // 拿到所有字段
    var fields = entity.fields
 
    // 首字母转大写 把表名转成实体类
    var entityName = tool.首字母转大写(entity.name)

    if (suffix == '.cs') {
        
        // 所有字段拼接
        var fieldtext = ''
        fields.forEach(fieldObje => {
            fieldtext += `
        /// <summary>
        /// ${fieldObje.字段说明}
        /// </summary>
        public ${util.typeTostring(fieldObje.字段类型,suffix)} ${fieldObje.字段名} { get; set; }
    
    `
        });
        return `
using Coldairarrow.Util;
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.${entityName}
{
    /// <summary>
    /// ${entity.tablePrompt}
    /// </summary>
    [Table("${entity.tableName}")]
    public class ${entityName}
    {
        ${fieldtext}
    }
}
`
    }

    if (suffix == '.java') {

        // 所有字段拼接
        var fieldtext1 = ''
        var fieldtext2 = ''
        var fieldtext3 = ''
        fieldtext3 += ` 
    @Override
    public String toString() {
        return "${entity.name}[` 

        fields.forEach(fieldObje => {
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

}
