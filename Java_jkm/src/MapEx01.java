import java.util.HashMap;

public class MapEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("admin", "admin123");
		System.out.println(map.put("admin", "admin123"));
		System.out.println(map);
		
		//remove(key) : 주어진 key과 일치하는 키가 있으면 삭제하고 value를 반환
		map.remove("admin");
		System.out.println(map);
		
		map.put("adb123", "def123");
		map.put("asdasd", "def123");
		
		System.out.println(map);
		/*containsKey(key) : 주어진 key와 일치하는 키가 있는지 없는지 반환*/
		System.out.println(map.containsKey("admin"));
	}

}
