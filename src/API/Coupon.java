package API;

import java.util.ArrayList;

public interface Coupon {
	public boolean couponIsValid(ArrayList<Item> items);
	public boolean getDiscount(ArrayList<Item> items);
}
