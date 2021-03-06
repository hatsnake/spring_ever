package com.hatsnake.ever.article.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class CommentVO {
	private int cno;
	private int ano;
	private int pcno;
	private String ccontent;
	private String cwriter;
	private Date cinsertdate;
	private String cinsertip;
	private String cinsertid;
	private Date cupdatedate;
	private String cupdateip;
	private String cupdateid;
	private String cdeleteyn;
	private Date cdeletedate;
	private String cdeleteip;
	private String cdeleteid;
	private int commentlevel;
	
	public CommentVO() {
		
	}

	public CommentVO(int cno, int ano, int pcno, String ccontent, 
					String cwriter, Date cinsertdate, String cinsertip, String cinsertid, 
					Date cupdatedate, String cupdateip, String cupdateid, String cdeleteyn, 
					Date cdeletedate, String cdeleteip, String cdeleteid, int commentlevel) {
		this.cno = cno;
		this.ano = ano;
		this.pcno = pcno;
		this.ccontent = ccontent;
		this.cwriter = cwriter;
		this.cinsertdate = cinsertdate;
		this.cinsertip = cinsertip;
		this.cinsertid = cinsertid;
		this.cupdatedate = cupdatedate;
		this.cupdateip = cupdateip;
		this.cupdateid = cupdateid;
		this.cdeleteyn = cdeleteyn;
		this.cdeletedate = cdeletedate;
		this.cdeleteip = cdeleteip;
		this.cdeleteid = cdeleteid;
		this.commentlevel = commentlevel;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPcno() {
		return pcno;
	}

	public void setPcno(int pcno) {
		this.pcno = pcno;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCwriter() {
		return cwriter;
	}

	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}

	public Date getCinsertdate() {
		return cinsertdate;
	}

	public void setCinsertdate(Date cinsertdate) {
		this.cinsertdate = cinsertdate;
	}

	public String getCinsertip() {
		return cinsertip;
	}

	public void setCinsertip(String cinsertip) {
		this.cinsertip = cinsertip;
	}

	public String getCinsertid() {
		return cinsertid;
	}

	public void setCinsertid(String cinsertid) {
		this.cinsertid = cinsertid;
	}

	public Date getCupdatedate() {
		return cupdatedate;
	}

	public void setCupdatedate(Date cupdatedate) {
		this.cupdatedate = cupdatedate;
	}

	public String getCupdateip() {
		return cupdateip;
	}

	public void setCupdateip(String cupdateip) {
		this.cupdateip = cupdateip;
	}

	public String getCupdateid() {
		return cupdateid;
	}

	public void setCupdateid(String cupdateid) {
		this.cupdateid = cupdateid;
	}

	public String getCdeleteyn() {
		return cdeleteyn;
	}

	public void setCdeleteyn(String cdeleteyn) {
		this.cdeleteyn = cdeleteyn;
	}

	public Date getCdeletedate() {
		return cdeletedate;
	}

	public void setCdeletedate(Date cdeletedate) {
		this.cdeletedate = cdeletedate;
	}

	public String getCdeleteip() {
		return cdeleteip;
	}

	public void setCdeleteip(String cdeleteip) {
		this.cdeleteip = cdeleteip;
	}

	public String getCdeleteid() {
		return cdeleteid;
	}

	public void setCdeleteid(String cdeleteid) {
		this.cdeleteid = cdeleteid;
	}

	public int getCommentlevel() {
		return commentlevel;
	}

	public void setCommentlevel(int commentlevel) {
		this.commentlevel = commentlevel;
	}

	@Override
	public String toString() {
		return "CommentVO [cno=" + cno + ", ano=" + ano + ", pcno=" + pcno + ", ccontent=" + ccontent + ", cwriter="
				+ cwriter + ", cinsertdate=" + cinsertdate + ", cinsertip=" + cinsertip + ", cinsertid=" + cinsertid
				+ ", cupdatedate=" + cupdatedate + ", cupdateip=" + cupdateip + ", cupdateid=" + cupdateid
				+ ", cdeleteyn=" + cdeleteyn + ", cdeletedate=" + cdeletedate + ", cdeleteip=" + cdeleteip
				+ ", cdeleteid=" + cdeleteid + ", commentlevel=" + commentlevel + "]";
	}
	
}
