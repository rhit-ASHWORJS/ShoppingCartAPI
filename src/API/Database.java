package API;

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
	
	//Methods used for Addresses
	public int getCustomerZipCode(int CustomerID)
	{
		if(CustomerID==1425)
		{
			return 47803;
		}
		return 0;
	}
	public String getCustomerCity(int CustomerID)
	{
		if(CustomerID==1425)
		{
			return "Terre Haute";
		}
		return "";
	}
	public String getCustomerState(int CustomerID)
	{
		if(CustomerID==1425)
		{
			return "Indiana";
		}
		return "";
	}
	public String getCustomerCountry(int CustomerID)
	{
		if(CustomerID==1425)
		{
			return "US";
		}
		return "";
	}
	public boolean setZipCode(int CustomerID, int ZipCode) { return true; }
	public boolean setCity(int CustomerID, String City) { return true; }
	public boolean setState(int CustomerID, String State) { return true; }
	public boolean setCountry(int CustomerID, String Country) { return true; }
}
