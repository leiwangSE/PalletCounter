/*
 * Part.java
 * 
 * secondchange 
 * This is a model class represents a user entity
 * 
 * This is the first change I make today
 * @author Lei
 *
 *
 */
public class Part {
	
    protected Integer part_id; 
    protected Integer numOfContainer;
    protected Integer containerPerPallet;
	protected Integer quotation;
    protected Integer reminder;  
    protected String  mix;
    
  
	public Part () {
    }
 

	public Part (Integer part_id) {
		this.part_id=part_id;
	}
    public Part (Integer part_id, Integer numOfContainer) {
    	this.part_id=part_id;
        this.numOfContainer=numOfContainer;
    }
    public Part(Integer part_id,Integer containerPerPallet,String mix) {
    	this.part_id=part_id;
    	this.containerPerPallet=containerPerPallet;
    	this.mix=mix;
    	
    }
    
    public Part(Integer part_id,Integer numOfContainer, Integer containerPerPallet,String mix) {
    	this(part_id,containerPerPallet,mix);
    	this.numOfContainer=numOfContainer;
    	
    }
    
    public Part (Integer part_id, Integer numOfContainer,Integer containerPerPallet, Integer quotation, Integer reminder, String mix) {
    	this(part_id,containerPerPallet,mix);
        this.numOfContainer=numOfContainer;
        this.quotation=quotation;
        this.reminder=reminder;
    }
    
   
    public Integer getPart_id() {
		return part_id;
	}


	public void setPart_id(Integer part_id) {
		this.part_id = part_id;
	}

	public int getNumOfContainer() {
		return numOfContainer;
	}
	public void setNumOfContainer(int numOfContainer) {
		this.numOfContainer = numOfContainer;
	}
	

	
	 public Integer getContainerPerPallet() {
			return containerPerPallet;
		}


		public void setContainerPerPallet(Integer containerPerPallet) {
			this.containerPerPallet = containerPerPallet;
		}

	public Integer getQuotation() {
		return quotation;
	}


	public void setQuotation(Integer quotation) {
		this.quotation = quotation;
	}


	public Integer getReminder() {
		return reminder;
	}


	public void setReminder(Integer reminder) {
		this.reminder = reminder;
	}


	public String getMix() {
		return mix;
	}


	public void setMix(String mix) {
		this.mix = mix;
	}


}


