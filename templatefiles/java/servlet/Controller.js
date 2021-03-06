
module.exports = function(entityobj){

    var tool = require('../../../utils/tool')
    var typeTostring = require('../../../utils/TypeConversion')

    entityobj.fields.forEach(字段=>{
    })
            
    var idobj = entityobj.PRI
    var IdType = typeTostring(idobj.DATA_TYPE,entityobj.type)

            return `
${entityobj.packageName}

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.${entityobj.BigclassName};
import dao.${entityobj.BigclassName}Dao;

@WebServlet("/${entityobj.className}/*")
public class ${entityobj.BigclassName}Controller extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private final ${entityobj.BigclassName}Dao ${entityobj.className}Dao = new ${entityobj.BigclassName}Dao();

	public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<${entityobj.BigclassName}> ${entityobj.className} = ${entityobj.className}Dao.query(null, null);
			List<${entityobj.BigclassName}> ${entityobj.className}2 = ${entityobj.className}Dao.query(null, null);
			writeValue(new ResultUtil().getSuccessResult(${entityobj.className}),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
            `
}
