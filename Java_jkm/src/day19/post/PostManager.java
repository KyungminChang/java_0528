package day19.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class PostManager implements Program {
	private static Scanner scan = new Scanner(System.in);
	private static List<Post> list = new ArrayList<Post>();
	private final static int INSERT = 1;
	private final static int UPDATE = 2;
	private final static int DELETE = 3;
	private final static int SEARCH = 4;
	private final static int EXIT = 5;
	int menu = EXIT+1;
	
	@SuppressWarnings("unused")
	private String fileName = "src/day19/post/data.txt";
	
	@Override
	public void printMenu() {
		System.out.print("메뉴\r\n"
				+"1.게시글 등록\r\n"
				+"2.게시글 수정\r\n"
				+"3.게시글 삭제\r\n"
				+"4.게시글 조회\r\n"
				+"5.프로그램 종료\r\n"
				+"메뉴 선택: ");
	}
	@Override
	public void save(String fileName) {
		
	}
	@Override
	public void load(String fileName) {
		
	}
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insertPost();
			break;
		case UPDATE:
			updatePost();
			break;
		case DELETE:
			deletePost();
			break;
		case SEARCH:
			searchPost();
			break;
		case EXIT:
			exit();
			break;
		default : 
			System.out.println("잘못된 메뉴 선택입니다.");
			break;
			}
	}
	private void exit() {
		printBar();
		System.out.println("프로그램을 종료합니다.");
	}
	@Override
	public void run() {
		load(null);
		do {
			printMenu();
			menu = scan.nextInt();
			printBar();
			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외가 발생했습니다.");
				e.printStackTrace();
			}
		}while(menu !=EXIT);
		
		save(null);
	}
	
	
	private static void insertPost() {
		//제목, 내용, 아이디, 비밀번호를 입력받아 게시글 객체를 생성
		Post post = inputPost();
		//생성된 객체를 리스트에 추가
		list.add(post);
		printBar();
		System.out.println(post.getNum() + "번 게시글이 등록 되었습니다.");
	}
	private static Post inputPost() {
		scan.nextLine();//공백 처리
		System.out.print("게시글 등록 제목 : ");
		String tilte = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		System.out.print("작성자 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String pw = scan.next();
		return new Post(tilte, contents, id, pw);
	}
	private static void updatePost() {

		printBar();
		System.out.print("수정할 게시글 번호 : ");
		int num = scan.nextInt();
		//같으면 새 제목과 내용을 입력 받음
		Post post = selectPost(num);
		if(post == null) {
			return;
		}
		System.out.println("새로운 제목과 내용을 입력하세요.");
		scan.nextLine();//공백 처리
		System.out.print("제목 : ");
		String newTilte = scan.nextLine();
		System.out.print("내용 : ");
		String newContents = scan.nextLine();
		//가져온 객체의 제목과 내용을 입력받은 제목과 내용으로 수정
		post.update(newTilte, newContents);
		//안내문구 출력
		printBar();
		System.out.println(post.getNum() + "번 게시글이 수정되었습니다.");
	}

	private static void deletePost() {
		printBar();
		System.out.print("삭제할 게시글 번호 : ");
		int num = scan.nextInt();
		//입력한 게시글 번호를 이용하여 게시글 객체를 생성
		Post post = new Post(num);		
		//리스트에서 생성한 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(post);
		System.out.println(index +1);
		//일치하는 객체가 없으면 (가져온 번지가 0보다 작으면) 알림문구 출력 후 종료
		if(index<0) {
			printBar();
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		//아이디, 비번을 입력 받음
		System.out.print("ID : ");
		String id = scan.next();
		System.out.print("PW : ");
		String pw = scan.next();
		//가져온 객체의 아이디와 비번이 입력받은 아이디와 비번과 같은지 확인해서
		//같지 않으면 안내문구 출력 후 종료
		post = list.get(index);
		if(!post.checkWriter(id, pw)) {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
			return;
		}
		//같으면 새 제목과 내용을 입력 받음
		list.remove(index);
		System.out.println(post.getNum() + "번 게시글이 삭제되었습니다.");
	}
	/* List<Post> searchList = new ArrayList<>();
    for (Post post : list) {
        if (post.getTitle().contains(search) || post.getContents().contains(search)) {
            searchList.add(post);
        }
    }
    
    // 게시글 리스트가 비어있으면 안내문구 출력 후 종료
    if (searchList.isEmpty()) {
        printBar();
        System.out.println("검색된 게시글이 없습니다.");
        return;
    }
    
    // 가져온 게시글 리스트를 출력
    printBar();
    for (int i = 0; i < searchList.size(); i++) {
        System.out.println((i + 1) + ". " + searchList.get(i));
    }
    
    // 게시글을 확인할건지 선택
    System.out.print("게시글을 확인하시겠습니까? (Y/N) : ");
    String confirm = scan.next().trim().toUpperCase();
    if (!confirm.equals("Y")) {
        return;
    }
    
    // 확인하면 게시글 번호를 입력
    System.out.print("확인할 게시글 번호 : ");
    int postIndex = scan.nextInt() - 1;
    
    // 입력받은 게시글 번호로 객체를 생성
    if (postIndex < 0 || postIndex >= searchList.size()) {
        printBar();
        System.out.println("잘못된 번호입니다.");
        return;
    }
    
    // 검색 리스트에서 생성된 객체와 일치하는 번지를 확인해서 번지가 유효하지 않으면 안내문구 출력 후 종료
    Post selectedPost = searchList.get(postIndex);
    
    // 유효하면 번지에 있는 게시글을 가져오고
    // 가져온 게시글을 출력
    printBar();
    System.out.println(selectedPost);
    
    // 메뉴로 돌아가려면...문구 출력 후 
    // 엔터를 입력 받도록 처리
    printBar();
    System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
    scan.nextLine(); // 버퍼 비우기
    scan.nextLine(); // 엔터 입력 받기*/
	private static void searchPost() {
		System.out.print("검색어를 입력하세요 : ");
	    scan.nextLine(); // 버퍼 비우기
	    String search = scan.nextLine();
	    List<Post> searchList = getSerchList(search);
	    // 게시글에서 검색어가 제목 또는 내용에 들어간 게시글 리스트를 가져옴
	    if(searchList.size() == 0) {
	    	System.out.println("검색어와 일치하는 게시글이 없습니다.");
	    }
	    printList(searchList);
	    printBar();
	    System.out.println("게시글 확인하겠습니까?(y/n)");
	    char ok = scan.next().charAt(0);
	    if(ok!='y') {
	    	return;
	    }
	    System.out.println("검색 결과 중 확인할 게시글 번호 :");
	    int num = scan.nextInt();
	    Post post = new Post(num);
	    int index = searchList.indexOf(post);
	    printBar();
	    if(index <0) {
	    	System.out.println("검색 결과에는 없는 게시글입니다.");
	    	return;
	    }
	    post = searchList.get(index);
	    post.print();
	    printBar();
	    System.out.println("메뉴로 돌아가려면 엔터를 입력하세요.");
	    scan.nextLine();
	    scan.nextLine();
	}

	private static void printList(List<Post> searchList) {
		for(Post post : searchList) {
			System.out.println(post);
		}
		
	}
	private static List<Post> getSerchList(String search) {
//		
//		return list.stream().filter(p->p.getTitle().contains(search)|| 
//				p.getContents().contains(search).collect(Collectors.toList());
		List<Post> searchList = new ArrayList<Post>();
		for(Post post : list) {
			//게시글의 제목 또는 내용에 검색어가 포함되어 있으면 검색 리스트에 추가
			String title = post.getTitle();
			String contents = post.getContents();
			if(title.contains(search) || 
					contents.contains(search)) {
				searchList.add(post);
			}
		}
		return searchList;
	}
	public static void printBar() {
		System.out.println("--------------------------------");
	}
	//게시글 번호가 주어지면 게시글을 가져오는 메소드(아이디, 비번)
	public static Post selectPost(int num) {
		Post post = new Post(num);	
		//리스트에서 생성한 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(post);
		System.out.println(index +1);
		//일치하는 객체가 없으면 (가져온 번지가 0보다 작으면) 알림문구 출력 후 종료
		if(index<0) {
			printBar();
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return null;
		}
		//아이디, 비번을 입력 받음
		System.out.print("ID : ");
		String id = scan.next();
		System.out.print("PW : ");
		String pw = scan.next();
		//가져온 객체의 아이디와 비번이 입력받은 아이디와 비번과 같은지 확인해서
		//같지 않으면 안내문구 출력 후 종료
		post = list.get(index);
		if(!post.checkWriter(id, pw)) {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
			return null;
		}
		return post;
	}
}

