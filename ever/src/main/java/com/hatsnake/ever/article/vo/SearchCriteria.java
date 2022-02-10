package com.hatsnake.ever.article.vo;

public class SearchCriteria extends Criteria {
	private String searchType = "";
	private String keyword = "";
	private String searchDate = "";
	
	public SearchCriteria() {
		
	}

	public SearchCriteria(String searchType, String keyword, String searchDate) {
		this.searchType = searchType;
		this.keyword = keyword;
		this.searchDate = searchDate;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + ", searchDate=" + searchDate + "]";
	}

}
