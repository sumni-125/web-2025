package game_item;

import java.util.ArrayList;
import java.util.List;

public class ItemService {
	
    private ItemDAO dao = new ItemDAO();

    public ArrayList<ItemCategory> getItemCategories() {
        return dao.getAllCategories();
    }
    
    public ArrayList<Weapon> getWeapons() {
        return dao.getAllWeapons();
    }
  
    public ArrayList<Armour> getArmours() {
        return dao.getAllArmours();
    } 
    
    public ArrayList<MiscItem> getMiscItems() {
        return dao.getAllMiscItems();
    } 
    
}