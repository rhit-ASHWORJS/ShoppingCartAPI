package API;

/***
 * This is the actual customer API.  We always assume that the person
 * calling this API has the cartID they want to see the cart of, since
 * all customer to cart logic is handeled by whichever system does the
 * login stuff
 * 
 * @param cartID
 * @return
 */
public class CustomerAPI {

	public int[] handleGetCartItemIDs(int cartID)
	{
		Cart c = new Cart(cartID);
		return c.getItemIDS();
	}
	
	
	
}
