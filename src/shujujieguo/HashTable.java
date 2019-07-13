package shujujieguo;

class Info {
	private int key;
	private String name;
	
	public Info(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}

public class HashTable {
	private Info[] arr;
	
	public HashTable() {
		
	}
}
