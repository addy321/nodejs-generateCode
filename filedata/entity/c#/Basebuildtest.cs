
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 生成测试表
    /// </summary>
    [Table("Base_BuildTest")]
    public class Basebuildtest
    {
        
        /// <summary>
        /// 自然主键
        /// </summary>
        [Column("Id")]
        public string Id { get; set; }
    
    
        /// <summary>
        /// 创建时间
        /// </summary>
        [Column("CreateTime")]
        public DateTime CreateTime { get; set; }
    
    
        /// <summary>
        /// 创建人Id
        /// </summary>
        [Column("CreatorId")]
        public string CreatorId { get; set; }
    
    
        /// <summary>
        /// 否已删除
        /// </summary>
        [Column("Deleted")]
        public int Deleted { get; set; }
    
    
        /// <summary>
        /// 列1
        /// </summary>
        [Column("Column1")]
        public string Column1 { get; set; }
    
    
        /// <summary>
        /// 列2
        /// </summary>
        [Column("Column2")]
        public string Column2 { get; set; }
    
    
        /// <summary>
        /// 列3
        /// </summary>
        [Column("Column3")]
        public string Column3 { get; set; }
    
    
        /// <summary>
        /// 列4
        /// </summary>
        [Column("Column4")]
        public string Column4 { get; set; }
    
    
        /// <summary>
        /// 列5
        /// </summary>
        [Column("Column5")]
        public string Column5 { get; set; }
    
    
    }
}
