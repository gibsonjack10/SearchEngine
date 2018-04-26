import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {

    private WebPageNode root; // root of the BST-based search engine
    
    public SearchEngine() {
	this.root = null;
    } // creates an empty search engine
	
	public boolean isEmpty() {
		if(root == null) {
			return true;
		} else {
			return false;
		}
	} // returns true if the search engine 
		//is empty; false otherwise
    
    public void insert(String id, String webLink) {
    	try {
    		root = insertHelper(root, id, webLink);
    		
    	} catch (Exception IllegalArgumentException) {
    		System.out.println("WARNING: failed to insert duplicate web page: " + id);
    	}
    	
    	
    	
    	
    } // inserts an instance 
		// of WebPageNode with the given id and weblink into the search 
		// engine conforming to the search order property of a BST.
		// This method throws an exception if the user tries to 
		// insert an entry with a duplicate id.
		// !!!! A helper method should be used here !!!!
		// The insert method may call a private recursive 
		//      helper method to operate
    
    private WebPageNode insertHelper(WebPageNode node, String id, String webLink) throws Exception {
    	if (node == null) {
    		node = new WebPageNode(id, webLink);
    	} else {
    		if(node.getId().compareTo(id) == 0) {
    			throw new IllegalArgumentException();
    		}
    		if(node.getId().compareTo(id) > 0) {

    			node.setLeftChild(insertHelper(node.getLeftChild(), id, webLink));
    		} else {
    			node.setRightChild(insertHelper(node.getRightChild(), id, webLink));
    		}
    	}
    	
    	return node;
    }
    
    
    
 
    public String searchWebPage(String id) {
		WebPageNode node = root;
		if(searchHelper(node, id)) {
			return searchHelper2(node, id).getId() + " - " + searchHelper2(node, id).getWebLink();
		} else {
			return "No web link found fo the web page " + id + ".";
		}
		
	} // A look-up method that 
		// searches for a webPageNode with the given id in the current
		// search engine and returns the related weblink if that webPageNode 
		// is present. Otherwise, a Warning message starting with 
		// "No web link found" should be returned back, for instance: 
		// "No web link found for the web page <id>".
		// !!!! A helper method should be used here !!!!
		// The searchWebPage method may call a private recursive 
		//     helper method to operate
    
    private boolean searchHelper(WebPageNode node, String id) {
    	if(node.getId().equals(id)) {
    		return true;
    	}
    	if(node.getLeftChild() != null) {
			if (searchHelper(node.getLeftChild(), id)) {
				node = node.getLeftChild();
				return true;
			}
		}
    	if(node.getRightChild() != null) {
			if (searchHelper(node.getRightChild(), id)) {
				node = node.getRightChild();
				return true;
			}
		}
    	
    	return false;
    }
    
    private WebPageNode searchHelper2(WebPageNode node, String id) {
    	if(node.getId().equals(id)) {
    		return node;
    	}
    	if(node.getLeftChild() != null) {
			if (searchHelper(node.getLeftChild(), id)) {
				node = node.getLeftChild();
				return node;
			}
		}
    	if(node.getRightChild() != null) {
			if (searchHelper(node.getRightChild(), id)) {
				node = node.getRightChild();
				return node;
			}
		}
    	
    	return null;
    	
    }
 
    public int getWebPageCount() {
		return NodeCounter(root);
    	
	} // returns the number of webPageNodes
		// stored in the search engine
		// !!!! A helper method should be used here !!!!
		// The getWebPageCount method should call a private recursive 
		//     helper method to operate
    
    private int NodeCounter(WebPageNode node) {
    	if(node == null) {
    		return 0;
    	} else {
    	int nodes = 1;
    	nodes += NodeCounter(node.getLeftChild());
    	nodes += NodeCounter(node.getRightChild());
    	return nodes;
    	}
    }
    
    
 
    public ArrayList<String> getAllWebPages() {
		ArrayList<String> s = new ArrayList<String>();
		//ArrayList<WebPageNode> nodes = new ArrayList<WebPageNode>();
		pagePrinter(root);
	
		return s;
		
		
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
    
    private void pagePrinter(WebPageNode node) {
    	
    	if(node != null) {
    		
    		pagePrinter(node.getLeftChild());
    		System.out.print(node.getId() + " ");
    		pagePrinter(node.getRightChild());	

    	}
    	

    	
    	
//    	if(node != null) {
//    		String s = "";
//    		pagePrinter(node.getLeftChild());
//    		s = node.getId();
//    		pagePrinter(node.getRightChild());
//    		return s;
//    	} else {
//    		return "";
//    	}
    	
    }
    
    
    
	
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		SearchEngine search = new SearchEngine();
		boolean keepGoing = true;
		while(keepGoing == true) {
		System.out.println("=========================== Search Engine ========"
				+ "====================");
		System.out.println("1. Enter 'i <id> <webLink>' to insert a web "
				+ "page in the search engine");
		System.out.println("2. Enter 's <id>' to search a web link in "
				+ "the search engine");
		System.out.println("3. Enter 'p' to print all the web page ids "
				+ "in the search engine");
		System.out.println("4. Enter 'c' to get the count of all web pages "
				+ "in the search engine");
		System.out.println("5. Enter 'q' to quit the program");
		System.out.println("================================================="
				+ "=====================");
		System.out.println();
		
			String s = scnr.next();
			if (s.equals("i") || s.equals("I")) {
				String j = scnr.next();
				String k = scnr.next();
				if(j != null && k != null) {
					search.insert(j, k);	
				} else {
					System.out.println("WARNING: failed to insert web page: "
							+ "Id/web link can’t be blank!");
				}
				
			}
			else if(s.equals("s") || s.equals("S")) {
				System.out.println(search.searchWebPage(scnr.next()));
			}
			else if(s.equals("q") || s.equals("Q")) {
				keepGoing = false;
				System.out.println("============================== END ==="
						+ "================================");
			}
			else if(s.equals("p") || s.equals("P")) {
				System.out.println(search.getAllWebPages().toString().replace("[", "").replace("]", ""));
			}
			else if(s.equals("c") || s.equals("C")) {
				System.out.println(search.getWebPageCount());
			}
			else {
				System.out.println("WARNING: Unrecognized command.");
			}
			System.out.println();
			
		}
		scnr.close();
		

	}

}