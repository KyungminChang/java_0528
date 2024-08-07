package day24;

public class Ex09 {

	public static void main(String[] args) {
		PointA p1 = new PointA(10,20);
		p1.print();
		/*x 의 값을 100, y의 값을 200으로 수정하려했다.
		 * 원인 : x, y 값은 접근 제어자가 private이다 
		 * 해결방법: public 으로 바꾸거나 setter 활용
		 * */
		p1.setX(100);
		p1.setY(200);
		
		p1.print();
		/* 기본 생성자를 이용해서 객체를 생성하려 했다
		 * 원인 : 기본 생성자가 없어서. 생성자가 1개라도 있으면 기본 생성자가 자동으로 추가되지 않음
		 * 해결방법: 기본 생성자를 추가
		 * */
		PointA p2 = new PointA();
		p2.print();
	}

}
class PointA {
	private int x,y;
	public PointA(int x, int y) {
		this.x= x;
		this.y= y;
		
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public PointA() {}
	public void print() {
		System.out.println("(" + x + ", " + y + ")");
	}
}