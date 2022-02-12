package com.hatsnake.ever.article.vo;

public class ArticleLikeVO {
	private int lno;
	private int ano;
	private int mno;
	
	public ArticleLikeVO() {
		
	}
	
	public ArticleLikeVO(int lno, int ano, int mno) {
		this.lno = lno;
		this.ano = ano;
		this.mno = mno;
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

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "ArticleLikeVO [lno=" + lno + ", ano=" + ano + ", mno=" + mno + "]";
	}

}
