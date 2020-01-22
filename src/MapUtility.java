import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapUtility {
     //List a list of value without null value
	 public List<String> valueSetList(String[] value) {
	    	List<String> valueList=new ArrayList<String>();
	    	System.out.println("111111111");
			for(int j=0;j<value.length;j++) {
				System.out.println("222222222");
				if(!value[j].isEmpty()) {
					 valueList.add(value[j]);
				}
			}
				
			Iterator<String> iterator=valueList.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
			return valueList;
		}
	    //return the length of value without null
		public int lengthCounter(String[] value ) {
			int counter=0;
			for(int i=0;i<value.length;i++) {
				if(!value[i].isEmpty()) {
					counter=counter+1;		
				}
			}

			return counter;
		}
		
}
