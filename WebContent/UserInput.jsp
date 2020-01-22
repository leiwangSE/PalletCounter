<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
<br>
<br>
<h1 align="center">Pallet Counter Application</h1>
<p align="center">Please type Part ID and the number of container</p>
<br>
<div align="center">   
       <form action="UserInput" method="post">
        <table border="1" cellpadding="5">
          <tr>
              <th>
               
               
             </th>
            <th width ="41%">Part ID </th>
       
        
            <th width ="43%" > The Number of Container </th>
            
            
            
            <tr >
                <th>Item 1</th>
                <td >
                    <input type="text" name="PartID1" size="24"
                            value="" 
                        />
              </td>
                <td>
                    <input type="text" name="NumOfContainer1" size="24"
                           value=""
                        />
                  
             
                </td>
            </tr>

            <tr>
                <td colspan="3" align="center">
                    <input type="submit" value="Submit" />
                </td>
            </tr>
          
        
          
        </table>
        </form>
        
    </div>     
</body>
</html>