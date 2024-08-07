package day24;

public class Ex08 {

	public static void main(String[] args) {
		/**좌표 10, 20을 이용하여 객체를 생성했는데, 0,0으로 출력이 됐다
		 * 원인 : 전달하는 필드값이 초기생성자의 초기값으로 생성
		 * 해결방법 this를 사용해서 메소드의 매개변수와 입력 변수를 구분:
		 */
		 
		Point p1 = new Point(10,20);
		p1.print();
		/**기본 생성자를 이용하여 객체를 생성하려고 했는데 에러가 발생
		 * 원인 : 초기 값을 설정할 자료형을 입력하지 않음
		 * 해결방법 : 자료형을 지정
		 */
		Point p2 = new Point();
		p2.print();

	}

}

class Point {
	private int x,y;
	public Point(int x, int y) {
		x= x;
		y= y;
	}
	public Point() {}
	public void print() {
		System.out.println("(" + x + ", " + y + ")");
	}
}