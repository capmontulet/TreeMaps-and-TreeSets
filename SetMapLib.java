import java.nio.file.Paths;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Class contains methods to create treemap, display treemap, search for a specific value in a treemap, create treeset
 * add new value to a treemap key, and reverse a treeset.
 * @author Thomas Stanley
 */
public class SetMapLib {
	
    TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
	TreeSet<String> values = new TreeSet<String>();
	TreeSet<Integer> keys = new TreeSet<Integer>();
    Scanner input = new Scanner(System.in);

    /**
     * Creates a treemap from file input. Uses Scanner to read file, and delimiter to ignore commas, newlines, and returns in the file.
     * Closes the scanner afterwards to maintain security.
     * @param map TreeMap to be filled from the file.
     */
    public void createTreeMap(TreeMap<String, Integer> map){
        try {
        	//creating scanner object with file to be read as the input stream
			Scanner reader = new Scanner(Paths.get("productowners.txt")).useDelimiter("[,\r\n]");
			//while the file has content, loop will run
			while(reader.hasNext()) {
				//reading each line for information, then assigning it to a new treemap element
				String value = reader.next();
	            int key = reader.nextInt();
				map.put(value, key);
				reader.nextLine();
			}
			reader.close();
			}catch (NoSuchElementException NSE) {
				System.out.println("...TreeMap Created...");
				return;
    		}catch (Exception e) {
    			return;
			}
    }
    
    /**
     * Displays treemap using enhanced for loop. Prints each Value and Key
     * @param map Treemap passed to print from
     */
    public void displayTreeMap(TreeMap<String, Integer> map) {
    	//enhanced for loop
    	for (Entry<String, Integer> entry : map.entrySet()) {
    	     System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
			 System.out.println();
    	}
    }
    
    /**
     * Searches a treemap for a user given value and displays whether it is present. Uses containsValue()
     * @param map Treemap passed from main to search
     * @param input Scanner object passed for user input
     */
    public void searchTreeMap(TreeMap<String, Integer> map, Scanner input){
    	//prompting user for input
    	System.out.print("Please enter a search key: ");
		int searchKey = input.nextInt();
		//if else statment to discern if key is present in treemap
		if(map.containsValue(searchKey)){
			System.out.println("...key " + searchKey + " was found...\n");
		}else{
			System.out.println("... key "+ searchKey+" was not found...\n");
		}

    }

	/**
	 * Creates two treesets from a treemap. Loops through a treemap and assigns the values to one treeset and the keys 
	 * to another, then prints.
	 * @param map Treemap passed from main to be copied into the treesets
	 * @param valuesTreeSet	Treeset that contains the values from the passed treemap
	 * @param keysTreeSet Treeset that contains the keys from the passed treemap
	 */
	public void createTreeSet(TreeMap<String, Integer> map, TreeSet<String> valuesTreeSet, TreeSet<Integer> keysTreeSet) {
		//looping through the treemap and entering the data from each loop into new treeset elements.
		for (Entry<String, Integer> entry : map.entrySet()) {
			 keysTreeSet.add(entry.getValue());
			 valuesTreeSet.add(entry.getKey());
	   }
		//displaying treesets
	   System.out.println("Keys TreeSet: " + keysTreeSet);
	   System.out.println("Values TreeSet: " + valuesTreeSet);
	}

	/**
	 * Searches the treemap for a value, prompts the user for a new key, then replaces the value with a new key.
	 * @param map treemap passed from main to search through
	 * @param input Scanner object for user input
	 */
	public void updateTreeMap(TreeMap<String, Integer> map, Scanner input){
		//prompts user for existing value of treemap
		System.out.print("Please enter existing value (String): ");
		input.nextLine();
		String value = input.nextLine();
		//prompting user for new key
		System.out.print("Please enter new key (Integer): ");
		int keyReplacement = input.nextInt();
		
		//if the treemap element has a matching value, replaces the key at that location
		if(map.containsKey(value)){
			map.replace(value, keyReplacement);
		}else{
			System.out.println("...Value not found...");
		}
	}

	/**
	 * Reverses the treeset and displays. Uses descendingSet() to instantiate a reversed version of the passed treeset.
	 * @param treeSet Treeset passed from main to reverse and display
	 */
	public void reverseTreeSet(TreeSet<String> treeSet){
		//creating new treeset from reversed treeset passed from main.
		TreeSet<String> valueSet = (TreeSet<String>)treeSet.descendingSet();

		//displaying reversed treeset
		System.out.println("...Names Treeset was sorted in descending order...");
		for(String value : valueSet){
			System.out.println(value);
		}
	} 
}
