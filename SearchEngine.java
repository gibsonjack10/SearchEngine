import java.util.ArrayList;

public class SearchEngine {

    private WebPageNode root; // root of the BST-based search engine
    
    public SearchEngine() {
	this.root = null;
    } // creates an empty search engine
	
	public boolean isEmpty() {
		return false;
	} // returns true if the search engine 
		//is empty; false otherwise
    
    public void insert(String id, String webLink) {
	
    } // inserts an instance 
		// of WebPageNode with the given id and weblink into the search 
		// engine conforming to the search order property of a BST.
		// This method throws an exception if the user tries to 
		// insert an entry with a duplicate id.
		// !!!! A helper method should be used here !!!!
		// The insert method may call a private recursive 
		//      helper method to operate
 
    public String searchWebPage(String id) {
		return null;
	} // A look-up method that 
		// searches for a webPageNode with the given id in the current
		// search engine and returns the related weblink if that webPageNode 
		// is present. Otherwise, a Warning message starting with 
		// "No web link found" should be returned back, for instance: 
		// "No web link found for the web page <id>".
		// !!!! A helper method should be used here !!!!
		// The searchWebPage method may call a private recursive 
		//     helper method to operate
 
    public int getWebPageCount() {
		return 0;
	} // returns the number of webPageNodes
		// stored in the search engine
		// !!!! A helper method should be used here !!!!
		// The getWebPageCount method should call a private recursive 
		//     helper method to operate
 
    public ArrayList<String> getAllWebPages() {
		return null;
	} // returns an ArrayList 
		// of String that stores all the id fields of the webPageNodes
		// present in the current search engine, sorted in alphabetical 
		// order from left to right.
		// !!!! A helper method should be used here !!!!
		// The getAllWebPages method may call a private recursive 
		//     helper method to operate
    
	// You can add additional private helper methods to help organize 
	// your implementation for these functions. You can add also 
	// a main method. But, no additional fields or public methods
	// should be added to this class. 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
