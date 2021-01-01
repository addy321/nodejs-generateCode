
module.exports = function(entityobj){

    var typeTostring = require('../../utils/TypeConversion')
    var IdType = typeTostring(entityobj.idobj.字段类型,entityobj.type)
      return `
using Coldairarrow.Entity.Base_Manage;
using Coldairarrow.Entity.Entity;
using Coldairarrow.IBusiness.${entityobj.package};
using Coldairarrow.Util;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using NSwag.Annotations;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Coldairarrow.Api.Controllers.${entityobj.package}
{
    [Route("/${entityobj.package}/[controller]/[action]")]
    [OpenApiTag("${entityobj.className}")]
    [AllowAnonymous]
    public class ${entityobj.className}Controller : BaseApiController
    {
        I${entityobj.className}Business _dbbusiness;
        public ${entityobj.className}Controller(I${entityobj.className}Business dbbusiness)
        {
            _dbbusiness = dbbusiness;
        }
        [HttpPost]
        public async Task<AjaxResult<List<${entityobj.className}>>> GetDataList(PageInput input)
        {
            return await _dbbusiness.GetDataList(input);
        }

        [HttpPost]
        public async Task<${entityobj.className}> GetTheData(IdInputDTO input)
        {
            return await _dbbusiness.GetTheData(${IdType == 'int'?`int.Parse(input.id)`: 'input.id'}) ?? new ${entityobj.className}();
        }

        /// <summary>
        /// 保存
        /// </summary>
        /// <param name="theData">保存的数据</param>
        [HttpPost]
        public async Task SaveData(${entityobj.className} theData)
        {
            ${IdType !='int'?`if (theData.${entityobj.idobj.字段名}.IsNullOrEmpty())`:`if (theData.${entityobj.idobj.字段名} < 1)`}
            {
                InitEntity(theData);

                await _dbbusiness.InsertData(theData);
            }
            else
            {
                await _dbbusiness.UpdateData(theData);
            }
        }

        /// <summary>
        /// 删除数据
        /// </summary>
        /// <param name="ids">id数组,JSON数组</param>
        [HttpPost]
        public async Task DeleteData(List<string> ids)
        {
            await _dbbusiness.DeleteData(ids);
        }
    }
}
      
`
}
