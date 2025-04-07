package game_item;

public class Weapon {
    private String weaponId;
    private String weaponName;
    private int weaponAtk;
    private String weaponType;
    private String weaponDesc;
    private int minLevel;
    
    public Weapon() {
    	
    }
    
	public Weapon(String weaponId, String weaponName, int weaponAtk, String weaponType, String weaponDesc,
			int minLevel) {
		super();
		this.weaponId = weaponId;
		this.weaponName = weaponName;
		this.weaponAtk = weaponAtk;
		this.weaponType = weaponType;
		this.weaponDesc = weaponDesc;
		this.minLevel = minLevel;
	}

	@Override
	public String toString() {
		return "Weapon [weaponId=" + weaponId + ", weaponName=" + weaponName + ", weaponAtk=" + weaponAtk
				+ ", weaponType=" + weaponType + ", weaponDesc=" + weaponDesc + ", minLevel=" + minLevel + "]";
	}

	public String getWeaponId() {
		return weaponId;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public int getWeaponAtk() {
		return weaponAtk;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public String getWeaponDesc() {
		return weaponDesc;
	}

	public int getMinLevel() {
		return minLevel;
	}
    
}
