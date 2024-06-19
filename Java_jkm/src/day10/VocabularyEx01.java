package day10;

import java.util.Scanner;

public class VocabularyEx01 {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		int WORD_MAX = 2;
		Word [] list = new Word[WORD_MAX];
		int wordCount = 0;
		do{
			System.out.println("메뉴");
			System.out.println("1. 단어 등록");
			System.out.println("2. 단어 수정");
			System.out.println("3. 단어 검색");
			System.out.println("4. 단어 삭제");
			System.out.println("5. 종료");
			System.out.println("메뉴 선택 : ");
			
			menu = scan.nextInt();
			
			switch(menu)
			{
				case 1 :
					wordCount = insertWord(list, wordCount);
					if(wordCount == list.length) {
						list = expandWordList(list, list.length +10);
					}
					for(int i =0; i<wordCount;i++)
					{
						list[i].print();
					}
										
					break;
				
				case 2 : 
					// 단어 수정을 구현하기 위한 과정을 주석으로 작성. 같은 단어가 있는 경우
					//누구를 수정할지를 선택하는 부분을 고민해야 함.
					//수정할 단어를 입력
					//단어 리스트에 수정할 단어와 일치하는 단어들을 번호와 함께 출력
					//수정할 단어가 없으면 안내문구 출력 후 종료
					//수정할 단어를 선택
					//입력한 정보로 선택한 단어를 수정
					//단어 리스트 정렬
					updateWord(list, wordCount);
					break;
					
                case 3 :
                	searchWord(list, wordCount);
                	break;
                case 4 : 
                	//삭제할 단어를 입력
                	//삭제할 단어를 출력
                	deleteWord(list, wordCount);
                	
                	//올바른 선택이면 삭제
                	//아니면 잘못 선택했다고 알림
                	
                	//삭제하려는 번지 다음에 있는 단어들부터 
                	//앞으로 하나 씩 당기고 마지막 단어를 null로 만듦
                	
                	//deleteWord(list, wordCount);
                	break;
				case 5 : 
					System.out.println("프로그램 종료입니다.");
					break;
				default : 
					System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu !=5);
	}	
	public static void searchWord(Word[] list, int wordCount) {
		System.out.println("단어 : ");
    	String word = scan.next();
    	printSearchWord(list, wordCount, word);
	}
	/**기능 : list에 index 번지에 있는 단어가 word 인지 아닌지 알려주는 메소드
	 * @param list 단어 리스트
	 * @param word 검색할 단어
	 * @param index 해당 단어의 번지
	 * @return index 번지에 word가 있으면 true, 없으면 false*/
	public static boolean checkWord(Word[] list, String word, int index) {
		if(list.length <= index || index<0) {
			return false;
		}
		if(list[index] == null) {
			return false;
		}
		return list[index].getWord().equals(word);
	}

	public static Word inputWord() {
		System.out.print("단어 : ");
        String word = scan.next();
        System.out.print("품사 : ");
        String wordClass = scan.next();
        System.out.print("의미 : ");
        scan.nextLine();//공백 처리
        String meaning = scan.nextLine();
        Word tmp = new Word(word, wordClass, meaning);
		return tmp;
	}
	
	public static void wordSort(Word [] list, int wordCount) {
		for(int i=0;i<wordCount-1;i++) {
			for(int j=0;j<wordCount-1;j++) {
				if(list[j].getWord().compareTo(list[j+1].getWord())>0) {
					Word tmpWord = list[j];
					list[j] = list[j+1];
					list[j+1] = tmpWord;
				}
			}
		}
		for(int i=0;i<wordCount-1;i++) {
				list[i].print();
		}
	}
	
	public static int insertWord(Word [] list, int wordCount) {
		
		Word tmp = inputWord();
		list[wordCount] = tmp;
		wordCount++;
		wordSort(list, wordCount);
		System.out.println("------------------------------------------");
		System.out.println("단어 등록을 완료했습니다.");
		System.out.println("------------------------------------------");
		return wordCount ;
	}
	public static Word [] expandWordList(Word[] list, int size) {
		if(list.length >=size) {
			return list;
		}
		Word [] tmp = new Word[size];
		//list 0번지 부터 list.length를 tmp의 0번지부터 복붙
		System.arraycopy(list, 0, tmp, 0, list.length);
		return tmp;
	}
	public static void updateWord(Word[] list, int wordCount) {
		System.out.println("단어 : ");
		String word = scan.next();
		int count = 0;
		for(int i=0;i<wordCount;i++) {
			if(list[i].getWord().equals(word)){
				System.out.println(i+1+".");
				list[i].print();
				count++;
			}
		}
		if(count ==0) {
			System.out.println("수정할 단어가 없습니다.");
			return;
		}
		System.out.println("수정할 단어 번호 선택 : ");
		int num = scan.nextInt();
		boolean res = checkWord(list, word, num-1);
		if(res == false) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		Word tmp = inputWord();
		list[num-1].updateWord(tmp);
		list[num-1].print();
		wordSort(list, wordCount);
		System.out.println("--------------------");
		System.out.println("단어 수정을 완료했습니다.");
		System.out.println("--------------------");
		return;
	}
	/*단어 리스트에 단어가 있으면 해당 단어를 출력하고 없으면 없다고 출력하는 메소드
	 * @param list 단어 리스트
	 * @param word 단어
	 * @param wordCount 저장된 단어 수*/
	
	public static void printSearchWord(Word [] list, int wordCount, String word) {
		int count = 0;
		
		for(int i=0;i<wordCount;i++) {
			if(list[i].getWord().equals(word)){
				System.out.println(i+1+".");
				list[i].print();
				count++;
			}
		}
	}
	public static int deleteWordList(Word [] list, int wordCount, int index) {
		Word[] tmp = new Word[list.length];
    	System.arraycopy(list, 0, tmp, 0, wordCount);
    	if(wordCount - index !=0) {
    		System.arraycopy(tmp, index, list, index-1, wordCount-index);
    	}
    	wordCount --;
    	list[wordCount] = null;
    	
    	return wordCount;
	}
	public static void deleteWord(Word[] list, int wordCount) {
		System.out.println("단어 : ");
    	String word = scan.next();
    
    	printSearchWord(list, wordCount, word);
    	//삭제할 단어를 선택
    	int num = scan.nextInt();
    	if(!checkWord(list, word, num-1)) {
    		System.out.println("잘못된 번호를 선택했습니다.");
    		return;
    	}
    	wordCount = deleteWordList(list, wordCount, num-1);
    	System.out.println("삭제가 완료됐습니다.");
	}
	
}
	/*기능 : 단어를 출력하는 메소드*/

/*영어 단어를 관리하기 위한 Word 클래스를 만들고,
 * 필요한 멤버변수들을 선언해보세요.
 */
class Word {
	private String word, meaning, wordClass;
	//생성자

	public Word(String word, String wordClass, String meaning) {
		this.word = word;
		this.wordClass = wordClass;
		this.meaning = meaning;
	}
	public Word() {
		
	}
	//필요한 기능
	/**단어를 출력하는 메소드 
	 */
	public void print() { //class에서 공통으로 사용하는 메서드는 static 메서드로 사용
		System.out.println("---------------");
		System.out.println("단어 : " + word);
		System.out.println("품사 : " + wordClass);
		System.out.println("의미 : " + meaning);
		System.out.println("---------------");
		
	}
	
	public void updateWord(Word word) {
		this.word =word.word;
		this.wordClass = word.wordClass;
		this.meaning = word.meaning;
	}
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getWordClass() {
		return wordClass;
	}

	public void setWordClass(String wordClass) {
		this.wordClass = wordClass;
	}
}
