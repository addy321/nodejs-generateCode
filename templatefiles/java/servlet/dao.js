
module.exports = function(entityobj){
    var itempath = process.cwd()
    var tool = require(itempath+'/utils/tool')
    var typeTostring = require(itempath+'/utils/TypeConversion')
    

    var 映射字段字符拼接 = ''
    var 字段字符拼接 = ''
    var 问号 = ''
    var 修改字符 = ''

    var set字符拼接 =''

    entityobj.fields.forEach(字段=>{
                var 大写开头字段 = tool.首字母转大写(字段.COLUMN_NAME)
                字段字符拼接+=字段.COLUMN_NAME+','
                映射字段字符拼接+=`
        values.add(data.get${大写开头字段}());`
                问号 +='?,'
                if(字段.COLUMN_KEY != "PRI")修改字符 +=`
        if(data.get${大写开头字段}()!=null){
            sql.append("${字段.COLUMN_NAME}=?,");
            values.add(data.get${大写开头字段}());
        }
                `
                var action = `rs.getString("${字段.COLUMN_NAME}")`
                if(字段.DATA_TYPE.indexOf("int")  != -1){
                    action = `rs.getInt("${字段.COLUMN_NAME}")`
                }
                if(字段.DATA_TYPE.indexOf("date")  != -1){
                    action = `rs.getDate("${字段.COLUMN_NAME}")`
                }
                if(字段.DATA_TYPE.indexOf("decimal")  != -1){
                    action = `rs.getDouble("${字段.COLUMN_NAME}")`
                }
                set字符拼接 +=`
            data.set${tool.首字母转大写(字段.COLUMN_NAME)}(${action});`
            })
            字段字符拼接 = tool.字符串去除最后一个字符(字段字符拼接)
            问号 = tool.字符串去除最后一个字符(问号)
    
            
    var 是否添加操作时间 = false
    var idobj = entityobj.PRI
    var IdType = typeTostring(idobj.DATA_TYPE,entityobj.type)

            return `
${entityobj.packageName}

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.${entityobj.BigclassName};
import entity.Page;

public class ${entityobj.BigclassName}Dao extends daoTemplate{

    /*
    * 添加
   */ 
    public int save(${entityobj.BigclassName} data) throws Exception {
        String sql="insert into ${entityobj.className}(${字段字符拼接}) values(${问号})";
        List<Object> values=new ArrayList<Object>(${entityobj.fields.length});
        ${映射字段字符拼接}
        
        return super.executeInsert(sql, values);
    }

    /*
    * 删除
   */ 
    public int delete(${IdType} ${idobj.COLUMN_NAME}) throws Exception {
        String sql="delete from ${entityobj.className} where ${idobj.COLUMN_NAME}=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(${idobj.COLUMN_NAME});
        return executeUpdate(sql, values);
    }

    /*
    * 修改
   */ 
    public int update(${entityobj.BigclassName} data) throws Exception {
        StringBuffer sql=new StringBuffer("update ${entityobj.className} set ");
        List<Object> values=new ArrayList<Object>();
        ${修改字符}
        ${是否添加操作时间?`
        sql.append("操作时间=?");
        values.add(new Date());`:''}
        
        sql.append(" where ${idobj.COLUMN_NAME}=?");
        values.add(data.get${tool.首字母转大写(idobj.COLUMN_NAME)}());
        
        return executeUpdate(sql.toString(), values);
    }

    /*
    * 分页查询
   */ 
    public List<${entityobj.BigclassName}> query(String condition, List<Object> values, Page page) throws Exception {
        String sql="select ${字段字符拼接} from ${entityobj.className}";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        if(values == null) {
        	values=new ArrayList<Object>(2);
        }
        sql=sql+" limit ?,?";
        values.add(page.getPageOffset());
        values.add(page.getPageSize());

        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<${entityobj.BigclassName}> datas=new ArrayList<${entityobj.BigclassName}>();
        while(rs.next()){
            ${entityobj.BigclassName} data=new ${entityobj.BigclassName}();
            ${set字符拼接}	
            datas.add(data);
        }
        return datas;
        }catch(Exception e){throw e;}
        finally{
            super.close(null, pre, rs);
        }
    }
    
    /*
    * 数据量大时请不要使用（查询全部数据）
   */ 
    public List<${entityobj.BigclassName}> query(String condition, List<Object> values) throws Exception {
        String sql="select ${字段字符拼接} from ${entityobj.className}";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }

        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<${entityobj.BigclassName}> datas=new ArrayList<${entityobj.BigclassName}>();
        while(rs.next()){
            ${entityobj.BigclassName} data=new ${entityobj.BigclassName}();
            ${set字符拼接}	
            datas.add(data);
        }
        return datas;
        }catch(Exception e){throw e;}
        finally{
            super.close(null, pre, rs);
        }
    }

    /*
    * 根据主键查询
   */ 
    public ${entityobj.BigclassName} queryData(${IdType} ${idobj.COLUMN_NAME}) throws Exception {
    	if(id == null) {
    		return null;
    	}
    	String sql="select * from ${entityobj.className} where ${idobj.COLUMN_NAME} = ?";
    	ResultSet rs=null;
    	ArrayList<Object> values=new ArrayList<Object>(1);
    	values.add(id);
        ${entityobj.BigclassName} data= null;
        try{
        rs=executeQuery(sql, values);
        rs.next();
       
        if(rs.next()) {
        	data = new ${entityobj.BigclassName}();
            ${set字符拼接}
        	
        }
        }catch(Exception e){throw e;}
        finally{
            super.close(conn, pre, rs);
        }
        return data;
	}

    /*
    * 查询数量总数
   */ 
    public long count(String condition, List<Object> values) throws Exception {
        String sql="select count(1) from ${entityobj.className}";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }
}
            `
}
