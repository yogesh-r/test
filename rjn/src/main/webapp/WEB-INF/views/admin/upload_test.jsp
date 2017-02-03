<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>

	<form method="POST" action="${rc.getContextPath()}/admin/uploadFile" enctype="multipart/form-data">
		File to upload: <input type="file" name="file"><br /> 
		Name: <input type="text" name="name"><br /> <br /> 
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>
	
	
	<img src="${rc.getContextPath()}/tmpfiles/yogesh.png">
	
	<img src="<c:url value="/tmpfiles/yogesh.png" />">
	
	
</body>
</html>