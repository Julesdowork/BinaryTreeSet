import java.util.Iterator;

/**
 * Tests the binary tree set class.
 * @author Julian McNeill
 */
public class BinaryTreeSetTester
{
	public static void main(String[] args)
	{
		BinaryTreeSet set = new BinaryTreeSet();
		set.add(6);
		Iterator iter = set.iterator();
		
		while (iter.hasNext())
			System.out.print(iter.next() + " ");
	}
}
