package API;

/**
 * Note: This is not how TaxCalculator will be implemented in the long run!
 * 
 * The methods and parameters will remain the same, but this class exists to talk
 * with whatever system actually calculates taxes.  It has access to the cart and the database
 * while calculating taxes, so it can access any information it would possibly need.  It can
 * then store whatever information it needs to communicate to the external tax system, get its
 * results back, and return them to cart.
 * 
 * @author jacob
 *
 */
public class TaxCalculator {
	
	Database db = new Database();
	
	public TaxCalculator()
	{
		
	}
	
	public double calculateTaxToCart(Cart cartToTax)
	{
		//This will use its database connection and access to cart to get any information it needs to calculate taxes
		//Chances are that taxes are calculated by a different system, so this can also call that system here.
		return 0;
	}
}
