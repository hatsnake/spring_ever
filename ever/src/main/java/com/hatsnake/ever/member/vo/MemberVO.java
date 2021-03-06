package com.hatsnake.ever.member.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberVO {
	private int mno;
	private String mid;
	private String mpassword;
	private String mnickname;
	private String mname;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date mbirth;
	private String mimage;
	private String mgender;
	private String memail;
	private String mphone;
	private String mzip;
	private String maddr1;
	private String maddr2;
	private int mvisitedcount;
	private int mcommentcount;
	private int mboardcount;
	private String mauthid;
	private Date mvisiteddate;
	private Date minsertdate;
	private String minsertip;
	private Date mupdatedate;
	private String mupdateip;
	private String mupdateid;
	private String mdeleteyn;
	private Date mdeletedate;
	private String mdeleteid;
	
	public MemberVO() {
		
	}

	public MemberVO(int mno, String mid, String mpassword, String mnickname, String mname, Date mbirth, String mimage,
			String mgender, String memail, String mphone, String mzip, String maddr1, String maddr2, int mvisitedcount,
			int mcommentcount, int mboardcount, String mauthid, Date mvisiteddate, Date minsertdate, String minsertip,
			Date mupdatedate, String mupdateip, String mupdateid, String mdeleteyn, Date mdeletedate,
			String mdeleteid) {
		this.mno = mno;
		this.mid = mid;
		this.mpassword = mpassword;
		this.mnickname = mnickname;
		this.mname = mname;
		this.mbirth = mbirth;
		this.mimage = mimage;
		this.mgender = mgender;
		this.memail = memail;
		this.mphone = mphone;
		this.mzip = mzip;
		this.maddr1 = maddr1;
		this.maddr2 = maddr2;
		this.mvisitedcount = mvisitedcount;
		this.mcommentcount = mcommentcount;
		this.mboardcount = mboardcount;
		this.mauthid = mauthid;
		this.mvisiteddate = mvisiteddate;
		this.minsertdate = minsertdate;
		this.minsertip = minsertip;
		this.mupdatedate = mupdatedate;
		this.mupdateip = mupdateip;
		this.mupdateid = mupdateid;
		this.mdeleteyn = mdeleteyn;
		this.mdeletedate = mdeletedate;
		this.mdeleteid = mdeleteid;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}

	public String getMnickname() {
		return mnickname;
	}

	public void setMnickname(String mnickname) {
		this.mnickname = mnickname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Date getMbirth() {
		return mbirth;
	}

	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}

	public String getMimage() {
		return mimage;
	}

	public void setMimage(String mimage) {
		this.mimage = mimage;
	}

	public String getMgender() {
		return mgender;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMzip() {
		return mzip;
	}

	public void setMzip(String mzip) {
		this.mzip = mzip;
	}

	public String getMaddr1() {
		return maddr1;
	}

	public void setMaddr1(String maddr1) {
		this.maddr1 = maddr1;
	}

	public String getMaddr2() {
		return maddr2;
	}

	public void setMaddr2(String maddr2) {
		this.maddr2 = maddr2;
	}

	public int getMvisitedcount() {
		return mvisitedcount;
	}

	public void setMvisitedcount(int mvisitedcount) {
		this.mvisitedcount = mvisitedcount;
	}

	public int getMcommentcount() {
		return mcommentcount;
	}

	public void setMcommentcount(int mcommentcount) {
		this.mcommentcount = mcommentcount;
	}

	public int getMboardcount() {
		return mboardcount;
	}

	public void setMboardcount(int mboardcount) {
		this.mboardcount = mboardcount;
	}

	public String getMauthid() {
		return mauthid;
	}

	public void setMauthid(String mauthid) {
		this.mauthid = mauthid;
	}

	public Date getMinsertdate() {
		return minsertdate;
	}

	public void setMinsertdate(Date minsertdate) {
		this.minsertdate = minsertdate;
	}

	public String getMinsertip() {
		return minsertip;
	}

	public void setMinsertip(String minsertip) {
		this.minsertip = minsertip;
	}

	public Date getMupdatedate() {
		return mupdatedate;
	}

	public void setMupdatedate(Date mupdatedate) {
		this.mupdatedate = mupdatedate;
	}

	public String getMupdateip() {
		return mupdateip;
	}

	public void setMupdateip(String mupdateip) {
		this.mupdateip = mupdateip;
	}

	public String getMupdateid() {
		return mupdateid;
	}

	public void setMupdateid(String mupdateid) {
		this.mupdateid = mupdateid;
	}

	public String getMdeleteyn() {
		return mdeleteyn;
	}

	public void setMdeleteyn(String mdeleteyn) {
		this.mdeleteyn = mdeleteyn;
	}

	public Date getMdeletedate() {
		return mdeletedate;
	}

	public void setMdeletedate(Date mdeletedate) {
		this.mdeletedate = mdeletedate;
	}

	public String getMdeleteid() {
		return mdeleteid;
	}

	public void setMdeleteid(String mdeleteid) {
		this.mdeleteid = mdeleteid;
	}

	public Date getMvisiteddate() {
		return mvisiteddate;
	}

	public void setMvisiteddate(Date mvisiteddate) {
		this.mvisiteddate = mvisiteddate;
	}

	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", mid=" + mid + ", mpassword=" + mpassword + ", mnickname=" + mnickname
				+ ", mname=" + mname + ", mbirth=" + mbirth + ", mimage=" + mimage + ", mgender=" + mgender
				+ ", memail=" + memail + ", mphone=" + mphone + ", mzip=" + mzip + ", maddr1=" + maddr1 + ", maddr2="
				+ maddr2 + ", mvisitedcount=" + mvisitedcount + ", mcommentcount=" + mcommentcount + ", mboardcount="
				+ mboardcount + ", mauthid=" + mauthid + ", mvisiteddate=" + mvisiteddate + ", minsertdate="
				+ minsertdate + ", minsertip=" + minsertip + ", mupdatedate=" + mupdatedate + ", mupdateip=" + mupdateip
				+ ", mupdateid=" + mupdateid + ", mdeleteyn=" + mdeleteyn + ", mdeletedate=" + mdeletedate
				+ ", mdeleteid=" + mdeleteid + "]";
	}
	
}
