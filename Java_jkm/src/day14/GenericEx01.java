package day14;

public class GenericEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Array<String>list1 = new Array<>(10);
		list1.set(0, "안녕하세요");
		list1.set(1, "사과");
		list1.print();
		Array<Integer>list2 = new Array<>(10);
		list2.set(0, 1);
		list2.set(1, 2);
		list2.print();
		String [] list3 = new String[10];
		list3[0] ="안녕";
		list3[1] = "귤";
		Integer[] list4 = new Integer[10];
		list4[0] = 100;
		list4[1] = 1000;
		printArray(list3);
		printArray(list4);
		
	}
	public static <T> void printArray(T [] array) {
		for(T element : array) {
			if(element != null) {
				System.out.println(element);
			}
		}
	}

}

class Array<T> {
	private T list[];
	
	public void setList(T []list){ 
		this.list= list;
	}
	public T[] getList() {
		return list;
	}
	@SuppressWarnings("unchecked")
	public Array(int size) {
		list = (T[]) new Object[size];
	}
	public void set(int index, T date) {
		if(index >= list.length) {
			return;
		}
		list[index] = date;
	}
	public T get(int index) {
		if(index >= list.length || index < 0) {
			return null;
		}
		return list[index];
	}
	public void print() {
		for(int i = 0;i<list.length;i++) {
			if(list[i]!=null) {
				System.out.println(list[i]);
			}
		}
	}
}

class Test<A, B>{
	private A data1;
	private B data2;
	public A getData1() {
		return data1;
	}
	public void setData1(A data1) {
		this.data1 = data1;
	}
	public B getData2() {
		return data2;
	}
	public void setData2(B data2) {
		this.data2 = data2;
	}
	
}