/*
 * 
 * @function:to implement hashmap in my own
 * @ get and put, the structure of a map
 * we have an array of linked list and take hash value as the identifier(index)
 * 
 */
public class hashmap {
	private final static int SIZE = 16; // initial size, could be resized later
	private Entry[] table = new Entry[SIZE]; // array 
	// entry is actually a linked list with a next "pointer"
	class Entry{
		final String key; // better not to change the key
		String value;
		Entry nextEntry;
		public Entry(String k, String v) {
			key = k;
			value = v;
		}
		public String getKey(){
			return key;
		}
		public String getValue(){
			return value;
		}
		public void setValue(String v){
			this.value = v;
		}
	}
	
	public Entry get(String k){
		int hash = k.hashCode() % SIZE;
		Entry entry = table[hash];
		while(entry != null){
			if(entry.key.equals(k)){
				return entry;
			}
			entry = entry.nextEntry;
		}
		return null;
	}
	public void put(String k, String v){
		int hash = k.hashCode() % SIZE;
		Entry entry = table[hash];
		if(entry != null){
			if(entry.key.equals(k)){
				entry.value = v;
			}else{
				while(entry.nextEntry != null){
					entry = entry.nextEntry;
				}// reach the end of the list
				Entry newEntry = new Entry(k, v);
				entry.nextEntry = newEntry;
			}
		}else{
			Entry newEntry = new Entry(k, v);
			table[hash] = newEntry;
		}
		
	}

	public static void main(String[] args){
		hashmap hm = new hashmap();
		hm.put("ning", "needs");
		hm.put("dan", "lover");
		hm.put("wei", "rivals");
		System.out.println(hm.get("ning").getKey());
	}
}
