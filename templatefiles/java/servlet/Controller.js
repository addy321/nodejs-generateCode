
module.exports = function(entityobj){

    var tool = require('../../../utils/tool')
    var typeTostring = require('../../../utils/TypeConversion')
     


    entityobj.fields.forEach(字段=>{
    })
            
    var idobj = entityobj.PRI
    var IdType = typeTostring(idobj.DATA_TYPE,entityobj.type)

            return `
${entityobj.packageName}

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoTemplate;
import entity.${entityobj.BigclassName};
import dao.${entityobj.BigclassName}Dao;

@WebServlet(name = "${entityobj.className}", urlPatterns = { "/${entityobj.className}/*", })
public class ${entityobj.BigclassName}Controller extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private final ${entityobj.BigclassName} ${entityobj.className}Dao = new ${entityobj.BigclassName}();

	public void queryDataList(HttpServletRequest request, HttpServletResponse response) {
		
		String userName = (String) request.getSession().getAttribute("loginName");

		if (userName == null) {
			request.setAttribute("error", "登录超时");
			redirecturl("/Jdbcproject/user/showLogin", response);
			return;
		}
		UMessage data = new UMessage();
		data.setProductName(productName);
		data.setUserName(userName);
		request.setAttribute("data", data);
		showView("/addMesssage.jsp", request, response);
	}
}
            `
}
