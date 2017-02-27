<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>login</h1>
<form name='f' action="j_spring_security_check" method='POST'>  
          <table>  
             <tr>  
                <td>User:</td>  
                <td><input type='text' name='j_username' value=''></td>  
             </tr>  
             <tr>  
                <td>Password:</td>  
                <td><input type='password' name='j_password' /></td>  
             </tr>  
             <tr>  
                <td><input name="submit" type="submit" value="submit" /></td>  
             </tr>  
          </table>  
      </form>  
      <h1>${msg }</h1>
</body>
</html>