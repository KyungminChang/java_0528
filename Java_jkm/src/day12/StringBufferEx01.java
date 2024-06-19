package day12;

public class StringBufferEx01 {

	public static void main(String[] args) {
		// String과 차이는 String은 수정이 아니라 교체, StringBuffer는 수정
		// 프로그램 내에서 문자열 수정이 자주 일어난다. => StringBuffer가 좋음
		
		StringBuffer sb = new StringBuffer("Hello word");
		//append(문자열) : 문자열을 제일 뒤에 추가
		sb.append("!");
		System.out.println(sb);
		sb.insert(0, "\"");
		sb.append("\"");
		System.out.println(sb);
		sb.delete(7, sb.length()-1);
		System.out.println(sb);
		
	}

}
