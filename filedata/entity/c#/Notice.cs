
using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace Coldairarrow.Entity.Video
{
    /// <summary>
    /// 
    /// </summary>
    [Table("notice")]
    public class Notice
    {
        
        /// <summary>
        /// 公告ID
        /// </summary>
        [Column("Id")]
        public int Id { get; set; }
    
    
        /// <summary>
        /// 公司后缀
        /// </summary>
        [Column("CompanyStyle")]
        public string CompanyStyle { get; set; }
    
    
        /// <summary>
        /// 公告类型
        /// </summary>
        [Column("NoticeType")]
        public int NoticeType { get; set; }
    
    
        /// <summary>
        /// 公告内容
        /// </summary>
        [Column("NoticeTypeDetail")]
        public string NoticeTypeDetail { get; set; }
    
    
        /// <summary>
        /// 公告跳转地址
        /// </summary>
        [Column("NoticeJumpUrl")]
        public string NoticeJumpUrl { get; set; }
    
    
        /// <summary>
        /// 状态 0=停用 1=启用
        /// </summary>
        [Column("Status")]
        public int Status { get; set; }
    
    
        /// <summary>
        /// 排序
        /// </summary>
        [Column("Orders")]
        public int Orders { get; set; }
    
    
    }
}
