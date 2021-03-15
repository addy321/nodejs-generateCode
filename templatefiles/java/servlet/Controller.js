function c(entityobj){

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
import entity.ResultModel;
import dao.${entityobj.BigclassName}Dao;

@WebServlet("/${entityobj.className}/*")
public class ${entityobj.BigclassName}Controller extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private final ${entityobj.BigclassName}Dao ${entityobj.className}Dao = new ${entityobj.BigclassName}Dao();

	public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<${entityobj.BigclassName}> ${entityobj.className}s = ${entityobj.className}Dao.queryAll(null, null);
			writeValue(new ResultUtil().getSuccessResult(${entityobj.className}s),response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String ${idobj.COLUMN_NAME} = (String) request.getAttribute("${idobj.COLUMN_NAME}");
			${entityobj.BigclassName} ${entityobj.className} = ${entityobj.className}Dao.queryData(${idobj.COLUMN_NAME});
			writeValue(new ResultUtil().getSuccessResult(${entityobj.className}), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addData(HttpServletRequest request, HttpServletResponse response) {
		try {
			${entityobj.BigclassName} ${entityobj.className} = new ${entityobj.BigclassName}();
			${entityobj.className} = getKevs(request, response, ${entityobj.BigclassName}.class);
			int res = ${entityobj.className}Dao.save(${entityobj.className});
			
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void UpData(HttpServletRequest request, HttpServletResponse response) {
		try {
			${entityobj.BigclassName} ${entityobj.className} = new ${entityobj.BigclassName}();
			${entityobj.className} = getKevs(request, response, ${entityobj.BigclassName}.class);
			int res = ${entityobj.className}Dao.update(${entityobj.className});
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DelData(HttpServletRequest request, HttpServletResponse response) {
		try {
			String ${idobj.COLUMN_NAME} = (String) request.getAttribute("${idobj.COLUMN_NAME}");
			int res = ${entityobj.className}Dao.delete(${idobj.COLUMN_NAME});
			ResultUtil rUtil = new ResultUtil();
			ResultModel resultModel = res> 0 ?rUtil.getSuccessResult():rUtil.getFailResult();
			writeValue(resultModel, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
            `
}
module.exports = c()