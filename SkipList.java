import java.util.*;
import java.util.ArrayList;
import java.lang.reflect.Array;

/**
 * 
 */

/**
 * @author milenjohn
 *
 */
public class SkipList<K extends Comparable<K>, E> {

	private class SkipNode<K extends Comparable<K>, E> {
		private KVPair<K, E> rec;
		private SkipNode<K, E>[] forward;

		public E element() {
			return rec.value();
		}

		public K key() {
			return rec.key();
		}

		@SuppressWarnings("unchecked")
		public SkipNode(K key, E elem, int level) {
			rec = new KVPair<K, E>(key, elem);
			forward = new SkipNode[level + 1];
			for (int i = 0; i < level; i++)
				forward[i] = null;
		}

		public String toString() {
			return rec.toString();
		}
	}

	private SkipNode<K, E> head;
	private int level;
	private int size;
	private Random ran = new Random(); // Hold the Random class object

	public SkipList() {
		head = new SkipNode<K, E>(null, null, 0);
		level = -1;
		size = 0;
	}

	// Pick a level using a geometric distribution
	public int randomLevel() {
		int lev;
		for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++) { // ran is random generator
			; // Do nothing
		}
		return lev;
	}

	private void adjustHead(int newLevel) {
		SkipNode<K, E> temp = head;
		head = new SkipNode<K, E>(null, null, newLevel);
		for (int i = 0; i <= level; i++) {
			head.forward[i] = temp.forward[i];
		}
		level = newLevel;
	}

	@SuppressWarnings("unchecked")
	public SkipNode<K, E>[] dump() {
		SkipNode<K, E> temp = head;
		@SuppressWarnings("unchecked")
		SkipNode<K, E>[] list = new SkipNode[1];
		int length = 0;
		while (temp != null) { // traverses skip list
			if (length == 0) { // to set up the output array
				list[0] = new SkipNode<K, E>(temp.key(), temp.element(), temp.forward.length);
				length++;
			} else {
				@SuppressWarnings("unchecked")
				SkipNode<K, E>[] tempArray = new SkipNode[list.length + 1];
				System.arraycopy(list, 0, tempArray, 0, list.length);
				tempArray[tempArray.length - 1] = new SkipNode<K, E>(temp.key(), temp.element(), temp.forward.length);
				list = tempArray;
			}
			temp = temp.forward[0];
		}
		return list; // Returns result
	}

	/**
	 * Getter method for the skiplist's size
	 * 
	 * @return An integer of the number of skipnodes in the skiplist. Does not
	 *         include the header skipnode.
	 */
	public int getSize() {
		return size;
	}

	/** Insert a key, element pair into the skip list */
	public void insert(K key, E element) {

		int newLevel = randomLevel(); // New node's level
		if (newLevel > level) // If new node is deeper
			adjustHead(newLevel); // adjust the header

		// Creates new array
		@SuppressWarnings("unchecked")
		SkipNode<K, E>[] update = (SkipNode<K, E>[]) Array.newInstance(SkipNode.class, level + 1);

		SkipNode<K, E> x = head; // Start at header node
		for (int i = level; i >= 0; i--) { // Find insert position
			while ((x.forward[i] != null) && (key.compareTo(x.forward[i].key()) > 0))
				x = x.forward[i];
			update[i] = x; // Track end at level i
		}
		x = new SkipNode<K, E>(key, element, newLevel);
		for (int i = 0; i <= newLevel; i++) { // Splice into list
			x.forward[i] = update[i].forward[i]; // Who x points to
			update[i].forward[i] = x; // Who y points to
		}
		size++; // Increment dictionary size
	}

}
