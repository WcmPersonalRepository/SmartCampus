<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>导入信息</title>
</head>
<body>
<h1>导入信息</h1>
<select id="importInfo">
	<option value="4">导入组织机构信息</option>
	<option value="6">导入教师信息</option>
	<option value="5">导入部门信息</option>
	<option value="1">导入专业信息</option>
	<option value="2">导入班级信息</option>
	<option value="3">导入学生信息</option>
	<option value="7">导入通讯录信息</option>
</select>
<form id="form" action="importProfessionalInfo" method='POST' enctype="multipart/form-data">  
          <input type="file" name="file"/>
          <input type="submit" value="提交">
      </form>  <br>
      <p>${msg}</p>
</body>
<script type="text/javascript">
	var selectValue=document.getElementById("importInfo");
	selectValue.addEventListener("change", function(){
		var value=this.value;
		var form=document.getElementById("form");
		switch (value) {
		case '1':form.action='importProfessionalInfo'; break;
		case '2':form.action='importClassInfo'; break;
		case '3':form.action='importStudentInfo'; break;
		case '4':form.action='importOrganizationInfo'; break;
		case '5':form.action='importPartInfo'; break;
		case '6':form.action='importTeacherInfo'; break;
		case '7':form.action='importPhoneBookInfo'; break;

		default:
			break;
		}
	}, false);
</script>
</html>