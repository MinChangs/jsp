package kr.or.ddit.paging.model;

public class PageVo {
	private int page; //페이지 번호
	private int pageSize; //페이지당 건수
	public PageVo() {
		
	}
	
	public PageVo(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}


	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageVo [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	

}
