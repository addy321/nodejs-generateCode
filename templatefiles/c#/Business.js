
module.exports = function(entityobj){

    var typeTostr = require('../../utils/TypeConversion')
    var tool = require('../../utils/tool') 
    var IdType = typeTostr.netType(entityobj.idobj.字段类型)
      return `
using Coldairarrow.Business;
using Coldairarrow.Entity.Entity;
using Coldairarrow.Util;
using EFCore.Sharding;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Coldairarrow.IBusiness.${entityobj.package}
{
    public class ${entityobj.className}Business : BaseBusiness<${entityobj.className}>, I${entityobj.className}Business, ITransientDependency
    {
        public ${entityobj.className}Business(IDbAccessor db) : base(db)
        {

        }
        public async Task DeleteData(List<string> ids)
        {
            await DeleteAsync(ids);
        }

        public async Task<PageResult<${entityobj.className}>> GetDataList(PageInput input)
        {
            return await GetIQueryable().GetPageResultAsync(input);
        }

        public async Task<${entityobj.className}> GetTheData(${IdType} Primarykey)
        {
            return await GetEntityAsync(Primarykey);
        }

        public async Task InsertData(${entityobj.className} entity)
        {
            await InsertAsync(entity);
        }

        public async Task UpdateData(${entityobj.className} entity)
        {
            await UpdateAsync(entity);
        }
    }
}            
    
`
}
