package com.hatsnake.ever.member.vo;

public class CovidVO {
	private String accdefrate;
	private String accexamcnt;
	private String deathcnt;
	private String decidecnt;
	private String createdt;
	private String seq;
	private String statedt;
	private String statetime;
	private String updatedt;
	
	public CovidVO() {
		
	}
	
	public CovidVO(String accdefrate, String accexamcnt, String deathcnt, 
				   String decidecnt, String createdt, String seq,
			       String statedt, String statetime, String updatedt) {
		this.accdefrate = accdefrate;
		this.accexamcnt = accexamcnt;
		this.deathcnt = deathcnt;
		this.decidecnt = decidecnt;
		this.createdt = createdt;
		this.seq = seq;
		this.statedt = statedt;
		this.statetime = statetime;
		this.updatedt = updatedt;
	}

	public String getAccdefrate() {
		return accdefrate;
	}

	public void setAccdefrate(String accdefrate) {
		this.accdefrate = accdefrate;
	}

	public String getAccexamcnt() {
		return accexamcnt;
	}

	public void setAccexamcnt(String accexamcnt) {
		this.accexamcnt = accexamcnt;
	}

	public String getDeathcnt() {
		return deathcnt;
	}

	public void setDeathcnt(String deathcnt) {
		this.deathcnt = deathcnt;
	}

	public String getDecidecnt() {
		return decidecnt;
	}

	public void setDecidecnt(String decidecnt) {
		this.decidecnt = decidecnt;
	}

	public String getCreatedt() {
		return createdt;
	}

	public void setCreatedt(String createdt) {
		this.createdt = createdt;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getStatedt() {
		return statedt;
	}

	public void setStatedt(String statedt) {
		this.statedt = statedt;
	}

	public String getStatetime() {
		return statetime;
	}

	public void setStatetime(String statetime) {
		this.statetime = statetime;
	}

	public String getUpdatedt() {
		return updatedt;
	}

	public void setUpdatedt(String updatedt) {
		this.updatedt = updatedt;
	}

	@Override
	public String toString() {
		return "CovidVO [accdefrate=" + accdefrate + ", accexamcnt=" + accexamcnt + ", deathcnt=" + deathcnt
				+ ", decidecnt=" + decidecnt + ", createdt=" + createdt + ", seq=" + seq + ", statedt=" + statedt
				+ ", statetime=" + statetime + ", updatedt=" + updatedt + "]";
	}
	
}
