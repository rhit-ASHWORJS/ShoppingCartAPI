package API;

import java.util.ArrayList;
import java.util.Date;

/***
 * This class handles overall cart logic
 * 
 * @author ashworjs
 *
 */
public class Cart {
	private int cartID;
	private ArrayList<Coupon> appliedCoupons;
	private ArrayList<Date> rejectedCouponDates;
	private ArrayList<Item> items;
	private Database db = new Database();
	
	//Load our cart from the DB
	public Cart(int cartID)
	{
		this.cartID = cartID;
		
		items = new ArrayList<Item>();
		for(int itemID : db.getCartItems(cartID))
		{
			items.add(new Item(itemID, cartID));
		}
		
		appliedCoupons = new ArrayList<Coupon>();
		for(int couponID : db.getCartItems(cartID))
		{
			//This code will need to change if a new coupon type is added, but this is all
			//the code in cart that will need to be edited if that happens
			if(db.couponIsPercentCoupon(couponID))
			{
				appliedCoupons.add(new PercentageCoupon(couponID));
			}
			if(db.couponIsFlatRateCoupon(couponID))
			{
				appliedCoupons.add(new PercentageCoupon(couponID));
			}
		}
		
		rejectedCouponDates = db.getCartRejects(cartID);
	}
	
	/**
	 * These methods lets the API figure out which coupon is having an issue
	 */
	public int getCouponIssue()
	{
		for(Coupon c : appliedCoupons)
		{
			if(!c.couponIsValid(items))
			{
				return c.getID();
			}
		}
		return -1;//no issue
	}

	public int[] getItemIDS() {
		int[] itemIDs = new int[items.size()];
		for(int i=0; i<itemIDs.length; i++)
		{
			itemIDs[i]=items.get(i).itemID();
		}
		return itemIDs;
	}
	
	
}
