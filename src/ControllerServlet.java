

import java.awt.TexturePaint;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author 	Lei
 */
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PartDao partDao;
   
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        partDao = new PartDao(jdbcURL, jdbcUsername, jdbcPassword);
    
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String action = request.getServletPath();
 
        System.out.println("Action: V2222222222" + action);
        
        try {
            switch (action) {
            case "/UserInput":
                UserInput(request, response);
                break;
            case "/UserMultipleInput":
            	UserMultipleInput(request, response);
                break;
//            default:
//                listPart(request, response);
//                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 

	private void UserMultipleInput(HttpServletRequest request, HttpServletResponse response)throws SQLException,ServletException,IOException {
		 
		//Get a map of data and store as key value pair
        Map m=request.getParameterMap();
        //Return set
        Set s = m.entrySet();
        //Iterate the set
        Iterator it = s.iterator();
        
        
        MapUtility map=new MapUtility();
        List<String> iDList=new ArrayList<String>();
        List<String> numList=new ArrayList<String>();
        String idKey=null;
        String numKey=null;
        String s1=new String("PartID");
        String s2=new String("NumOfContainer");
        //Iterate the whole set
            while(it.hasNext()){

                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();

                String key       = entry.getKey();
                String[] value   = entry.getValue();
                
                //System.out.println("The length is "+value.length);
                int lengCounter= map.lengthCounter(value);
                System.out.println("Key is "+key);
                System.out.println("The valid value length is "+lengCounter);
                if(key.equals(s1)) {
                	idKey=key;
                	iDList=map.valueSetList(value);
                }
                else if(key.equals(s2))
                {
                	numKey=key;
                	numList=map.valueSetList(value);
                }
                System.out.println("The iDKey is "+idKey);
                System.out.println("The valid iDList is "+iDList);
                System.out.println("The numDKey is "+numKey);
                System.out.println("The valid numList is "+numList);
            }
            

		 //Get a list of partID, NumberPerPallet, Mix from database according to a list of partID 
		 //Set a list of array to getParts and get a list of object part
		 List<Part> getParts=new ArrayList<Part>();
				    getParts= partDao.getParts(iDList);
		 
		 //Iterate getParts
	     Iterator<Part> iterator=getParts.iterator();
		 
		 
		 while(iterator.hasNext())
		 {
			 System.out.println(iterator.next().getPart_id());
			 
		 }
		 Iterator<Part> iterator1=getParts.iterator();
		 while(iterator1.hasNext())
		 {
			 System.out.println(iterator1.next().getContainerPerPallet());
		 }
		 
		 //assign a map of numberofcontainer to container list
		 //cast List<string> to List<integer>
		 List<Integer> containerList= new ArrayList<Integer>();
		               containerList=numList.stream().map(Integer::parseInt).collect(Collectors.toList());
		 

		 System.out.println(containerList);	
		 
		 //Set a list of the number of container to a list of object part one by one
		 // call by reference
		 Iterator<Part> itNum=getParts.iterator();
		 Iterator<Part> itPallet=getParts.iterator();
		 Iterator<Part> itLeftover=getParts.iterator();
		 System.out.println("jjjjjjjjjjjjjj");	
		 
		 //Assign numofcontainer to each list object part's NumOfContainer variable 
		 for(int NumOfContainer : containerList) {
			 System.out.println(NumOfContainer);
			 
			 //Return true if next would return an element
			 //set NumOfContainer
				 if(itNum.hasNext())
				    {
				    	
				    	Part part=new Part();
				    	//return next element in iteration
				    	part=itNum.next();
				    
				    	part.setNumOfContainer(NumOfContainer);
				    	
				    	System.out.println(part.getNumOfContainer());
				    	System.out.println(part.getNumOfContainer());
				    }
        
				 System.out.println();
			}
		 
		 

		 System.out.println("oooooooooooo");	
		 //return a list of pallets and leftover
		 //Calculate Pallets and leftover
		 Utility result= new Utility();
		 List<Integer> palletsList=result.pallets(getParts);
		 List<Integer> leftoversList=result.remainders(getParts);
		 System.out.println(palletsList);
		 System.out.println(leftoversList);	
		 
		 for(int pallet:palletsList)
		 {
			 
			 if(itPallet.hasNext()) {
				 Part part=new Part();
			    	//return next element in iteration
			    	part=itPallet.next();
			    
			    	part.setQuotation(pallet);
			    	
			    	System.out.println(part.getQuotation());
			    	System.out.println(part.getQuotation());
				    
			 }
		 }
		 
		 for(int leftover:leftoversList)
		 {
			 
			 if(itLeftover.hasNext()) {
				 
				    Part part=new Part();
			    	//return next element in iteration
			    	part=itLeftover.next();
			    
			    	part.setReminder(leftover);
			    	
			    	System.out.println(part.getReminder());
			    	System.out.println(part.getReminder());
			 }
		 }
		 
		 System.out.println("ppppppppppppp");
		 
//		 System.out.println("part_id:" + part.getPart_id());
//		 System.out.println("part_NumOfContainer" + part.getNumOfContainer());
//		 System.out.println("part_getMix" + part.getMix());
//		 System.out.println("part_pallet" + result.pallet(part));
//		 System.out.println("part_remindPart" + result.remainder(part));
//		 int containerPerPallet=part.getContainerPerPallet();
//		 String mix=part.getMix();
		 //Stores attributes in request
		 request.setAttribute("listParts", getParts);
		 
		 //return an object to a given path
	     RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
	     dispatcher.forward(request, response);
		
	}

	

	private void UserInput(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		 int partID1=Integer.parseInt(request.getParameter("PartID1"));
		 int numOfContainer1=Integer.parseInt(request.getParameter("NumOfContainer1"));
		 //Part part= new Part();
		// part.setPart_id(partID1);
		// part.setNumOfContainer(numOfContainer1);
		 
		 
		 System.out.println("partID1:" + partID1);
		 System.out.println("numOfContainer1:" + numOfContainer1);
		 
		//Get an object of PartID, NumberPerPallet and Mix from database
		 Part part=partDao.getPart(partID1);
		 
		 //Set number of container for part object which won't affect existing variables
		 part.setNumOfContainer(numOfContainer1);
		 
		 //Pass the object part to Utility result and get the result of pallet and leftover
		 Utility result= new Utility();
		 result.pallet(part);
		 result.remainder(part);
		 
		 //Print out partID, NumOfContainer, Mix, Pallet and leftover
		 System.out.println("part_id:" + part.getPart_id());
		 System.out.println("part_NumOfContainer" + part.getNumOfContainer());
		 System.out.println("part_getMix" + part.getMix());
		 System.out.println("part_pallet" + result.pallet(part));
		 System.out.println("part_remindPart" + result.remainder(part));
		 int containerPerPallet=part.getContainerPerPallet();
		 String mix=part.getMix();
		 
		 //Store object of part and result in request
		 request.setAttribute("part", part);
		 request.setAttribute("result", result);
		 //get RequestDispatcher object that acts as wrapper for resource located in given path.
	     RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
	     dispatcher.forward(request, response);//The forward method works at server side, 
	     //and it sends the same request and response objects to another servlet.
	     
		
	}


}