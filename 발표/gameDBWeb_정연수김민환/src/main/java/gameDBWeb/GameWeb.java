package gameDBWeb;

public class GameWeb {
	
	String character_class;
	String player_name;
	String armour_set_name;
	String armour_set_effect;
	
	public GameWeb(String character_class,  String armour_set_name, String armour_set_effect) {
		super();
		this.character_class = character_class;
		this.armour_set_name = armour_set_name;
		this.armour_set_effect = armour_set_effect;
	}
	
	

	@Override
	public String toString() {
		return "GameWeb [character_class=" + character_class +  ", armour_set_name="
				+ armour_set_name + ", armour_set_effect=" + armour_set_effect + "]";
	}



	public String getCharacter_class() {
		return character_class;
	}

	public String getPlayer_name() {
		return player_name;
	}

	public String getArmour_set_name() {
		return armour_set_name;
	}

	public String getArmour_set_effect() {
		return armour_set_effect;
	}
	
	

}
