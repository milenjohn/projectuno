import java.util.*;
import java.util.ArrayList;

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
		SkipNode temp = head;
		head = new SkipNode(null, null, newLevel);
		for (int i = 0; i <= level; i++) {
			head.forward[i] = temp.forward[i];
		}
		level = newLevel;
	}

	/** Insert a key, element pair into the skip list */
	public boolean insert(Comparable key, Object elem) {
		int newLevel = randomLevel(); // New node's level
		if (newLevel > level) { // If new node is deeper
			adjustHead(newLevel); // adjust the header
		}
		// Track end of level
		SkipNode[] update = new SkipNode[level + 1];
		SkipNode x = head; // Start at header node
		for (int i = level; i >= 0; i--) { // Find insert position
			while ((x.forward[i] != null) && (x.forward[i].key().compareTo(key) < 0)) {
				x = x.forward[i];
			}
			update[i] = x; // Track end at level i
		}
		x = new SkipNode(key, elem, newLevel);
		for (int i = 0; i <= newLevel; i++) { // Splice into list
			x.forward[i] = update[i].forward[i]; // Who x points to
			update[i].forward[i] = x; // Who points to x
		}
		size++; // Increment dictionary size
		return true;

	}
}
