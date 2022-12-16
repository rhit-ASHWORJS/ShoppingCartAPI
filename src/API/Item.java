package API;

/***
 * This class handles overall item logic
 * 
 * @author ashworjs
 *
 */
public class Item {
	private String name;
	private double basePrice;
	private int quantity;
	private int itemID;
	private int cartID;
	private Database db = new Database();
	
	public Item(int itemID, int cartID)//Item constructor for InventoryAPI
	{
		this.itemID = itemID;
		this.cartID = cartID;
		this.name = db.getNameForItem(itemID);
		this.basePrice = db.getPriceForItem(itemID);
		this.quantity = db.getQuantityForItem(itemID, cartID);
	}
	
	public int itemID()
	{
		return itemID;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public double getPrice()
	{
		return basePrice;
	}
}
