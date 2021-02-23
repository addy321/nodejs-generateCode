


module.exports = function(entityobj){

var typeTostring = require('../../utils/TypeConversion')
var tool = require('../../utils/tool')

var f = '$'

// 所有字段拼接
var thtext = ''
var tdtext = ''
var forminputtext = ''
var editdata = ''
var savetext = ''
var savedata = 'var data ={'


entityobj.fields.forEach(fieldObje => {
    thtext+=`<th>${fieldObje.字段说明}</th>`
    tdtext+=`<td th:text="${f}{${entityobj.tableName}.${tool.toHump(fieldObje.字段名)}}"></td>`
    var p = ''
    if(fieldObje.约束 == 'PRI'){
        p = 'disabled'
    }
    forminputtext+=`
    <div class="form-group">
        <label class="col-sm-2 control-label">${fieldObje.字段说明}</label>
        <div class="col-sm-10">
            <input class="form-control" id="input${fieldObje.字段名}" type="text" placeholder="${fieldObje.字段说明}" name="${fieldObje.字段名}"
                value="" ${p}>
        </div>
    </div>
    `
    editdata += `
            ${f}("#input${fieldObje.字段名}").val(data.${tool.toHump(fieldObje.字段名)})`
    savetext += `
            var ${fieldObje.字段名} =  $("#input${fieldObje.字段名}").val();`
    savedata += `${tool.toHump(fieldObje.字段名)}:${fieldObje.字段名},`
})
savedata = tool.字符串去除最后一个字符(savedata)
savedata+='}'
return `

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>管理后台</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">
</head>
<body>
	<!-- 头部 -->
	<div th:replace="./public/head :: public_head"></div>

	<div class="container-fluid">
		<div class="row">
			<!-- 菜单栏 -->
			<div th:replace="./public/MenuBar :: public_menuBar"></div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="sub-header">
					<a href="javascript:void(0);" class="addData">添加用户</a>
				</h2>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								${thtext}
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<tr th:each="${entityobj.tableName},${entityobj.tableName}Stat:${f}{${entityobj.tableName}List}">
                                ${tdtext}
								<td>
									<a href="javascript:void(0);" class="tdFeatures editdata" th:attr="tdid=${f}{${entityobj.tableName}.id}"><span
										class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
									&ensp;&ensp; <a href="javascript:void(0);" class="tdFeatures deldata" th:attr="tdid=${f}{${entityobj.tableName}.id}"><span
										class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 分页 -->
				<div class="bs-example" data-example-id="disabled-active-pagination"
					style="text-align: center;">
					<nav aria-label="...">
						<ul class="pagination">
							<li th:class="${f}{page.pageNow <= 1}? 'disabled' : ''"><a th:href="'/${entityobj.tableName}/list?pageNow='+${f}{page.pageNow - 1}" aria-label="Previous"><span
									aria-hidden="true">«</span></a></li>
							
							<li th:each="i,stat:${f}{#numbers.sequence(1, page.pageCount)}" th:class="${f}{page.pageNow == i}? 'active' : ''">
								<a th:if="${f}{i>0}" th:href="'/${entityobj.tableName}/list?pageNow='+${f}{i}" th:text="${f}{i}"></a>
							</li>
							<li><a th:href="'/${entityobj.tableName}/list?pageNow='+${f}{page.pageNow + 1}" aria-label="Next" th:class="${f}{page.pageNow >= page.pageCount}? 'disabled' : ''"><span
									aria-hidden="true">»</span></a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<div class="editfrom">
		<h2>编辑表单</h2>
		<form class="form-horizontal" role="form"> 
            ${forminputtext}
            <div class="form-group">
				
			<div class="form-button-div">
				<a class="btn btn-primary saveData" href="#" role="button" >保存</a>
				&ensp;&ensp;
				<a class="btn btn-primary button-clone" href="#" role="button">关闭</a>
			</div>
			</div>
		</form>
	</div>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="../js/holder.min.js"></script>
	<script src="../js/index.js"></script>
	<script>
	$(".editdata").click(function(){
		var id = $(this).attr('tdid')
		$.ajax({
            url: "/${entityobj.tableName}/getTheData?id="+id,
            type: "get",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function (r) {
                if (r.success) {
                	var data = r.data
                	${editdata}
                } else {
                    alert(r.Msg);
                }
            }
        });
	})
	$(".deldata").click(function(){
		if (confirm('确定要删除吗')) {
            var id = $(this).attr('tdid')
			$.ajax({
	            url: "/${entityobj.tableName}/delData?id="+id,
	            type: "get",
	            dataType: "json",
	            contentType: "application/json;charset=utf-8",
	            success: function (r) {
	                if (r.success) {
	                	location.reload();
	                } else {
	                    alert(r.Msg);
	                }
	            }
	        });
		}
	})
	$(".saveData").click(function(){
		if (confirm('确定保存吗')) {
			${savetext}
			${savedata}
			$.ajax({
	            url: "/${entityobj.tableName}/saveData",
	            type: "post",
	            dataType: "json",
	            data:JSON.stringify(data),
	            contentType: "application/json;charset=utf-8",
	            success: function (r) {
	                if (r.success) {
	                	location.reload();
	                } else {
	                    alert(r.Msg);
	                }
	            },error:function(e){
                    alert("请求失败")
                }
	        });
		}
	})
	</script>
</body>
</html>
`

}
