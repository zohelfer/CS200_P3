import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 *   Encoder takes user's input string and conver it to a bit sequence encoded by
 *   Huffman coding algorithm
 *
 *  Encoding process includes multiple steps:
 *  1. Create a frequency table with first two columns: charactor and frequency
 *  2. Create a Huffman tree based on the frequency table
 *  3. Create a list of code based on the Huffman tree created in the step 2.
 *     And store codes in the frequency table
 *  4. Encode user's input string based on the code in the frequency table
 *
 */


public class Encoder {
	private HuffmanTree ht;
	private String inputStr;
	private HuffmanFrequencyTable hft;


	// Constructor
	public Encoder(String _inputStr){
		this.inputStr = _inputStr;
		// Next line will build a Huffman Frequency Table for the inputStr
		this.hft = new HuffmanFrequencyTable(inputStr); 
		// Next line will build a Huffman Tree for the inputStr based on hft
		this.buildTree();
		// Next line will build a list of the Huffman codes based on the ht
		this.buildCode((HuffmanTreeNode)(ht.getRootItem()), "");
	}


	// Returns the HuffmanFrequencTable Object: This will be used for the grading
	public HuffmanFrequencyTable getFreqTable(){
		return hft;
	}

	// Returns the HuffmanTree Object: This will be used for decoding 
	public HuffmanTree getHuffmanTree(){
		return ht;
	}


	// Returns a bit sequence string encoded by Huffman Coding algorithm
	// NOTE: please save your bit sequence as a String
	// For example if your result contains 5 bits of 11000
	// store it as "11000". PA3 DOES NOT require bit operations.

	public String encodeString(){
		// add your code here
		String output = "";
		for (int j=0; j<inputStr.length(); j++)
		{
			char temp = inputStr.charAt(j);

			for(int i=0;i<hft.size();i++)
			{
				if(temp == hft.getItem(i).getInputChar()){
					output = output + hft.getItem(i).getCode();
				}
			}

		}
		return output;

	}	

	private void buildTree(){
		Stack<HuffmanTreeNode> s = new Stack<HuffmanTreeNode>();

		ArrayList<TableItem> tableCopy = new ArrayList<TableItem>();
		tableCopy.addAll(hft.table);
		//		for ( int i =0; i< tableCopy.size(); i++){
		//			System.out.println(tableCopy.get(i).getInputChar());
		//		}


		while(!tableCopy.isEmpty())
		{
			//System.out.println("List size: "+ tableCopy.size());
			int largest = 0;
			TableItem temp = tableCopy.get(0);
			//System.out.println("temp: "+temp.getInputChar());
			for(int i=1;i<tableCopy.size();i++)
			{
				//System.out.println("Stack is ready. i: "+ i);

				if(temp.getFreq()<tableCopy.get(i).getFreq())//hft.getItem(i).getFreq())
				{
					temp = tableCopy.get(i);
					largest = i;


				}
			}

			s.add(new HuffmanTreeNode(temp));
			tableCopy.remove(largest);
			//System.out.println("Stack: new item added: "+ temp.getInputChar()+" "+largest);
			//System.out.println(tableCopy.remove(largest).getInputChar());


		}
		//System.out.println("Stack is ready.");

		while(!s.empty())
		{
			TableItem star = new TableItem('*',0);
			HuffmanTreeNode nStar = new HuffmanTreeNode(star);
			nStar.rightChild=s.pop();
			nStar.leftChild=s.pop();
			System.out.println("Right child: "+nStar.rightChild.n.getFreq()+" charcter: " +nStar.rightChild.n.getInputChar() );
			System.out.println("Left child: "+nStar.leftChild.n.getFreq()+ " charcter: " +nStar.leftChild.n.getInputChar());
			nStar.n.setFreq(nStar.rightChild.n.getFreq()+nStar.leftChild.n.getFreq());

			//insert nStar into sorted stack
			for(int i=0;i<=s.size();i++)
			{
				if (s.isEmpty())
				{
					s.push(nStar);
					break;
				}
				else if((nStar.n.getFreq()>s.get(i).n.getFreq())||(i+1==s.size()))
				{
					s.add(i,nStar);
					break;
				}
			}
			//System.out.println("Stack size: " + s.size());
			if(s.size()==1)
			{
				ht = new HuffmanTree(nStar);
				s.clear();
			}

		}

		//System.out.println("Build Tree is ready");
	}




	// builds a list of the Huffman codes based on ht 
	private void buildCode(HuffmanTreeNode root, String code){
		// add your code here
	    	String nodeCode = code;
			//System.out.println(root.getFreq());
	    	// add your code here
	    	//hft.getItem(i).setCode(HuffCode)
	    	if(root.isLeaf(root) == true){
	    		//hft.getItem(0).setCode(nodeCode);
	    		root.getChar().setCode(nodeCode);
	    	}
	    	else{
	    		
	    		buildCode((HuffmanTreeNode)root.getLeft(), nodeCode+"0");
	    		buildCode((HuffmanTreeNode)root.getRight(), nodeCode+"1");  
	    		
	    	}
	    } 

//		for(int i = 0;i<hft.size();i++)
//		{
//			HuffmanTree temp = new HuffmanTree(root);
//			String HuffCode = code;
//
//
//			while((temp.rootnode.leftChild!=null)&&(temp.rootnode.rightChild!=null))
//			{
//				int ld = temp.rootnode.leftChild.n.getFreq()-hft.getItem(i).getFreq();
//				int rd = temp.rootnode.rightChild.n.getFreq()-hft.getItem(i).getFreq();
//
//				if(temp.rootnode.n.getInputChar()==hft.getItem(i).getInputChar())
//				{
//					hft.getItem(i).setCode(HuffCode);
//				}
//
//				else if(ld<rd)
//				{
//					HuffCode= HuffCode+"0";
//					//temp.rootnode.leftChild.getLeft().
//					temp.rootnode = temp.rootnode.leftChild;
//				}
//				else if(rd<ld)
//				{
//					HuffCode= HuffCode+"1";
//					temp.rootnode = temp.rootnode.rightChild;
//				}
//
//			}
//			hft.getItem(i).setCode(HuffCode);
//
//		}


		//	//ht.getRootItem().getLeft();
		//
		//	for (int i = 0 ;i<hft.size(); i++){
		//		//			//					System.out.println("TEST");
		//		//hft.getItem(i).setCode(search(ht,root,code));
		//		//			//char code1 = code.charAt(1);
		//		//			if (code.regionMatches(code.length()-1, "1",code.length(),code.length()-1 ) ){
		//		//				code = code+"1";
		//		//			}
		//		//			if (code.regionMatches(code.length()-1, "0",code.length(),code.length()-1 ) ){
		//		//				code = code+"0";
		//		//			}
		//		//				//System.out.println("yes");
		//		//			if(code.equals(""))
		//		//				code= code+"0";
		//		//				System.out.println(code);
		//		//				//hft.getItem(i).setCode(code);}
		//
		//		//if (root.) {
		//		//HuffmanTreeNode node = null;
		//		//HuffmanTreeNode internalNode = (HuffmanTreeNode)node;
		//		//code=code+'0';
		//		//buildCode((HuffmanTreeNode)ht.getRootItem().getLeft(), code);
		//		//prefix.remove(prefix.size() - 1);
		//
		//		//code=code+'1';
		//		//bui
		//ldCode((HuffmanTreeNode)ht.getRootItem().getRight(), code);
		//		//prefix.remove(prefix.size() - 1);
		//
		//		//hft.getItem(i).setCode(code+"1");
		//	}
		//}
	}










