/**
 * HuffmanTree.java
 *
 * This class is an implementation of Tree.java interface
 * You should implement all of the methods in the Tree interface.
 * If you need to add more methods, please add your own methods.
 */


public class HuffmanTree implements Tree{
    HuffmanTreeNode rootnode = null;
    
    public HuffmanTree(HuffmanTreeNode _rootnode){
		this.rootnode = _rootnode;
		
    }
    // implement Tree interface here
    // you can add main method for your unit testing

	@Override
	public void makeEmpty() {
		rootnode=null;
		
	}

	@Override
	public boolean isEmpty() {
		if (rootnode==null)
			return true;
		else
		return false;
	}

	@Override
	public TreeNode getRootItem() {
			return rootnode;
	}

	@Override
	public void setRootItem(TreeNode newRootItem) {
		rootnode=(HuffmanTreeNode) newRootItem;
		
	}

	@Override
	public void attachLeft(TreeNode newLeft) {
		rootnode.attachLeft(newLeft);
		
	}

	@Override
	public void attachRight(TreeNode newRight) {
		
		rootnode.attachRight(newRight);
		
	}

	@Override
	public void attachLeftSubtree(Tree newLeft) {
		 rootnode.attachLeft(newLeft.getRootItem());
		
	}

	@Override
	public void attachRightSubtree(Tree newRight) {
		rootnode.attachRight(newRight.getRootItem());
		
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
	public Tree detachLeftSubtree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tree detachRightSubtree() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void main(String [] args){
		
		   
		  
}
}