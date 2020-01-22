import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.NumberOfDocuments;

public class Utility {

    public int pallet(Part part) {
   	 int NumberOfContainer=part.numOfContainer;
   	 int ContainerPerPallet=part.containerPerPallet;
   	 int quotation=NumberOfContainer/ContainerPerPallet;
   	 
   	 return quotation;
    }
    
    public int remainder(Part part) {
   	 int numberOfContainer=part.numOfContainer;
   	 int containerPerPallet=part.containerPerPallet;
   	 int remainder=numberOfContainer%containerPerPallet;
   	 
   	 return remainder;
    }
    
     public List<Integer> pallets(List<Part> parts) {
    	 Iterator<Part> it= parts.iterator();
    	 List<Integer> quo=new ArrayList<Integer>();
    	     while(it.hasNext()) {
    	     Part part=it.next();
    		 int numberOfContainer=part.getNumOfContainer();
        	 int containerPerPallet=part.getContainerPerPallet();
        	 int quotation=numberOfContainer/containerPerPallet;
        	 System.out.println(part.getPart_id());
        	 System.out.println(numberOfContainer);
        	 System.out.println(containerPerPallet);
        	 System.out.println(quotation);
        	 quo.add(quotation);
    	 }
    	 return quo;
     }
     
     public List<Integer> remainders(List<Part> parts) {
    	 Iterator<Part> it= parts.iterator();
    	 List<Integer> rem=new ArrayList<Integer>();
    	     while(it.hasNext()) {
    	     Part part=it.next();	 
    		 int numberOfContainer=part.getNumOfContainer();
        	 int containerPerPallet=part.getContainerPerPallet();
        	 int reminder=numberOfContainer%containerPerPallet;
        	 System.out.println(part.getPart_id());
        	 System.out.println(numberOfContainer);
        	 System.out.println(containerPerPallet);
        	 System.out.println(reminder);
        	 rem.add(reminder);
    	 }
    	 
    	 return rem;
     }
}
