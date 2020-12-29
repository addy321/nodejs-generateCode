
/*
 接口生成的模型
entity = 数据库字段和表消息
suffix = 语言类型（文件的后缀）
 */
exports.model = function (entityName,entity, suffix) {

    var typeTostring = require('../utils/TypeConversion')
    var tool = require('../utils/tool')

     // 拿到所有字段
     var fields = entity.fields
    // 获取主键字段和类型
    var idobj = tool.getId(fields,entity.name)
    // 转换类型
    var IdType = typeTostring.typeTostring(idobj.字段类型,suffix)
    
        if (suffix == '.cs') {
            
            return `
using Coldairarrow.Entity.Video;
using Coldairarrow.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Coldairarrow.IBusiness.Video
{
    public interface I${entityName}Business
    {
        /// <summary>
        /// 列表(分页查询)
        /// </summary>
        /// <param name="input">分页参数</param>
        /// <param name="CompanyStyle">字段</param>
        /// <returns></returns>
        Task<List<${entityName}>> GetDataList(PageInput<${entityName}> input, string CompanyStyle);
        /// <summary>
        /// 获取详情
        /// </summary>
        /// <param name="${idobj.字段名}">主键</param>
        /// <returns></returns>
        Task<${entityName}> GetTheData(${IdType} ${idobj.字段名});

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
        Task DeleteData(List<${IdType}> ids);
    }
}            
    `
        }
       
        if (suffix == '.java') {
            var 表中的字段 = tool.根据表名或者表下面的所有字段(fields,entity.name)

            var 映射字段字符拼接 = ''
            var 字段字符拼接 = ''
            var 问号 = ''
            var 修改字符 = ''

            var set字符拼接 =''

            表中的字段.forEach(字段=>{
                var 大写开头字段 = tool.首字母转大写(字段.字段名)
                字段字符拼接+=字段.字段名+','
                映射字段字符拼接+=`
        values.add(object.get${大写开头字段}());`
                问号 +='?,'
                修改字符 += `
        if(data.get${大写开头字段}()!=null && !"".equals(data.getName())){
            sql.append("${字段.字段名}=?,");
            values.add(data.get${大写开头字段}());
        }
                `
                set字符拼接 +=`
            data.set${字段.字段名}(rs.get${大写开头字段}("${字段.字段名}"));`
            })
            字段字符拼接 = tool.字符串去除最后一个字符(字段字符拼接)
            问号 = tool.字符串去除最后一个字符(问号)
    
            
            var 是否添加操作时间 = false

            return `
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojo.${entityName};

public class ${entityName}Dao extends daoTemplate implements pojoDao<${entityName}>{
    
    public ${entityName}Dao(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }


    @Override
    public int save(${entityName} data) throws Exception {
        String sql="insert into ${entity.name}(${字段字符拼接}) values(${问号})";
        List<Object> values=new ArrayList<Object>(${表中的字段.length});
        ${映射字段字符拼接}
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(${IdType} ${idobj.字段名}) throws Exception {
        String sql="delete from ${entity.name} where ${idobj.字段名}=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(${idobj.字段名});
        return executeUpdate(sql, values);
    }

    @Override
    public int update(${entityName} data) throws Exception {
        StringBuffer sql=new StringBuffer("update ${entity.name} set ");
        List<Object> values=new ArrayList<Object>();
        ${修改字符}
        ${是否添加操作时间?`
        sql.append("操作时间=?");
        values.add(new Date());`:''}
        
        sql.append(" where ${idobj.字段名}=?");
        values.add(stu.get${tool.首字母转大写(idobj.字段名)}());
        
        return executeUpdate(sql.toString(), values);
    }

    @Override
    public List<${entityName}> query(String condition, List<Object> values, Integer page, Integer pageSize) throws Exception {
        String sql="select ${字段字符拼接} from ${entity.name}";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        if(page==null||page<0)
            page=0;
        if(pageSize!=null&&pageSize!=0){
            if(values==null)
                values=new ArrayList<Object>(2);
            sql=sql+" limit ?,?";
            values.add(page);
            values.add(pageSize);
        }
        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<${entityName}> datas=new ArrayList<${entityName}>();
        while(rs.next()){
            ${entityName} data=new ${entityName}();
            ${set字符拼接}	
            datas.add(data);
        }
        return datas;
        }catch(Exception e){throw e;}
        finally{
            super.close(null, pre, rs);
        }
        
    }

    @Override
    public long count(String condition, List<Object> values) throws Exception {
        String sql="select count(1) from ${entity.name}";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            `
        }
    
    }
    