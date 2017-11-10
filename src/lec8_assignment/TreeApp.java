package lec8_assignment;

//tree.java
//demonstrates binary tree
//to run this program: C>java TreeApp
import java.io.*;
import java.util.*;               // for Stack class
////////////////////////////////////////////////////////////////
class Node
{
public int iData;              // data item (key)
public double dData;           // data item
public String sData;
public Node leftChild;         // this node's left child
public Node rightChild;        // this node's right child

/*public void displayNode()      // display ourself
   {
   System.out.print('{');
   System.out.print(iData);
   System.out.print(", ");
   System.out.print(dData);
   System.out.print("} ");
   }*/
}  // end class Node
////////////////////////////////////////////////////////////////
class Tree
{
private Node root;             // first node of tree

//-------------------------------------------------------------
public Tree()                  // constructor
   { root = null; }            // no nodes in tree yet
//-------------------------------------------------------------
//-------------------------------------------------------------
// returns node with next-highest value after delNode
// goes to right child, then right child's left descendents
private Node getSuccessor(Node delNode)
   {
   Node successorParent = delNode;
   Node successor = delNode;
   Node current = delNode.rightChild;   // go to right child
   while(current != null)               // until no more
      {                                 // left children,
      successorParent = successor;
      successor = current;
      current = current.leftChild;      // go to left child
      }
                                        // if successor not
   if(successor != delNode.rightChild)  // right child,
      {                                 // make connections
      successorParent.leftChild = successor.rightChild;
      successor.rightChild = delNode.rightChild;
      }
   return successor;
   }
//-------------------------------------------------------------
public void traverse(int traverseType)
   {
   switch(traverseType)
      {
      case 1: System.out.print("\nPreorder traversal: ");
              preOrder(root);
              break;
      case 2: System.out.print("\nInorder traversal:  ");
              inOrder(root);
              break;
      case 3: System.out.print("\nPostorder traversal: ");
              postOrder(root);
              break;
      }
   System.out.println();
   }
//-------------------------------------------------------------
private void preOrder(Node localRoot)
   {
   if(localRoot != null)
      {
      System.out.print(localRoot.iData + " ");
      preOrder(localRoot.leftChild);
      preOrder(localRoot.rightChild);
      }
   }
//-------------------------------------------------------------
private void inOrder(Node localRoot)
   {
   if(localRoot != null)
      {
      inOrder(localRoot.leftChild);
      System.out.print(localRoot.iData + " ");
      inOrder(localRoot.rightChild);
      }
   }
//-------------------------------------------------------------
private void postOrder(Node localRoot)
   {
   if(localRoot != null)
      {
      postOrder(localRoot.leftChild);
      postOrder(localRoot.rightChild);
      System.out.print(localRoot.iData + " ");
      }
   }
//-------------------------------------------------------------
public void displayTree()
   {
   Stack globalStack = new Stack();
   globalStack.push(root);
   int nBlanks = 32;
   boolean isRowEmpty = false;
   System.out.println(
   "......................................................");
   while(isRowEmpty==false)
      {
      Stack localStack = new Stack();
      isRowEmpty = true;

      for(int j=0; j<nBlanks; j++)
         System.out.print(' ');

      while(globalStack.isEmpty()==false)
         {
         Node temp = (Node)globalStack.pop();
         if(temp != null)
            {
            System.out.print(temp.sData);
            localStack.push(temp.leftChild);
            localStack.push(temp.rightChild);

            if(temp.leftChild != null ||
                                temp.rightChild != null)
               isRowEmpty = false;
            }
         else
            {
            System.out.print("--");
            localStack.push(null);
            localStack.push(null);
            }
         for(int j=0; j<nBlanks*2-2; j++)
            System.out.print(' ');
         }  // end while globalStack not empty
      System.out.println();
      nBlanks /= 2;
      while(localStack.isEmpty()==false)
         globalStack.push( localStack.pop() );
      }  // end while isRowEmpty is false
   System.out.println(
   "......................................................");
   }  // end displayTree()

public void Tree(String input) {
	root=null;
	Node[] nodeArray = new Node[input.length()];
	for(int i=0;i<input.length();i++) {
		nodeArray[i]=new Node();
		nodeArray[i].sData= String.valueOf(input.charAt(i));
	}
	
	Node newNode= new Node();
	newNode.sData="+";
	newNode.leftChild=nodeArray[0];
	newNode.rightChild=nodeArray[1];
	
	for(int j=2;j<nodeArray.length;j++) {
		Node addNode= new Node();
		addNode.sData="+";
		addNode.leftChild=newNode;
		addNode.rightChild=nodeArray[j];
		newNode=addNode;
	}
	root=newNode;
} 

//-------------------------------------------------------------
}  // end class Tree
////////////////////////////////////////////////////////////////
class TreeApp
{
public static void main(String[] args) throws IOException
   {
   int value;
   Tree theTree = new Tree();
   
   System.out.println("Enter String");
   String input=getString();
   theTree.Tree(input);
   while(true)
      {
      System.out.print("Enter first letter of show, ");
     // System.out.print("insert, find, delete, or traverse: ");
      int choice = getChar();
      switch(choice)
         {
         case 's':
            theTree.displayTree();
            break;
         default:
            System.out.print("Invalid entry\n");
         }  // end switch
      }  // end while
   }  // end main()
//-------------------------------------------------------------
public static String getString() throws IOException
   {
   InputStreamReader isr = new InputStreamReader(System.in);
   BufferedReader br = new BufferedReader(isr);
   String s = br.readLine();
   return s;
   }
//-------------------------------------------------------------
public static char getChar() throws IOException
   {
   String s = getString();
   return s.charAt(0);
   }
//-------------------------------------------------------------
public static int getInt() throws IOException
   {
   String s = getString();
   return Integer.parseInt(s);
   }
//-------------------------------------------------------------
}  // end class TreeApp
////////////////////////////////////////////////////////////////