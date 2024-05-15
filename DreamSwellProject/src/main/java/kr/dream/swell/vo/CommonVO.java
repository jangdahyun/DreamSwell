package kr.dream.swell.vo;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.ToString;


/**
 * 글번호 현제페이지번호 페이지당 글수 페이지목록수를 받기 위한 공통변수들을 가지는 클래스
 * @version 1.00
 */
@Getter @ToString
public class CommonVO {
	private int p = 1;
	private int s = 10;
	private int b = 10;
	private int idx = 0;
	private Integer categoryNum;
	private String endDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String end;
	private String condition;
	private Integer userRef;
	// 검색어를 넣어놧는데 다른 곳으로 갈수 있음
	private String search;
	// 정렬기준
	private String orderCode;
	
	private int currentPage=1;
	private int sizeOfPage=20;
	private int sizeOfBlock=10;
	private String mode = "insert";
	
	
	
	public void setP(int p) {
		this.p = p;
		setCurrentPage(p);
	}
	public void setS(int s) {
		this.s =  s;
		setSizeOfPage(s);
	}
	public void setB(int b) {
		this.b = b;
		setSizeOfBlock(b);
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setSizeOfPage(int sizeOfPage) {
		this.sizeOfPage = sizeOfPage;
	}
	public void setSizeOfBlock(int sizeOfBlock) {
		this.sizeOfBlock = sizeOfBlock;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public void setCategoryNum(Integer categoryNum) {
		this.categoryNum = categoryNum;
	}
	public void setendDate(String endDate) {
		this.endDate = endDate;
	}
	public void setend(String end) {
		this.end = end;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public void setUserRef(Integer userRef) {
		this.userRef = userRef;
	}
}
