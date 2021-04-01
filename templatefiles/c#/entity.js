
module.exports = function(entityobj){

    var typeTostr = require('../../utils/TypeConversion')
    var tool = require('../../utils/tool')

    // 所有字段拼接
    var fieldtext = ''
    entityobj.fields.forEach(fieldObje => {
        fieldtext += `
        /// <summary>
        /// ${fieldObje.字段说明}
        /// </summary>
        [Column("${fieldObje.字段名}")]${fieldObje.约束.indexOf('PRI') != -1?`
        [Key]`:''}
        public ${typeTostr.typeText(fieldObje.字段类型,entityobj.type)} ${tool.toHump(fieldObje.字段名)} { get; set; }
    `
      });
      return `
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace  Coldairarrow.Entity.Entity
{
    /// <summary>
    /// ${entityobj.tablePrompt}
    /// </summary>
    [Table("${entityobj.tableName}")]
    public class ${entityobj.className}
    {
        ${fieldtext}
    }
}
`
}
