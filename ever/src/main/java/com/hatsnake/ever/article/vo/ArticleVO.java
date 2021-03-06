package com.hatsnake.ever.article.vo;

import java.util.Date;

public class ArticleVO {

	private int ano;
	private String atitle;
	private String acontent;
	private int awriter;
	private int aviewcnt;
	private int acategoryno;
	private int acategorynoref;
	private Date ainsertdate;
	private String ainsertip;
	private int ainsertid;
	private Date aupdatedate;
	private String aupdateip;
	private String aupdateid;
	private String adeleteyn;
	private String adeleteip;
	private String adeleteid;
	
	public ArticleVO() {
		
	}

	public ArticleVO(int ano, String atitle, String acontent, int awriter, 
					 int aviewcnt, int acategoryno, int acategorynoref, Date ainsertdate, 
					 String ainsertip, int ainsertid, Date aupdatedate, String aupdateip, 
					 String aupdateid, String adeleteyn, String adeleteip, String adeleteid) {
		super();
		this.ano = ano;
		this.atitle = atitle;
		this.acontent = acontent;
		this.awriter = awriter;
		this.aviewcnt = aviewcnt;
		this.acategoryno = acategoryno;
		this.acategorynoref = acategorynoref;
		this.ainsertdate = ainsertdate;
		this.ainsertip = ainsertip;
		this.ainsertid = ainsertid;
		this.aupdatedate = aupdatedate;
		this.aupdateip = aupdateip;
		this.aupdateid = aupdateid;
		this.adeleteyn = adeleteyn;
		this.adeleteip = adeleteip;
		this.adeleteid = adeleteid;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public int getAwriter() {
		return awriter;
	}

	public void setAwriter(int awriter) {
		this.awriter = awriter;
	}

	public int getAviewcnt() {
		return aviewcnt;
	}

	public void setAviewcnt(int aviewcnt) {
		this.aviewcnt = aviewcnt;
	}

	public int getAcategoryno() {
		return acategoryno;
	}

	public void setAcategoryno(int acategoryno) {
		this.acategoryno = acategoryno;
	}

	public int getAcategorynoref() {
		return acategorynoref;
	}

	public void setAcategorynoref(int acategorynoref) {
		this.acategorynoref = acategorynoref;
	}

	public Date getAinsertdate() {
		return ainsertdate;
	}

	public void setAinsertdate(Date ainsertdate) {
		this.ainsertdate = ainsertdate;
	}

	public String getAinsertip() {
		return ainsertip;
	}

	public void setAinsertip(String ainsertip) {
		this.ainsertip = ainsertip;
	}

	public int getAinsertid() {
		return ainsertid;
	}

	public void setAinsertid(int ainsertid) {
		this.ainsertid = ainsertid;
	}

	public Date getAupdatedate() {
		return aupdatedate;
	}

	public void setAupdatedate(Date aupdatedate) {
		this.aupdatedate = aupdatedate;
	}

	public String getAupdateip() {
		return aupdateip;
	}

	public void setAupdateip(String aupdateip) {
		this.aupdateip = aupdateip;
	}

	public String getAupdateid() {
		return aupdateid;
	}

	public void setAupdateid(String aupdateid) {
		this.aupdateid = aupdateid;
	}

	public String getAdeleteyn() {
		return adeleteyn;
	}

	public void setAdeleteyn(String adeleteyn) {
		this.adeleteyn = adeleteyn;
	}

	public String getAdeleteip() {
		return adeleteip;
	}

	public void setAdeleteip(String adeleteip) {
		this.adeleteip = adeleteip;
	}

	public String getAdeleteid() {
		return adeleteid;
	}

	public void setAdeleteid(String adeleteid) {
		this.adeleteid = adeleteid;
	}

	@Override
	public String toString() {
		return "ArticleVO [ano=" + ano + ", atitle=" + atitle + ", acontent=" + acontent + ", awriter=" + awriter
				+ ", aviewcnt=" + aviewcnt + ", acategoryno=" + acategoryno + ", acategorynoref=" + acategorynoref
				+ ", ainsertdate=" + ainsertdate + ", ainsertip=" + ainsertip + ", ainsertid=" + ainsertid
				+ ", aupdatedate=" + aupdatedate + ", aupdateip=" + aupdateip + ", aupdateid=" + aupdateid
				+ ", adeleteyn=" + adeleteyn + ", adeleteip=" + adeleteip + ", adeleteid=" + adeleteid + "]";
	}
	
}
