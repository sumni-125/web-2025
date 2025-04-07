package game_item;

public class MiscItem {
    private String miscId;
    private String miscName;
    private String miscType;
    private String miscDesc;
    private String stackable;
    
    public MiscItem() {
    	
    }
    
	@Override
	public String toString() {
		return "MiscItem [miscId=" + miscId + ", miscName=" + miscName + ", miscType=" + miscType + ", miscDesc="
				+ miscDesc + ", stackable=" + stackable + "]";
	}

	public MiscItem(String miscId, String miscName, String miscType, String miscDesc, String stackable) {
		super();
		this.miscId = miscId;
		this.miscName = miscName;
		this.miscType = miscType;
		this.miscDesc = miscDesc;
		this.stackable = stackable;
	}

	public String getMiscId() {
		return miscId;
	}

	public String getMiscName() {
		return miscName;
	}

	public String getMiscType() {
		return miscType;
	}

	public String getMiscDesc() {
		return miscDesc;
	}

	public String getStackable() {
		return stackable;
	}
	
}

