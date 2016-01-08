<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>hello</title>
</head>
<body>
	<table>
		<#if configureMap?exists>
                <#list configureMap?keys as key> 
                   <tr>
                           <td>${key}</td>
                           <td>${configureMap[key]}</td>
                   </tr>
                </#list>
         </#if>
     </table>
</body>
</html>