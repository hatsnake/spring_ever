package com.hatsnake.ever.article.vo;

import java.util.Date;

public class ArticleVO {

	private int number;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private int bviewcnt;
	private int bcategoryno;
	private int bcategorynoref;
	private Date binsertdate;
	private String binsertip;
	private String binsertid;
	private Date bupdatedate;
	private String bupdateip;
	private String bupdateid;
	private String bdeleteyn;
	private String bdeleteip;
	private String bdeleteid;
	
	public ArticleVO() {
		
	}
	
	public ArticleVO(int number, String btitle, String bcontent, 
					 String bwriter, int bviewcnt, int bcategoryno,
					 int bcategorynoref, Date binsertdate, String binsertip, 
					 String binsertid, Date bupdatedate, String bupdateip, 
					 String bupdateid, String bdeleteyn, String bdeleteip, 
					 String bdeleteid) {
		this.number = number;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bviewcnt = bviewcnt;
		this.bcategoryno = bcategoryno;
		this.bcategorynoref = bcategorynoref;
		this.binsertdate = binsertdate;
		this.binsertip = binsertip;
		this.binsertid = binsertid;
		this.bupdatedate = bupdatedate;
		this.bupdateip = bupdateip;
		this.bupdateid = bupdateid;
		this.bdeleteyn = bdeleteyn;
		this.bdeleteip = bdeleteip;
		this.bdeleteid = bdeleteid;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public int getBviewcnt() {
		return bviewcnt;
	}

	public void setBviewcnt(int bviewcnt) {
		this.bviewcnt = bviewcnt;
	}

	public int getBcategoryno() {
		return bcategoryno;
	}

	public void setBcategoryno(int bcategoryno) {
		this.bcategoryno = bcategoryno;
	}

	public int getBcategorynoref() {
		return bcategorynoref;
	}

	public void setBcategorynoref(int bcategorynoref) {
		this.bcategorynoref = bcategorynoref;
	}

	public Date getBinsertdate() {
		return binsertdate;
	}

	public void setBinsertdate(Date binsertdate) {
		this.binsertdate = binsertdate;
	}

	public String getBinsertip() {
		return binsertip;
	}

	public void setBinsertip(String binsertip) {
		this.binsertip = binsertip;
	}

	public String getBinsertid() {
		return binsertid;
	}

	public void setBinsertid(String binsertid) {
		this.binsertid = binsertid;
	}

	public Date getBupdatedate() {
		return bupdatedate;
	}

	public void setBupdatedate(Date bupdatedate) {
		this.bupdatedate = bupdatedate;
	}

	public String getBupdateip() {
		return bupdateip;
	}

	public void setBupdateip(String bupdateip) {
		this.bupdateip = bupdateip;
	}

	public String getBupdateid() {
		return bupdateid;
	}

	public void setBupdateid(String bupdateid) {
		this.bupdateid = bupdateid;
	}

	public String getBdeleteyn() {
		return bdeleteyn;
	}

	public void setBdeleteyn(String bdeleteyn) {
		this.bdeleteyn = bdeleteyn;
	}

	public String getBdeleteip() {
		return bdeleteip;
	}

	public void setBdeleteip(String bdeleteip) {
		this.bdeleteip = bdeleteip;
	}

	public String getBdeleteid() {
		return bdeleteid;
	}

	public void setBdeleteid(String bdeleteid) {
		this.bdeleteid = bdeleteid;
	}

	@Override
	public String toString() {
		return "ArticleVO [number=" + number + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bviewcnt=" + bviewcnt + ", bcategoryno=" + bcategoryno + ", bcategorynoref=" + bcategorynoref
				+ ", binsertdate=" + binsertdate + ", binsertip=" + binsertip + ", binsertid=" + binsertid
				+ ", bupdatedate=" + bupdatedate + ", bupdateip=" + bupdateip + ", bupdateid=" + bupdateid
				+ ", bdeleteyn=" + bdeleteyn + ", bdeleteip=" + bdeleteip + ", bdeleteid=" + bdeleteid + "]";
	}
	
}
