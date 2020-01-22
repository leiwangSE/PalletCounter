<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Parts list</title>
</head>
<body>
    <br>
    <br>
    <br>
    <center>
        <h1>Result Exhibition</h1>
      
    </center>
    
    <br>
    <br>
    
    <div align="center">
        <table border="1" cellpadding="5">
         
          <tr>
           
            <th width ="20%">Part ID </th>
            <th width ="20%">The Number of Container</th>
            <th width ="20%">Container Per Pallet</th>
            <th width ="35"> Pallet </th>
            <th width ="35"> Leftover </th>
            <th width ="35">Mix(Yes/No) </th>
            
           </tr>
            
            
            <c:forEach items="${listParts}" var="part" >
                <tr>
                <!-- Oject and variable -->
                    <td><c:out value="${part.part_id}" /></td> 
                    <td><c:out value="${part.numOfContainer}" /></td>
                    <td><c:out value="${part.containerPerPallet}" /></td>
                    <td><c:out value="${part.quotation}" /></td>
                    <td><c:out value="${part.reminder}" /></td>
                    <td><p id="demo"><c:out value="${part.mix}" /></p></td>         
                </tr>
            </c:forEach>
            
             
        </table>
        
    </div>   
    
    <p></p>
    <p></p>
    <p></p>
    
    <!-- 
	<div align="center">
	<button type="button" onclick="myFunction()">Show Color</button>
	</div>
	 -->	
	   
	<script>
	function myFunction() {
		document.getElementById("demo").style.backgroundColor="green";
		<!-- 
		var result = "${part}";
		foreach every object and call mix
		
		for(var res:result){
		var r=res.mix;
		
		if (r=="N")
		{
			document.getElementById("demo").style.backgroundColor="red"; 
		}
		
		else if (r=="Y")
		{
			document.getElementById("demo").style.backgroundColor="green"; 
		}
		}
		-->
	}
	
	document.getElementById("demo").innHTML=myFunction();
	
	</script>
	

   <p></p>
   <p></p>
   <p></p>
    <br>
    <br>
    
    <div align="center">
    <button  onclick="window.location.href='/Palletcounter/UserMultipleInput.jsp'" >NEXT</button>
    </div>
</body>
</html>