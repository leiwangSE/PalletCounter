Final version

Project Purpose and Implementation:
A user can input Part ID and The number of container according to user's requirement that can be from 1 to 15 rows of instance in the input request page. After submit the request, controller servlet on Tomcat server will call corresponding DAO(Data Asscess Object) and then DAO get the manipulated results from database returning back to controller servlet. Controller servlet will render the results with a corresponding JSP result page.

Architecture:
This project utilized MVC design pattern, using JSP pages as VIEWER module, controller servlet as CONTROLLER module and DAO as MODEL module.

Data Structure:
The project utilized data structure of List, Set and Map. Map is used to display corresponding rows of results according the user's input, for example, if a user input 5 rows of instance, the responding page will display 5 rows of caculated results only.
