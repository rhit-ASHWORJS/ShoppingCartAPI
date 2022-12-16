package API;

import java.util.ArrayList;
import java.util.Date;

public class PercentageCoupon implements Coupon {
	
	private int couponID;
	private double percentage;
	private Date expirationDate;
	private int[][] itemsForCoupon;//first row item ID, second row quantity needed
	private Database db = new Database();
	
	public PercentageCoupon(int CouponID)
	{
		this.couponID = CouponID;
		this.percentage = db.getPercentCouponPercent(CouponID);
		this.expirationDate = db.getCouponExpirationDate(CouponID);
		this.itemsForCoupon = db.getItemsForCoupon(CouponID);
	}

	@Override
	public boolean couponIsValid(ArrayList<Item> items) {
		for(int neededItem=0; neededItem<itemsForCoupon.length; neededItem++)
		{
			int itemID = itemsForCoupon[neededItem][0];
			int itemQty = itemsForCoupon[neededItem][1];
			
			boolean sat = false;
			for(Item i : items)
			{
				if(i.itemID() == itemID && i.getQuantity() >= itemQty)
				{
					sat = true;
				}
			}
			if(sat == false)
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public double getDiscount(ArrayList<Item> items) {
		int totalPrice = 0;
		
		for(int neededItem=0; neededItem<itemsForCoupon.length; neededItem++)
		{
			int itemID = itemsForCoupon[neededItem][0];
			int itemQty = itemsForCoupon[neededItem][1];
			
			for(Item i : items)
			{
				if(i.itemID() == itemID)
				{
					totalPrice += i.getPrice()*i.getQuantity();
				}
			}
		}
		return totalPrice * percentage;
	}
	
	@Override
	public int getID() {
		return couponID;
	}
}
