package day15;

import java.util.HashSet;
import java.util.Scanner;

public class Ex04 {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		/*1~45 사이의 중복되지 않은 6개의 번호와 1개의 보너스 번호를 랜덤으로 생성하고,
		 * 사용자가 번호를 6개 입력해서 몇등인지 맞추는 로또 예제
		 */
		//로또 번호와 보너스 번호를 생성
		//사용자가 6개의 번호를 입력
		//입력한 번호를 이용하여 당첨 등수를 출력
		HashSet<Integer> lotto = new HashSet<Integer>();
		int min = 1, max = 45;
		
		
		while(lotto.size()<6) {
			int r = (int)(Math.random()*(max-min+1)+min);
			lotto.add(r);
		}
		int bonus;
		do {
			bonus = (int)(Math.random()*(max-min+1)+min);
		}while(lotto.contains(bonus));
		System.out.println(lotto + " : " + bonus);
		HashSet<Integer> user = new HashSet<Integer>();
		System.out.print("번호 입력(1~45 사이의 중복되지 않은 수 6개)");
		while(user.size() < 6) {
			user.add(scan.nextInt());
		}
		int count = 0;
        for (int num : user) {
            if (lotto.contains(num)) {
            	count++;
            }
        }
        switch(count) {
        case 1, 2: 
        	System.out.println("꽝 입니다.");
        	break;
        case 3: 
        	System.out.println("5등 입니다.");
        	break;
        case 4: 
        	System.out.println("4등 입니다.");
        	break;
        case 5: 
        	if(user.contains(bonus)){
        		System.out.println("2등 입니다.");
        	}
        else {
        		System.out.println("3등 입니다");
        	}
        	break;
    	case 6: 
    		System.out.println("1등 입니다.");
        	break;
        	
        }
		
	}

}
