package com.hatsnake.ever.article.vo;

public class ArticleLikeVO {
	private int lno;
	private int ano;
	private String mid;
	
	public ArticleLikeVO() {
		
	}
	
	public ArticleLikeVO(int lno, int ano, String mid) {
		this.lno = lno;
		this.ano = ano;
		this.mid = mid;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "ArticleLikeVO [lno=" + lno + ", ano=" + ano + ", mid=" + mid + "]";
	}
	
}
