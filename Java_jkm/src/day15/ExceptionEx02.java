package day15;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "2024-06-14";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date;
		
		try {
			//아래 코드에서 ParseException이 발생할 수 있고, ParseException은 RuntimeException이 아니기 때문에
			//반드시 예외처리를 해야 함.
			date = format.parse(str);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("문자열이 날짜 형식이 아닙니다.");
		}
	}

}
