package game_item;

public class Armour {
    private String armourId;
    private String armourName;
    private int armourDef;
    private String armourType;
    private String armourSlot;
    private String armourDesc;
    private int minLevel;
    
    public Armour() {
    	
    }
    
	public Armour(String armourId, String armourName, int armourDef, String armourType, String armourSlot,
			String armourDesc, int minLevel) {
		super();
		this.armourId = armourId;
		this.armourName = armourName;
		this.armourDef = armourDef;
		this.armourType = armourType;
		this.armourSlot = armourSlot;
		this.armourDesc = armourDesc;
		this.minLevel = minLevel;
	}

	@Override
	public String toString() {
		return "Armour [armourId=" + armourId + ", armourName=" + armourName + ", armourDef=" + armourDef
				+ ", armourType=" + armourType + ", armourSlot=" + armourSlot + ", armourDesc=" + armourDesc
				+ ", minLevel=" + minLevel + "]";
	}

	public String getArmourId() {
		return armourId;
	}

	public String getArmourName() {
		return armourName;
	}

	public int getArmourDef() {
		return armourDef;
	}

	public String getArmourType() {
		return armourType;
	}

	public String getArmourSlot() {
		return armourSlot;
	}

	public String getArmourDesc() {
		return armourDesc;
	}

	public int getMinLevel() {
		return minLevel;
	}
	
}

