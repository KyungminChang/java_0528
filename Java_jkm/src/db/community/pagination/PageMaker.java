package db.community.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int startPage; //페이지네이션의 시작 번
	private int endPage; //페이지네이션의 마지막 번호
	private int totalCount; //전체 콘텐츠 수 => endPage 계산 때문
	private int displayPageNum; //한 페이지네이션의 최대 페이지 개수
	private boolean prev;// 이전 버튼 활성화
	private boolean next;// 다음 버튼 활성화
	private Criteria cri; // 현재 페이지 정보
	//시작페이지, 마지막 페이지, 이전 버튼 활성화 여부, 다음 버튼 활성화 여부를 계산하는 메소드
	public void calculate() {
		//마지막 페이지 번호를 계산 => 최대 페이지 번호
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum);
		
		startPage = endPage - displayPageNum + 1;
		// 마지막 페이지네이션에서 마지막 페이지 번호
		int lastEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		if(endPage > lastEndPage) {
			endPage = lastEndPage;
		}
		//이전 다음 버튼을 한 페이지네이션 단위로 이동
		/*
		prev = startPage == 1 ? false : true;
		next = endPage == lastEndPage ? false : true;
		*/
		//이전 다음을 한 페이지 단위로 이동
		prev = cri.getPage() == 1 ? false : true;
		next = cri.getPage() == lastEndPage ? false : true;
	}
	public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		calculate();
	}
	
	
}
