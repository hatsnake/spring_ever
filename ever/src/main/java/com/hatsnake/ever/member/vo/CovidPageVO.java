package com.hatsnake.ever.member.vo;

public class CovidPageVO {
	private String numofrows;
	private String pageno;
	private String totalcount;
	private int totalPageCount;
	private int startPage;
	private int endPage;
	
	public CovidPageVO() {
		
	}

	public CovidPageVO(String numofrows, String pageno, String totalcount, int totalPageCount, int startPage,
			int endPage) {
		this.numofrows = numofrows;
		this.pageno = pageno;
		this.totalcount = totalcount;
		this.totalPageCount = totalPageCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public String getNumofrows() {
		return numofrows;
	}

	public void setNumofrows(String numofrows) {
		this.numofrows = numofrows;
	}

	public String getPageno() {
		return pageno;
	}

	public void setPageno(String pageno) {
		this.pageno = pageno;
	}

	public String getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "CovidPageVO [numofrows=" + numofrows + ", pageno=" + pageno + ", totalcount=" + totalcount
				+ ", totalPageCount=" + totalPageCount + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
}
