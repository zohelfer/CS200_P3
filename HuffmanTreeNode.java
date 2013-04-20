import java.util.LinkedList;

/**
 * HuffmanTreeNode.java
 *
 * This class is an implementation of TreeNode.java interface
 * You should implement all of the methods in the Tree interface.
 * If you need to add more methods, please add your own methods.
 * Since this node will store a java character and frequencies 
 * for creating a list of Huffman code, you can add member
 * methods related to the functionality.
 */


public class HuffmanTreeNode implements TreeNode {
	/** add your member properties here*/

//	TreeNode left;
//	TreeNode right;
//	private char letter;
//	private int freq;
	protected HuffmanTreeNode rightChild;
	protected HuffmanTreeNode leftChild;
	protected TableItem n;


	/** add your constructor here */
	public HuffmanTreeNode(TableItem newItem)
	{
		n = (newItem);
		leftChild = null;
		rightChild = null;
	}

//	public HuffmanTreeNode(char letter, int freq){
//		setFreq(freq);
//		setChar(letter);
//
//	}

	/** add your implementation of the TreeNode interface here */


	/** For the Huffman coding algorithm, you can add getters for Frequency and Character
     Also, you can add a method telling whether this node is a leaf node. 
	 */ 


	/** add your additional methods here */
	public boolean isLeaf(TreeNode node){
		if (node.getLeft()==null&&node.getRight()==null)
			return true;
		else 
			return false;
	}
//	public int getFreq(){
//		return freq;
//	}
//
	public TableItem getChar(){
		return n;
	}
//	public void setFreq(int freq){
//		this.freq=freq;
//	}
//
//	public void setChar(char letter){
//		this.letter=letter;
//	}
	@Override
	public int compareTo(TreeNode o) {

		return this.compareTo(o);
	}

	@Override
	public void attachRight(TreeNode newRightNode) {
		rightChild.equals(newRightNode);

	}

	@Override
	public void attachLeft(TreeNode newLeftNode) {
		leftChild.equals(newLeftNode);

	}

	@Override
	public TreeNode detachLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeNode detachRight() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TreeNode getRight() {

		return rightChild;
	}

	@Override
	public TreeNode getLeft() {
		// TODO Auto-generated method stub
		return leftChild;
	}





}





