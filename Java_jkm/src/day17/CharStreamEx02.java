
  package day17;
  
  import java.io.FileWriter; import java.io.IOException;
  
  public class CharStreamEx02 {
  
  public static void main(String[] args) { 
	  // TODO Auto-generated method stub
	  String fileName = "src/day17/charStream.txt";
	  String str =null;
	  try(FileWriter fw = new FileWriter(fileName)) {
		  str = "안녕하세요. 제 이름은 홍길동입니다. \n만나서 반갑습니다."; 
		  for(int i = 0; i<str.length(); i++) {
			  fw.write(str.charAt(i));
		  } 
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
}
 
