package day18.homwork;

	/* 일정을 관리하는 프로그램을 작성하세요.
	-------------------------------
	쉬운 버전 : 한 사람의 일정을 관리하는 프로그램
	===================================
	메뉴
	1. 일정 추가
	2. 일정 수정
	3. 일정 삭제
	4. 일정 확인
	5. 프로그램 종료
	메뉴 선택 : 1
	===================================
	날짜(yyyy-MM-dd hh:mm) : 2024-06-21 17:50
	일정 : 퇴근
	상세 : 없음
	===================================
	일정이 추가되었습니다.
	===================================
	메뉴
	1. 일정 추가
	2. 일정 수정
	3. 일정 삭제
	4. 일정 확인
	5. 프로그램 종료
	메뉴 선택 : 2
	===================================
	날짜(yyyy-MM-dd) : 2024-06-21
	===================================
	1. 2024-06-21 일정 리스트
	===================================
	수정할 일정 선택 : 1
	날짜(yyyy-MM-dd) : 2024-06-21 17:51
	일정 : 퇴근
	상세 : 없음
	===================================
	수정이 완료 되었습니다.
	===================================
	메뉴
	1. 일정 추가
	2. 일정 수정
	3. 일정 삭제
	4. 일정 확인
	5. 프로그램 종료
	메뉴 선택 : 3
	===================================
	날짜(yyyy-MM-dd) : 2024-06-21
	===================================
	1. 2024-06-21 일정 리스트
	===================================
	삭제할 일정 선택 : 1
	===================================
	삭제 되었습니다.
	===================================
	메뉴
	1. 일정 추가
	2. 일정 수정
	3. 일정 삭제
	4. 일정 확인
	5. 프로그램 종료
	메뉴 선택 : 4
	===================================
	날짜(yyyy-MM-dd) : 2024-06-21
	===================================
	1. 2024-06-21 일정 리스트
	===================================
	1. 2024-06-21 17:50 퇴근 없음
	===================================
	메뉴로 가시려면 엔터를 입력하세요.
	===================================
	메뉴
	1. 일정 추가
	2. 일정 수정
	3. 일정 삭제
	4. 일정 확인
	5. 프로그램 종료
	메뉴 선택 : 5
	===================================
	프로그램을 종료합니다.
	===================================
	*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Schedule {
    private LocalDateTime date;
    private String title;
    private String detail;

    public Schedule(LocalDateTime date, String title, String detail) {
        this.date = date;
        this.title = title;
        this.detail = detail;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + " " + title + " " + detail;
    }
}

public class ScheduleManager {
    private List<Schedule> schedules;
    private Scanner scanner;
    private DateTimeFormatter dateFormatter;

    public ScheduleManager() {
        schedules = new ArrayList<>();
        scanner = new Scanner(System.in);
        dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    public void printMenu() {
        System.out.println("===================================");
        System.out.println("메뉴");
        System.out.println("1. 일정 추가");
        System.out.println("2. 일정 수정");
        System.out.println("3. 일정 삭제");
        System.out.println("4. 일정 확인");
        System.out.println("5. 프로그램 종료");
        System.out.print("메뉴 선택 : ");
    }

    public void run() {
        int menu;
        do {
            printMenu();
            menu = Integer.parseInt(scanner.nextLine());

            switch (menu) {
                case 1:
                    addSchedule();
                    break;
                case 2:
                    updateSchedule();
                    break;
                case 3:
                    deleteSchedule();
                    break;
                case 4:
                    viewSchedules();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
        } while (menu != 5);
    }

    private void addSchedule() {
        System.out.println("===================================");
        System.out.print("날짜(yyyy-MM-dd HH:mm) : ");
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine(), dateFormatter);
        System.out.print("일정 : ");
        String title = scanner.nextLine();
        System.out.print("상세 : ");
        String detail = scanner.nextLine();

        schedules.add(new Schedule(date, title, detail));
        System.out.println("===================================");
        System.out.println("일정이 추가되었습니다.");
    }

    private void updateSchedule() {
        System.out.println("===================================");
        System.out.print("날짜(yyyy-MM-dd) : ");
        String dateStr = scanner.nextLine();
        LocalDateTime date = LocalDateTime.parse(dateStr + " 00:00", dateFormatter);

        List<Schedule> daySchedules = getSchedulesByDate(date.toLocalDate().toString());

        if (daySchedules.isEmpty()) {
            System.out.println("해당 날짜에 일정이 없습니다.");
            return;
        }

        printSchedules(daySchedules);
        System.out.print("수정할 일정 선택 : ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= daySchedules.size()) {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        Schedule scheduleToUpdate = daySchedules.get(index);

        System.out.print("날짜(yyyy-MM-dd HH:mm) : ");
        LocalDateTime newDate = LocalDateTime.parse(scanner.nextLine(), dateFormatter);
        System.out.print("일정 : ");
        String newTitle = scanner.nextLine();
        System.out.print("상세 : ");
        String newDetail = scanner.nextLine();

        scheduleToUpdate.setDate(newDate);
        scheduleToUpdate.setTitle(newTitle);
        scheduleToUpdate.setDetail(newDetail);

        System.out.println("===================================");
        System.out.println("수정이 완료되었습니다.");
    }

    private void deleteSchedule() {
        System.out.println("===================================");
        System.out.print("날짜(yyyy-MM-dd) : ");
        String dateStr = scanner.nextLine();
        LocalDateTime date = LocalDateTime.parse(dateStr + " 00:00", dateFormatter);

        List<Schedule> daySchedules = getSchedulesByDate(date.toLocalDate().toString());

        if (daySchedules.isEmpty()) {
            System.out.println("해당 날짜에 일정이 없습니다.");
            return;
        }

        printSchedules(daySchedules);
        System.out.print("삭제할 일정 선택 : ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index < 0 || index >= daySchedules.size()) {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        schedules.remove(daySchedules.get(index));
        System.out.println("===================================");
        System.out.println("삭제되었습니다.");
    }

    private void viewSchedules() {
        System.out.println("===================================");
        System.out.print("날짜(yyyy-MM-dd) : ");
        String dateStr = scanner.nextLine();
        LocalDateTime date = LocalDateTime.parse(dateStr + " 00:00", dateFormatter);

        List<Schedule> daySchedules = getSchedulesByDate(date.toLocalDate().toString());

        if (daySchedules.isEmpty()) {
            System.out.println("해당 날짜에 일정이 없습니다.");
            return;
        }

        printSchedules(daySchedules);
        System.out.println("===================================");
        System.out.println("메뉴로 가시려면 엔터를 입력하세요.");
        scanner.nextLine();
    }

    private List<Schedule> getSchedulesByDate(String date) {
        List<Schedule> result = new ArrayList<>();
        for (Schedule schedule : schedules) {
            if (schedule.getDate().toLocalDate().toString().equals(date)) {
                result.add(schedule);
            }
        }
        return result;
    }

    private void printSchedules(List<Schedule> daySchedules) {
        System.out.println("===================================");
        System.out.println(daySchedules.get(0).getDate().toLocalDate().toString() + " 일정 리스트");
        System.out.println("===================================");
        for (int i = 0; i < daySchedules.size(); i++) {
            System.out.println((i + 1) + ". " + daySchedules.get(i).toString());
        }
    }

    public static void main(String[] args) {
        ScheduleManager manager = new ScheduleManager();
        manager.run();
    }
}


