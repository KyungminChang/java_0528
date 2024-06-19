package day06;

import java.util.Scanner;

public class ArrayEx07 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int min = 1, max = 100, select;
        int maxGames = 5;
        int gameCount = 0;
        int[] records = new int[maxGames];
        int recordIndex = 0;

        do {
            System.out.println("메뉴");
            System.out.println("1. 플레이");
            System.out.println("2. 기록확인");
            System.out.println("3. 종료");
            select = scan.nextInt();

            if (select == 1) {
                if (gameCount < maxGames) {
                    gameCount++;
                    int count = 0; // 한 게임 플레이에서 맞춘 횟수를 초기화
                    int[] randomNumbers = new int[5];

                    // 5개의 랜덤 숫자 생성
                    for (int i = 0; i < 5; i++) {
                        randomNumbers[i] = (int) (Math.random() * (max - min + 1) + min);
                    }

                    // 5개의 숫자를 맞추는 게임 시작
                    for (int i = 0; i < 5; i++) {
                        System.out.println((i + 1) + "번째 숫자를 맞춰보세요!");
                        int insert = scan.nextInt();
                        while (randomNumbers[i] != insert) {
                            if (randomNumbers[i] < insert) {
                                System.out.println("DOWN!");
                            } else {
                                System.out.println("UP!");
                            }
                            System.out.print("다시 입력 : ");
                            insert = scan.nextInt();
                        }
                        System.out.println("정답입니다!");
                        count++;
                        System.out.println("맞춘 횟수는 " + count + "회 입니다.");
                    }

                    // 기록 등록
                    if (recordIndex < maxGames) {
                        records[recordIndex++] = count;
                    } else {
                        // 기록 배열이 꽉 찼을 때는 가장 오래된 기록을 밀어내고 새로운 기록을 추가
                        for (int i = 1; i < records.length; i++) {
                            records[i - 1] = records[i];
                        }
                        records[records.length - 1] = count;
                    }

                } else {
                    System.out.println("최대 게임 횟수에 도달했습니다. 기록을 확인하거나 프로그램을 종료해주세요.");
                }
            } else if (select == 2) {
                System.out.println("기록확인");
                for (int i = 0; i < recordIndex; i++) {
                    System.out.println((i + 1) + "번째 기록: " + records[i] + "회.");
                }
                if (recordIndex == 0) {
                    System.out.println("기록이 없습니다.");
                }
            } else if (select == 3) {
                System.out.println("프로그램을 종료합니다.");
            } else {
                System.out.println("잘못된 메뉴 선택입니다.");
            }
        } while (select != 3);

        scan.close();
    }
}