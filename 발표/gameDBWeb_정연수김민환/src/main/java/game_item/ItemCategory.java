package game_item;

public class ItemCategory {
    private String categoryId;
    private String categoryName;

    public ItemCategory() {
    	
    }

    public ItemCategory(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ItemCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
