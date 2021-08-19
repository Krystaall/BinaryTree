/*
 
 NAME: SHARVARI SONKUSARE



 CNUM: C22019221458
 ASSIGNMENT-1
 
 PROBLEM STATEMENT: Create a binary tree and perform inorder,preorder and postorder traversals.

 */






package Binary_tree;
import java.util.*;
import java.util.Stack;



class node
{
	node left,right;
	int data;
	
	public node (int d){
		left=null;
		right=null;
		data=d;
		}
}

class binary_tree{
	 node root;
	 public binary_tree(){
		root=null;
		}

	void create(int data){        //TIME COMPLEXITY: O(N)
		
		    //Create a new node  
	          node newNode = new node(data);  
	  
	          //Check whether tree is empty  
	          if(root == null){  
	              root = newNode;  
	              return;  
	            }
	          
	          else {  
	              //current node point to root of the tree  
	              node current = root, parent = null;  
	  
	              while(true) {  
	                  //parent keep track of the parent node of current node.  
	                  parent = current;  
	  
	                  //If data is less than current's data, node will be inserted to the left of tree  
	                  if(data < current.data) {  
	                      current = current.left;  
	                      if(current == null) {  
	                          parent.left = newNode;  
	                          return;  
	                      }  
	                  }  
	                  //If data is greater than current's data, node will be inserted to the right of tree  
	                  else {  
	                      current = current.right;  
	                      if(current == null) {  
	                          parent.right = newNode;  
	                          return;  
	                      }  
	                  }  
	              }  
	          }  
	      }  
	
	
	void recursiveInorder(node lRoot) {       //TIME COMPLEXITY: O(N)
		if (lRoot == null)
			return;

		// first recur on left child 
		recursiveInorder(lRoot.left);

		// then print the data of node 
		System.out.print(lRoot.data + " ");

		// now recur on right child 
		recursiveInorder(lRoot.right);
	}
	
	
	
	void recursivePreorder(node lRoot) {              //TIME COMPLEXITY: O(N)
		if (lRoot == null)
			return;

	
		System.out.print(lRoot.data + " ");

		recursivePreorder(lRoot.left);

		recursivePreorder(lRoot.right);
	
	}
	
	
	void recursivePostorder(node lRoot) {              //TIME COMPLEXITY: O(N)
		
			if (lRoot == null)
				return;

			// first recur on left subtree
			recursivePostorder(lRoot.left);

			// then recur on right subtree
			recursivePostorder(lRoot.right);

			// now deal with the node
			System.out.print(lRoot.data + " ");
		
		
	}
	
	void nonrecursiveInorder() {      //TIME COMPLEXITY: O(N^2)
		
	        if (root == null)
	            return;
	 
	 
	        Stack<node> s = new Stack<node>();
	        node curr = root;
	 
	        // traverse the tree
	        while (curr != null || s.size() > 0)
	        {
	 
	            // Reach the left most Node of the curr Node 
	            while (curr !=  null)
	            {
	                // place pointer to a tree node on the stack before traversing the node's left subtree 
	                s.push(curr);
	                curr = curr.left;
	            }
	 
	            // Current must be NULL at this point 
	            curr = s.pop();
	 
	            System.out.print(curr.data + " ");
	 
	            //  it's right subtree's turn now
	            curr = curr.right;
	        }
	    }
	
