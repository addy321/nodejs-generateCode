
module.exports = function(entityobj){

    var tool = require('../../utils/tool')
    var typeTostring = require('../../utils/TypeConversion')
     


    entityobj.fields.forEach(字段=>{
    })
            
    var 是否添加操作时间 = false
    var idobj = entityobj.idobj
    var IdType = typeTostring(idobj.字段类型,entityobj.type)

            return `
package com.jdbc.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jdbc.model.AjaxResult;
import com.jdbc.model.Page;
import com.jdbc.model.${entityobj.className}Model;
import com.jdbc.service.${entityobj.className}Service;

@Controller
@RequestMapping("/${entityobj.tableName}")
public class ${entityobj.className}Controller extends BaseApiController {

    @Resource
    private ${entityobj.className}Service ${entityobj.tableName}Service;

    @RequestMapping("/list")
    public String getlist(Page page, ${entityobj.className}Model ${entityobj.tableName}Model, Map<String, Object> map) {
        List<${entityobj.className}Model> ${entityobj.tableName}List = ${entityobj.tableName}Service.queryPage${entityobj.className}(page, ${entityobj.tableName}Model, null);
        map.put("${entityobj.tableName}List", ${entityobj.tableName}List);
        map.put("page", page);
        return "${entityobj.className}";
    }

    @GetMapping("/getTheData")
    @ResponseBody
    public AjaxResult get${entityobj.className}Model(Long id) {
        if (id == null) {
            return error();
        }
        ${entityobj.className}Model ${entityobj.tableName} = ${entityobj.tableName}Service.query${entityobj.className}ById(id);
        return success(${entityobj.tableName});
    }

    @GetMapping("/delData")
    @ResponseBody
    public AjaxResult delData(Long id) {
        if (id == null) {
            return error();
        }
        int res = ${entityobj.tableName}Service.remove${entityobj.className}ById(id);
        return res > 0 ? success() : error();
    }

    @PostMapping("/saveData")
    @ResponseBody
    public AjaxResult SaveData(@RequestBody ${entityobj.className}Model ${entityobj.tableName}) {
        if (${entityobj.tableName} == null) {
            return error();
        }
        int res = 0;
        if (${entityobj.tableName}.getId() == null || ${entityobj.tableName}.getId() == 0) {
            res = ${entityobj.tableName}Service.save(${entityobj.tableName});
        } else {
            res = ${entityobj.tableName}Service.edit(${entityobj.tableName});
        }
        return res > 0 ? success() : error();
    }
}

            `
}
