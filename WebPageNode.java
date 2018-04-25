public class WebPageNode{
 
    private final String id; 		// The id of the web page
	private final String webLink;   // The web link of the web page
    private WebPageNode leftChild;  // The leftChild of the the current WebPageNode
    private WebPageNode rightChild; // The rightChild of the the current WebPageNode
 
 
    public WebPageNode(String id, String webLink) {
    this.id = id;
    this.webLink = webLink;
    } // This should be
		
    
	// Add public setters and getters methods
	public WebPageNode getLeftChild() {
		return this.leftChild;
	}
	
	public void setLeftChild(WebPageNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public WebPageNode getRightChild() {
		return this.rightChild;
	}
	
	public void setRightChild(WebPageNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getWebLink() {
		return this.webLink;
	}
	
	// !! No further public or private (helper) method, should be added to this class!
}
