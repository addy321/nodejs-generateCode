
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 系统权限表
    /// </summary>
    [Table("Base_Action")]
    public class Baseaction
    {
        
        /// <summary>
        /// 主键
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
        /// 父级Id
        /// </summary>
        [Column("ParentId")]
        public string ParentId { get; set; }
    
    
        /// <summary>
        /// 类型,菜单=0,页面=1,权限=2
        /// </summary>
        [Column("Type")]
        public int Type { get; set; }
    
    
        /// <summary>
        /// 权限名/菜单名
        /// </summary>
        [Column("Name")]
        public string Name { get; set; }
    
    
        /// <summary>
        /// 菜单地址
        /// </summary>
        [Column("Url")]
        public text Url { get; set; }
    
    
        /// <summary>
        /// 权限值
        /// </summary>
        [Column("Value")]
        public string Value { get; set; }
    
    
        /// <summary>
        /// 是否需要权限(仅页面有效)
        /// </summary>
        [Column("NeedAction")]
        public int NeedAction { get; set; }
    
    
        /// <summary>
        /// 图标
        /// </summary>
        [Column("Icon")]
        public string Icon { get; set; }
    
    
        /// <summary>
        /// 排序
        /// </summary>
        [Column("Sort")]
        public int Sort { get; set; }
    
    
    }
}
