package day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ex03 {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* UP DOWN 게임에 기록을 저장하는 기능을 추가
		 * - 최대 5등까지 저장하며, 먼저 등록된 순으로 저장
		 * - 아이디를 입력받아 저장
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록 확인
		 * 3. 종료
		 * 메뉴 선택 :
		 */
		int menu;
		Map<String, Integer> map = new HashMap<String, Integer>();
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu, map);
			
		}while(menu!=3);
	}


	private static void runMenu(int menu, Map<String, Integer> map) {
		
		switch(menu) {
		case 1 : 
			int count = play();
			record(map, count);
			break;
			
		case 2 :
			printRecord(map);
			break;
		case 3 :
			System.out.println("종료");
			break;
				
		default : 
			System.out.println("잘못된 선택입니다");
			break;
		}
		
	}
	private static void printRecord(Map<String, Integer> map) {
		//기록이 없으면 등록된 기록이 없습니다 라고 출력하고 종료
		if(map.size() == 0)
		{
			System.out.println("등록된 기록이 없습니다");
			return;
		}
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String id=it.next();
			Integer count =map.get(id);
			System.out.println(id + " " + count + "회");
		}
		
	}


	private static void record(Map<String, Integer> map, int count) {
		//아이디를 입력 받고
		//아이디와 횟수를 이용해서 객체를 생성
		//리스트에 생성된 객체를 추가.
		//Collections.sort를 이용해서 정렬
		//종료
		//5등 기록과 내 기록을 비교해서 내 기록이 좋으면 
		//아이디와 횟수를 이용해서 객체를 생성
		//5등 위치에 내 기록을 저장
		final int MAX_RECORD_COUNT = 5;
        if (map.size() < MAX_RECORD_COUNT) {
        	System.out.print("아이디를 입력하세요: ");
            String id = scan.next();
            //맵에 아이디와 횟수를 추가하는데 기존 기록이 있는 경우 더 좋ㅇ느 기록으로 저장
            recordUser(map, id, count);
            map.put(id, count);
            return;
        } 
        
        String deleteId = checkRecord(map, count);
        if (deleteId != null)
        {
        	System.out.print("아이디를 입력하세요: ");
            String id = scan.next();
            if (!contains(map, id))
            {
                map.remove(deleteId);
            }
            recordUser(map,id,count);
        }
        
	 }
				

	private static boolean contains(Map<String, Integer> map, String id) {
		
		return map.get(id) != null;
	}


	private static String checkRecord(Map<String, Integer> map, int count) {
		Iterator<String> it = map.keySet().iterator();
		String deleteId = null;
		int maxCount = 0;
		while(it.hasNext()) {
			String id = it.next();
			Integer recordCount = map.get(id);
			//현재 기록이 저장된 기록보다 좋고 저장된 기록이 삭제할 기록보다 크면
			if(count < recordCount && maxCount < recordCount) {
				maxCount = recordCount;
				deleteId = id;
			}
		}
		return deleteId;
	}


	private static void recordUser(Map<String, Integer> map, String id, int count) {
		Integer oldCount = map.get(id);
		if(oldCount == null || count < oldCount) {
			map.put(id, count);
		}
	}


	private static int play() {
		int min =1, max = 100;
		int random = Ex01.random(min, max);
		System.out.println(random);
		int num, count = 0;
		do {
			System.out.print("숫자를 입력하세요 : ");
			num = scan.nextInt();
			Ex01.printResult(random, num);
			count++;
			}while(num != random);
		return count;
			
	}


	private static void printMenu() {
		System.out.print("메뉴 \n"+"1.플레이 \r\n"
				 + "2.기록 확인 \r\n"
				  + "3.종료 \r\n"
				   + "메뉴 선택 : ");
	}
}

