package API;

import java.util.ArrayList;

public interface Coupon {
	public boolean couponIsValid(ArrayList<Item> items);
	public double getDiscount(ArrayList<Item> items);
	public int getID();
}
