package API;

import java.util.ArrayList;
import java.util.Date;

/***
 * Note: This is not how Database will be implemented in the long run!
 * 
 * The methods, parameters, etc will stay the same, and this implementation
 * fully encapsulates the design of what the database will do.  However,
 * the actual implementation of the methods is just full of dummy data
 * that is used in the tests.  This is sort of a 'Mock' of the database to be used
 * for testing, but the actual database class will have vastly different implementation
 * because it will interface with real databases.  Regardless, this is the closest we
 * can come given the assignment
 * 
 * Also, since this database doesn't store any actual information it's fine for different
 * classes to initialize versions of it.  No data is stored here - we just call the real DBS,
 * and their connections would probably be held in static fields.
 * 
 * @author jacob
 *
 */
public class Database {

	public Database() {
		//Database setup code (i.e. connection management) will go here
	}
	
	private static int testUserID = 1425;
	private static int testUserZip = 47803;
	private static String testUserCity = "Terre Haute";
	private static String testUserState = "Indiana";
	private static String testUserCountry = "US";
	
	private static int testPercentCouponId=1112;
	private static double testPercentCouponPercent=12.5;
	private static Date testPercentCouponExpirationDate=new Date(3000, 10, 10); //Set date to something that hasn't yet expired
	private static int[][] testItemsPercentCoupon = {{2,2}};
	
	private static int testFlatRateCouponId=2223;
	private static double testFlatRateCouponRate=2.0;
	private static Date testFlatRateCouponExpirationDate=new Date(3000, 10, 10); //Set date to something that hasn't yet expired
	private static int[][] testItemsFlatRateCoupon = {{1,1}};
	
	private int testItemID = 2;
	private String testItemName = "Shoe";
	private double testItemBasePrice = 2.25;
	private int testItemQuantInCart1 = 2;
	
	private int testCartID = 8;
	private int[] testCartItems = {2};
	private int[] testCartCoupons = {1112};
	private ArrayList<Date> testCartRejects = new ArrayList<Date>();
	//In testing version of this class, "", -1, and null are error returns
	public int[] getCartItems(int cartID)
	{
		if(cartID == testCartID)
		{
			return testCartItems;
		}
		return null;
	}
	
	public int[] getCartCoupons(int cartID)
	{
		if(cartID == testCartID)
		{
			return testCartCoupons;
		}
		return null;
	}
	
	public ArrayList<Date> getCartRejects(int cartID)
	{
		if(cartID == testCartID)
		{
			return testCartRejects;
		}
		return null;
	}
	
	//Methods used for Addresses
	//All return -1 in case of error
	public int getCustomerZipCode(int CustomerID)
	{
		if(CustomerID==testUserID)
		{
			return testUserZip;
		}
		return -1;
	}
	public String getCustomerCity(int CustomerID)
	{
		if(CustomerID==testUserID)
		{
			return testUserCity;
		}
		return "";
	}
	public String getCustomerState(int CustomerID)
	{
		if(CustomerID==testUserID)
		{
			return testUserState;
		}
		return "";
	}
	public String getCustomerCountry(int CustomerID)
	{
		if(CustomerID==testUserID)
		{
			return testUserCountry;
		}
		return "";
	}
	public boolean setZipCode(int CustomerID, int ZipCode) 
	{ 
		if(CustomerID==testUserID)
		{
			testUserZip = ZipCode;
			return true;
		}
		return false;
	}
	public boolean setCity(int CustomerID, String City) 
	{ 
		if(CustomerID==testUserID)
		{
			testUserCity = City;
			return true;
		}
		return false;
	}
	public boolean setState(int CustomerID, String State) 
	{ 
		if(CustomerID==testUserID)
		{
			testUserState = State;
			return true;
		}
		return false;
	}
	public boolean setCountry(int CustomerID, String Country) 
	{ 
		if(CustomerID==testUserID)
		{
			testUserCountry = Country;
			return true;
		}
		return false;
	}
	
	public double getPercentCouponPercent(int percentCouponID)
	{
		if(percentCouponID==testPercentCouponId)
		{
			return testPercentCouponPercent;
		}
		return -1;
	}
	
	public Date getCouponExpirationDate(int couponID)
	{
		if(couponID==testPercentCouponId)
		{
			return testPercentCouponExpirationDate;
		}
		if(couponID == testFlatRateCouponId)
		{
			return testFlatRateCouponExpirationDate;
		}
		return null;
	}
	
	public int[][] getItemsForCoupon(int couponID)
	{
		if(couponID == testPercentCouponId)
		{
			return testItemsPercentCoupon;
		}
		if(couponID == testFlatRateCouponId)
		{
			return testItemsFlatRateCoupon;
		}
		return null;
	}
	
	public String getNameForItem(int itemID)
	{
		if(itemID == testItemID)
		{
			return testItemName;
		}
		return null;
	}
	
	public double getPriceForItem(int itemID)
	{
		if(itemID == testItemID)
		{
			return testItemBasePrice;
		}
		return -1;
	}
	
	public int getQuantityForItem(int itemID, int cartID)
	{
		if(itemID == testItemID && cartID == testCartID)
		{
			return testItemQuantInCart1;
		}
		return -1;
	}
	public boolean setQuantityForItem(int itemID, int cartID, int quant)
	{
		if(itemID == testItemID && cartID == testCartID)
		{
			testItemQuantInCart1=testItemQuantInCart1;
			return true;
		}
		return false;
	}
	public double getFlatRateAmount(int couponID) {
		if(testFlatRateCouponId == couponID)
		{
			return testFlatRateCouponRate;
		}
		return -1;
	}
	
	public boolean couponIsPercentCoupon(int couponID) {
		if(couponID == testPercentCouponId)
		{
			return true;
		}
		return false;
	}
	
	public boolean couponIsFlatRateCoupon(int couponID) {
		if(couponID == testFlatRateCouponId)
		{
			return true;
		}
		return false;
	}
}
