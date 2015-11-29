package pivotallabs;


public class Set {
	private static int DEFAULT_SIZE = 25;
	private int[] elementData;
	private int size;
	public Set() {
		elementData = new int[DEFAULT_SIZE];
	}
	public int getSize() { 
		return size;
	}
	public void insert(int value) {
		if(!contains(value)) {
			elementData[size] = value;
			size ++;
		}
	}
	
	public boolean contains(int value) { 
		//iteration
		for(int count=0;count<size; count ++) {
			if(elementData[count] == value) {
				return true;
			}
		}
		return false;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	//only be called on our side 
	private int indexOf(int val){ 
		for(int c=0;c<size; c++) {
			if(elementData[c] == val) {
				return c;
			}
		}
		return -1;
	}
	//review break statements 
	public void remove(int i) {
		int io = indexOf(i);
		if(io!=-1) {
			elementData[io] = elementData[size - 1];
			size --;
		}
//		for(int c=0;c<size; c++) {
//			if(elementData[c] == i) {
//				elementData[c] = elementData[size - 1];
//				size --;
//				break;
//			}
//		}
	}
}