	void nonrecursivePreorder() {         //TIME COMPLEXITY: O(N)
		 
	      
	        if (root == null) {
	            return;
	        }
	 
	        // Create an empty stack and push root to it
	        Stack<node> nodeStack = new Stack<node>();
	        nodeStack.push(root);
	 
	        /* Pop all items one by one. Do following for every popped item
	         a) print it
	         b) push its right child
	         c) push its left child
	         Note that right child is pushed first so that left is processed first */
	        while (nodeStack.empty() == false) {
	 
	            // Pop the top item from stack and print it
	            node mynode = nodeStack.peek();
	            System.out.print(mynode.data + " ");
	            nodeStack.pop();
	 
	            // Push right and left children of the popped node to stack
	            if (mynode.right != null) {
	                nodeStack.push(mynode.right);
	            }
	            if (mynode.left != null) {
	                nodeStack.push(mynode.left);
	            }
	        }
		
		
	}
	void nonrecursivePostOrder() {                  //TIME COMPLEXITY: O(N^2)
		    
		        if (root == null)
		            return;
		 
		        Stack<node> stack = new Stack<node>();
		        node node = root;
		 
		        while (!stack.isEmpty() || node != null)
		        {
		            while (node != null)
		            {
		                if (node.right != null)
		                    stack.add(node.right);
		                stack.add(node);
		                node = node.left;
		            }
		 
		            node = stack.pop();
		 
		            if (node.right != null && !stack.isEmpty()
		                    && node.right == stack.peek())
		            {
		                node nodeRight = stack.pop();
		                stack.push(node);
		                node = nodeRight;
		            } else
		            {
		                System.out.print(node.data + " ");
		                node = null;
		            }
		        }
		    
	
		
	}
	
	// Wrappers over above recursive functions
		void recursivePostorder() {	 recursivePostorder(root); }
		void recursiveInorder() {	 recursiveInorder(root); }
		void recursivePreorder() {	 recursivePreorder(root); }

	public static void main(String[] args) {
		int no;
		binary_tree b =new binary_tree();
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("\n**************************************");
			System.out.println("MENU: \n\n1.Create a Binary Tree \n2.Display the recursive Inorder \n3.Display the non recursive Inorder \n4.Display the non recursive Preorder\n5.Display the non Recursive Postorder \n6.Display the recursive Preorder \n7.Display the recursive Postorder");
			System.out.println("\n*************************************");
			System.out.println("\nEnter your choice: ");
			no=sc.nextInt();
			switch(no){
			case 1:
            //call create();
				System.out.println("Enter data: ");
				int m= sc.nextInt();
				b.create(m);
				break;
			case 2:

				System.out.println("\nThe Recursive Inorder is: ");
				//callInOrder();
				b.recursiveInorder();
				break;
	        case 3:
	        	System.out.println("\nThe Non Recursive Inorder is: ");
	        	//nonrecursiveInorder();
	        	b.nonrecursiveInorder();
	        	break;
	        case 4:
	        	System.out.println("\nThe Non Recursive Preorder is: ");
	        	//nonrecursivePreorder();
	        	b.nonrecursivePreorder();
	        	break;
	        case 5:
	        	System.out.println("\nThe Non Recursive Postorder is: ");
	        	b.nonrecursivePostOrder();
	        	//nonrecursivePostOrder();
	        	break;
	        case 6:
	        	System.out.println("\nThe Recursive Preorder is: ");
	        	//callPreOrder();
	        	b.recursivePreorder();
	        	break;
	        case 7:
	        	System.out.println("\nThe Recursive Postorder is: ");
	        	//callPostOrder();
	        	b.recursivePostorder();
	        	break;
	        	

}
System.out.println("\nDo you want to continue ,1 to continue,0 to exit");
no=sc.nextInt();
}while (no==1);
}
}




/*
OUTPUT:


**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
1
Enter data: 
6

Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
1
Enter data: 
3

Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
1
Enter data: 
4

Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
1
Enter data: 
2

Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
1
Enter data: 
8

Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
1
Enter data: 
9

Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
2

The Recursive Inorder is: 
2 3 4 6 8 9 
Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
3

The Non Recursive Inorder is: 
2 3 4 6 8 9 
Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
4

The Non Recursive Preorder is: 
6 3 2 4 8 9 
Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
6

The Recursive Preorder is: 
6 3 2 4 8 9 
Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
5

The Non Recursive Postorder is: 
2 4 3 9 8 6 
Do you want to continue ,1 to continue,0 to exit
1

**************************************
MENU: 

1.Create a Binary Tree 
2.Display the recursive Inorder 
3.Display the non recursive Inorder 
4.Display the non recursive Preorder
5.Display the non Recursive Postorder 
6.Display the recursive Preorder 
7.Display the recursive Postorder

*************************************

Enter your choice: 
7

The Recursive Postorder is: 
2 4 3 9 8 6 
Do you want to continue ,1 to continue,0 to exit
0

 */


