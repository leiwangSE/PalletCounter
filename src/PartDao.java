import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table users
 * in the database.
 * @author Lei
 *
 */

public class PartDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public PartDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     //connect with DB;
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
            	//load DB driver, and each DB has its own driver;
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            //setup connection with DB;
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     //disconnect with the DB;
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     //prepareStatement allows to issue SQL query to DB


  
     
    
    
	public List<Part> getParts(List<String> idList) throws SQLException {
		
		connect();
		//create getParts list and part object
    	List<Part> getParts= new ArrayList<>();
    	Part part= null;
    	Iterator<String> iterator=idList.iterator();
    	Iterator<String> iterator1=idList.iterator();
    	/*
    	sql=SELECT *,
    	CASE partID
    	  WHEN 800000005 THEN 1
    	  WHEN 800000003 THEN 2
    	  WHEN 800000001 THEN 3

    	END AS mysortorder
    	FROM part
    	WHERE partID in (800000005,800000003,800000001)
    	ORDER BY mysortorder;
    	*/
    	
    	String sql="SELECT *, CASE partID WHEN ";
    	StringBuilder str = new StringBuilder(sql);
    	String sql3=" THEN ";
    	String sql4=" END AS mysortorder FROM part WHERE partID in (";
    	String sqlPlus=" WHEN ";
    	int i=1;
    	while (iterator.hasNext()) {
    		String sql2=iterator.next();
    		str.append(sql2);
    		
    		str.append(sql3);
    		str.append(i);
    		str.append(sqlPlus);
    		i++;
    		System.out.println(sql2);
    		System.out.println(str);
    		System.out.println(i);
    		System.out.println(sql3);
		}
    	for(int j=0;j<6;j++)
    	{
    	str.deleteCharAt(str.length()-1);
    	}
    	
    	str.append(sql4);
    	while(iterator1.hasNext()) {
    		
    		String sql5=iterator1.next();
    		String sql6=",";
    		str.append(sql5);
    		str.append(sql6);
    		System.out.println(sql5);
    		System.out.println(sql6);
    	}
    	String sql7=")";
    	String sql8=" ORDER BY mysortorder;";
    	str.append(sql7);
    	str.deleteCharAt(str.length()-2);
    	str.append(sql8);
    	System.out.println(sql4);
		
		System.out.println(sql7);
		System.out.println(str);
		
    	
    	/*
    	String sql="SELECT * FROM part WHERE PartID=";
    	StringBuilder str = new StringBuilder(sql);
    	String sql3=" or PartID=";
    	while (iterator.hasNext()) {
    		String sql2=iterator.next();
    		str.append(sql2);
    		str.append(sql3);
    		System.out.println(sql2);
    		System.out.println(str);
		}
    	*/
    	
    	
//    	String sql3=" or partID="+partID2
//    			+ " or PartID="+partID3 +" or partID="+partID4
//    			+ " or PartID="+partID5 +" or partID="+partID6
//    			+ " or PartID="+partID7 +" or partID="+partID8
//    			+ " or PartID="+partID9 +" or partID="+partID10
//    			+ " or PartID="+partID11 +" or partID="+partID12
//    			+ " or PartID="+partID13 +" or partID="+partID14
//    			+ " or PartID="+partID15;
    	
    	
    	//sql=sql+sql2+sql3;
		
    	String sqlStatement = str.toString();
    	
    	System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzz");
    	System.out.println(sqlStatement);
//        System.out.println("11111111111111111");
//        System.out.println(sql);
        
        Statement statement=jdbcConnection.createStatement();
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//		
//        statement.setInt(1, partID1);
//        statement.setInt(2, partID2);
//        statement.setInt(3, partID3);
//        statement.setInt(4, partID4);
//        statement.setInt(5, partID5);
//        statement.setInt(6, partID6);
//        statement.setInt(7, partID7);
//        statement.setInt(8, partID8);
//        statement.setInt(9, partID9);
//        statement.setInt(10, partID10);
//        statement.setInt(11, partID11);
//        statement.setInt(12, partID12);
//        statement.setInt(13, partID13);
//        statement.setInt(14, partID14);
//        statement.setInt(15, partID15);
         
        ResultSet resultSet = statement.executeQuery(sqlStatement);
         
        System.out.println("1222222222222222221");
        //
        while (resultSet.next()) {
        	 System.out.println("iiiiiiiiiiiiiiiii");
        	 //get elements from resultset
        	 int partID = Integer.parseInt(resultSet.getString("PartID"));
             int containerPerPallet = Integer.parseInt(resultSet.getString("ContainerPerPallet"));
             String mix = resultSet.getString("Mix");
             //Put all elements to part object
             part= new Part(partID,containerPerPallet,mix);
             System.out.println(partID);
             System.out.println(containerPerPallet);
             System.out.println(mix);
             //add part object to getParts list
             getParts.add(part);
        }
         
        System.out.println("33333333333333333333");
        resultSet.close();
        statement.close();
         
        return  getParts;
	}
	
	public Part getPart(Integer PartID) throws SQLException {
        Part part= null;
        String sql = "SELECT * FROM part WHERE PartID = ?";
         
        System.out.println("11111111111111111");
        connect();
        
        //An object that represents a recompiled SQL statement
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, PartID);
        
        //Execute sql query in preparestatement object and return resultset object generated by the Query 
        ResultSet resultSet = statement.executeQuery();
         
        System.out.println("1222222222222222221");
        //the first row as the current row and then second row as the current row
        if (resultSet.next()) {
        	 System.out.println("iiiiiiiiiiiiiiiii");
        	//Retrieves the value of the designated column in the current row of this ResultSet object
             //as a String in the Java programming language.
        	 Integer partID = Integer.parseInt(resultSet.getString("PartID"));
             Integer containerPerPallet = Integer.parseInt(resultSet.getString("ContainerPerPallet"));
             String mix = resultSet.getString("Mix");
             //Put those three value into the part
             part= new Part(partID,containerPerPallet,mix);
        }
         
        System.out.println("33333333333333333333");
        resultSet.close();
        statement.close();
        //return the part
        return part;
    }

}
