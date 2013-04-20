/**
 *
    Huffman frequency table

    This class creates and maintains a table. 
    For example for a string "AAAABBCCC"
    ========================================
    char         frequency        Code
    ----------------------------------------
     A               4             1
     B               2            11 
     C               3            10
    ========================================

    Code is created by Huffman coding algorithm
    Please note that the code is stored as a String object.
*/

import java.util.LinkedList;

public class HuffmanFrequencyTable  {
    LinkedList<TableItem> table; // you can use other data structures
    String inputStr = "";
    
    
    // if you need more member property, please add here


    // Constructor
    public HuffmanFrequencyTable(String _inputStr){
		inputStr = _inputStr;
		table = new LinkedList<TableItem>();
		this.initTable();
    }

    // reads input String and fill the columes of char and frequency
    private void initTable(){
		
    	TableItem item;
    	boolean trigger;
    	for (int i=0; i<inputStr.length(); i++){
    	    trigger=false;
    		for (int z=0;z<table.size();z++){
    			if (table.get(z).getInputChar()==inputStr.charAt(i)){
    				trigger=true;
    				table.get(z).raiseFreq();
    			}
    		}
    		if (trigger==false){
    			item=new TableItem(inputStr.charAt(i),1);
    			table.addLast(item);
    			}
    		}
    		
    }
       
    // returns the size of this table
    public int size(){
		return table.size();
    }


    // returns the associated character for the specified code
    public char getChar(String code){
    	char assChar=' ';
    	for (int z=0;z<table.size();z++){
    		if (table.get(z).getCode().equals(code)){
    			 assChar=table.get(z).getInputChar();
    		}
    		
    	}
    		return assChar;
    }

    // returns the associated code for the specified character 
    public String getCode(char inputChar){
    	String assString="";
    	for (int z=0;z<table.size();z++){
    		if (table.get(z).getInputChar()==inputChar){
    			 assString=table.get(z).getCode();
    		}
    		
    	}
    		return assString;
    }

    // returns index'th item of this table
    public TableItem getItem(int index){
		return table.get(index);
    }


    // stores a new code in the item that has same character specified in the inputChar
    public void setCode(char inputChar, String newCode){
    	for (int z=0;z<table.size();z++){
    		if (table.get(z).getInputChar()==inputChar){
    			 table.get(z).setCode(newCode);
    		}
    		
    	}
    }


    // you can add main() for your unit testing
   public static void main(String [] args){
	   HuffmanFrequencyTable table1=new HuffmanFrequencyTable("gdhfgsgfjs");
	   //System.out.print(table1.size());
	  // table1.setCode('d', "010111");
	   //TableItem item;
	   for(int i=0;i<table1.table.size();i++){
	   System.out.print(table1.table.get(i).getInputChar());
	   System.out.print(" ");
	   System.out.println(table1.table.get(i).getFreq());}
	   
   }


   
}