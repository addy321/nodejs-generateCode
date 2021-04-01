
/*
 接口生成的模型
entity = 数据库字段和表消息
entityobj.type = 语言类型（文件的后缀）
 */
module.exports = function(entityobj){

    var typeTostr = require('../../utils/TypeConversion')

    var entityName = entityobj.className
    // 获取主键字段和类型 
    // 转换类型
    var IdType = typeTostr.typeText(entityobj.idobj.字段类型,entityobj.type)
    
            return `
using Coldairarrow.Entity.Entity;
using Coldairarrow.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Coldairarrow.IBusiness.${entityobj.package}
{
    public interface I${entityName}Business
    {
        /// <summary>
        /// 列表(分页查询)
        /// </summary>
        /// <param name="input">分页参数</param>
        /// <returns></returns>
        Task<PageResult<${entityName}>> GetDataList(PageInput input);
        /// <summary>
        /// 获取详情
        /// </summary>
        /// <param name="${entityobj.idobj.字段名}">主键</param>
        /// <returns></returns>
        Task<${entityName}> GetTheData(${IdType} ${entityobj.idobj.字段名});

        /// <summary>
        /// 新增
        /// </summary>
        /// <param name="entity">新增数据</param>
        /// <returns></returns>
        Task InsertData(${entityName} entity);

        /// <summary>
        /// 修改实体
        /// </summary>
        /// <param name="entity">修改数据</param>
        /// <returns></returns>
        Task UpdateData(${entityName} entity);

        /// <summary>
        /// 删除
        /// </summary>
        /// <param name="ids">主键</param>
        /// <returns></returns>
        Task DeleteData(List<string> ids);
    }
}            
    `
}
    