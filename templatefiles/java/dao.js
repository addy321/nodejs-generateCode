
module.exports = function(entityobj){

    var tool = require('../../utils/tool')
    var typeTostring = require('../../utils/TypeConversion')
    
    var entityName = entityobj.className 

    var 映射字段字符拼接 = ''
    var 字段字符拼接 = ''
    var 问号 = ''
    var 修改字符 = ''

    var set字符拼接 =''

    entityobj.fields.forEach(字段=>{
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
    var idobj = entityobj.idobj
    var IdType = typeTostring(idobj.字段类型,entityobj.type)

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
        String sql="insert into ${entityobj.tableName}(${字段字符拼接}) values(${问号})";
        List<Object> values=new ArrayList<Object>(${entityobj.fields.length});
        ${映射字段字符拼接}
        
        return super.executeInsert(sql, values);
    }

    @Override
    public int delete(${IdType} ${idobj.字段名}) throws Exception {
        String sql="delete from ${entityobj.tableName} where ${idobj.字段名}=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(${idobj.字段名});
        return executeUpdate(sql, values);
    }

    @Override
    public int update(${entityName} data) throws Exception {
        StringBuffer sql=new StringBuffer("update ${entityobj.tableName} set ");
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
        String sql="select ${字段字符拼接} from ${entityobj.tableName}";
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
        String sql="select count(1) from ${entityobj.tableName}";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }

}
            
            `
}
