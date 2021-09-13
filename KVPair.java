
public class KVPair<K extends Comparable<K>, E> implements Comparable<KVPair<K, E>> {

	private K key;
	private E value;

	/**
	 * Constructor for KVPair
	 * 
	 * @param newKey   - the key
	 * @param newValue - the object or value
	 */
	public KVPair(K newKey, E newValue) {
		key = newKey;
		value = newValue;
	}

	public int compareTo(KVPair<K, E> o) {
		// TODO Auto-generated method stub
		return key.compareTo(o.key());
	}

	public int compareTo(K o) {
		return key.compareTo(o);
	}

	public K key() {
		return key;
	}

	public E value() {
		return value;
	}

}
