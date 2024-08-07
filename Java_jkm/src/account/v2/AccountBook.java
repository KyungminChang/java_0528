package account.v2;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class AccountBook implements Serializable {

	private static final long serialVersionUID = 3440525402416053767L;
	private List<Item> list = new ArrayList<Item>();
	public static List<String> incomeCategoryList = Arrays.asList("월급", "용돈", "부수입");
	public static List<String> expensesCategoryList = Arrays.asList("교통비", "식비", "취미", "기타");
	private List<String> typeList = Arrays.asList("수입", "지출");
 	
 	public boolean checkItem;
	//내역 추가 메소드
	public boolean insert(Item item) {
		//Item item = new Item("2024-07-01", "수입", "월급", 10000000, "7월 월급");
		System.out.print("입력하세요 : ");
		
		//입력한 타입이 수입 또는 지출이 맞는지 확인
		if(!checkItem(item)) {
			return false;
		}
		list.add(item);
		return true;
	}
	
	//내역 수정 메소드
	public boolean update(Item oldItem, Item newItem) {
		try {
			if(!checkItem(newItem)) {
				return false;
			}
			oldItem.update(newItem);
			return true;
		}catch(ArrayIndexOutOfBoundsException e) {
			//잘못된 번지인 경우 수정할 수가 없어서 수정 실패를 리턴
			return false;
		}
	}
	/**
	 * item의 필드들이 유효한 값들로 되어 있는지 확인하는 메소드
	 * @param newItem 필드들이 유효한지 체크할 내역
	 * @throws 유효 여부
	 */
	private boolean checkItem(Item item) {
		if(!typeList.contains(item.getType())) {
			return false;
		}
		//카테고리가 타입 또는 지출에 맞는 카테고리인지 확인
		List<String> tmpList = item.getType().equals("수입")?incomeCategoryList : expensesCategoryList;
		if(!tmpList.contains(item.getCategory())) {
			return false;
		}
		if(item.getAmount() < 0) {
			return false;
		}
		return true;
	}

	//내역 삭제 메소드
	public boolean delete(Item oldItem) {
		 
		return list.remove(oldItem);
	}
	public void search(Predicate p) {
		
	}
	public void search(List<Item> list, Predicate<Item> p) {
		for(int i = 0; i<list.size();i++) {
			if(p.test(list.get(i))) {
				System.out.println(i+1+". " + list.get(i));
			}
		}
	}

	public List<Item> selectList(String date) throws ParseException {
		Item item = new Item(date, "", "", 0 , "");
		return list.stream().filter(i->i.equals(item)).collect(Collectors.toList());
	}


}
