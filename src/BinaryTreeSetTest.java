import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Iterator;

class BinaryTreeSetTest
{

	@Test
	void test01AddRoot()
	{
		BinaryTreeSet set = new BinaryTreeSet();
		Iterator iter = set.iterator();
		int i = 6;
		set.add(i);
		assertEquals(6, iter.next());
	}
	
	@Test
	void test02EmptyHasNext()
	{
		BinaryTreeSet set = new BinaryTreeSet();
		Iterator iter = set.iterator();
		assertEquals(false, iter.hasNext());
	}

}
