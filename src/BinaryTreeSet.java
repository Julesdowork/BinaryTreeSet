import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * A BinaryTreeSet uses a TreeSet to store elements and an iterator
 * to visit them.
 * @author Julian McNeill
 */
public class BinaryTreeSet
{
	private Set<Node> treeSet;
	private Node root;
	
	/**
	 * Constructs an empty tree set.
	 */
	public BinaryTreeSet()
	{
		treeSet = new TreeSet<>();
		root = null;
	}
	
	/**
	 * Inserts a new node into the tree.
	 * @param obj the object to insert
	 */
	public void add(Comparable obj)
	{
		Node newNode = new Node();
		newNode.data = obj;
		newNode.parent = null;
		newNode.left = null;
		newNode.right = null;
		if (root == null)
		{
			root = newNode;
			treeSet.add(root);
		}
		else
		{
			root.addNode(newNode);
			treeSet.add(newNode);
		}
	}
	
	/**
	 * Returns an iterator that traverses the elements of this set.
	 * @return a binary tree set iterator
	 */
	public Iterator iterator()
	{
		return new BinaryTreeSetIterator();
	}
	
	class Node implements Comparable
	{
		public Comparable data;
		public Node parent;
		public Node left;
		public Node right;
		
		/**
		 * Inserts a new node as a descendant of this node.
		 * @param newNode the node to insert
		 */
		public void addNode(Node newNode)
		{
			int comp = newNode.data.compareTo(data);
			newNode.parent = this;
			if (comp < 0)
			{
				if (left == null) left = newNode;
				else left.addNode(newNode);
			}
			if (comp > 0)
			{
				if (right == null) right = newNode;
				else right.addNode(newNode);
			}
		}
		
		public int compareTo(Object otherObject)
		{
			if (otherObject == null) return -2;
			if (otherObject.getClass() != getClass()) return -2;
			Node other = (Node) otherObject;
			
			return data.compareTo(other.data);
		}
		
		/**
		 * Prints this node.
		 */
		public void printNode()
		{
			System.out.print(data + " ");
		}
	}
	
	class BinaryTreeSetIterator implements Iterator
	{
		private Node current;
		private Node previous;
		private Stack<Node> stack;
		
		/**
		 * Constructs a binary tree set iterator that points to the
		 * first element of the binary tree set.
		 */
		public BinaryTreeSetIterator()
		{
			current = null;
			previous = null;
			stack = new Stack<>();
		}
		
		public boolean hasNext()
		{
			if (current == null)
				return root != null;
			else if (current.right != null)
				return true;
			else
				return false;
		}
		
		public Comparable next()
		{
			if (!hasNext())
				throw new NoSuchElementException();			
			
			if (current == null)
				current = root;
			else
			{
				// Pop current node from stack and store it in previous
				// previous = stack.pop();
				current = current.left;
			}
			
			stack.push(current);
			return current.data;
		}
	}
}
