import java.util.*;

public class TestBST {


    public static void main(String[] args) {
	Random rand = new Random();
	BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();

	int n = 20;
	int[] rnum = new int[n];
	for (int i=0; i < n; i++) {
	    rnum[i] = rand.nextInt(100);
	    tree.addElement(Integer.valueOf(rnum[i]));
	}

	// an inorder traversal should list the items 
	// in ascending order
	tree.inOrder();
	System.out.println();

	for (int i=0; i < n; i++) {
	    if ( tree.getElement(Integer.valueOf(rnum[i])) == null)
			System.out.println("Failed to find " + rnum[i]);
	}
	    

	tree.showTree();

	tree = new BinarySearchTree<Integer>();
	tree.addElement(Integer.valueOf(2));
	tree.addElement(Integer.valueOf(1));
	tree.addElement(Integer.valueOf(3));

	
	/*	tree.inOrder(); System.out.println();
	System.out.println("Removed " +
			   tree.removeElement(new KeyedInt(2)));
	tree.inOrder(); System.out.println();
	System.out.println("Removed " + 
			   tree.removeElement(new KeyedInt(1)));
	tree.inOrder(); System.out.println();

	*/
	tree.showTree();

    }


}

