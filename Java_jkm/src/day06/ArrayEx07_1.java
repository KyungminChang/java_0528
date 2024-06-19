package day06;
import java.util.Arrays;
import java.util.Scanner;
public class ArrayEx07_1 {

	public static void main(String[] args) {

		 Scanner scan = new Scanner(System.in);
	        int min = 1, max = 100, menu, random, count = 0;
	        int [] record = new int[5];
	        int recordCount = 0;
	        //while(menu!=3) {
	           System.out.println("메뉴");
	           System.out.println("1. 플레이");
	           System.out.println("2. 기록확인");
	           System.out.println("3. 종료");
	           menu = scan.nextInt();
	        switch(menu) {
	        case 1:
	        	System.out.println("정수를 맞춰보세요!");
	        	random = (int) (Math.random() * (max - min + 1) + min);
                int insert = scan.nextInt();
                while (random != insert) {
                    if (random < insert) {
                        System.out.println("DOWN!");
                    } else {
                        System.out.println("UP!");
                    }
                    System.out.print("다시 입력 : ");
                    count ++;
                    insert = scan.nextInt();
                }
                System.out.println("정답입니다!");
                System.out.println(count + "회에 맞추셨습니다.");
                
                
                if(recordCount < record.length)
                {
                	record[recordCount++] = count;
                }
                else if(record[recordCount -1] >count)
                {
                	record[recordCount-1]=count;
                }
                 Arrays.sort(record, 0, recordCount);
                 System.out.print(Arrays.toString(record));
                
                
	        	break;
	        case 2: 
	        	if(recordCount == 0) {
	        		System.out.println("등록된 기록이 없습니다.");
	        		break;
	        	}
	        	for(int i=0;i<recordCount;i++) {
	        		System.out.println(i+1 + ". " + record[i] + "회");
	        	}
	  
	        	
	        	break;
	        case 3:
	        	System.out.println("프로그램을 종료합니다.");
	        	break;
	        default : 
	        	System.out.println("잘못된 메뉴입니다.");
	        }
	//}
	        }
}
	   
	


