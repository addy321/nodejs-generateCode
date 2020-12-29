
using Coldairarrow.Entity.Video;
using Coldairarrow.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Coldairarrow.IBusiness.Video
{
    public interface IVideocollectionBusiness
    {
        /// <summary>
        /// 列表(分页查询)
        /// </summary>
        /// <param name="input">分页参数</param>
        /// <param name="CompanyStyle">字段</param>
        /// <returns></returns>
        Task<List<Videocollection>> GetDataList(PageInput<Videocollection> input, string CompanyStyle);
        /// <summary>
        /// 获取详情
        /// </summary>
        /// <param name="id">主键</param>
        /// <returns></returns>
        Task<Videocollection> GetTheData(int id);

        /// <summary>
        /// 新增
        /// </summary>
        /// <param name="entity">新增数据</param>
        /// <returns></returns>
        Task InsertData(Videocollection entity);

        /// <summary>
        /// 修改实体
        /// </summary>
        /// <param name="entity">修改数据</param>
        /// <returns></returns>
        Task UpdateData(Videocollection entity);

        /// <summary>
        /// 删除
        /// </summary>
        /// <param name="ids">主键</param>
        /// <returns></returns>
        Task DeleteData(List<int> ids);
    }
}            
    