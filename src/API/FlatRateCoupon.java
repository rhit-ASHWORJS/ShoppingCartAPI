package API;

import java.util.ArrayList;
import java.util.Date;

public class FlatRateCoupon implements Coupon{
	
	private int couponID;
	private double rate;
	private Date expirationDate;
	private int[][] itemsForCoupon;//first row item ID, second row quantity needed
	private Database db = new Database();
	
	public FlatRateCoupon(int CouponID)
	{
		this.couponID = CouponID;
		this.rate = db.getFlatRateAmount(CouponID);
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
		return rate;
	}

	@Override
	public int getID() {
		return couponID;
	}

}
