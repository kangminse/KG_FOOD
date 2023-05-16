package Board;

import java.util.Date;

class BoardDTO {
	private int bId, bScore;
	private String bnName, bAddr, bOpenTime, bDesc, bTel;
	private Date bRegDate;
	

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public int getbScore() {
		return bScore;
	}

	public void setbScore(int bScore) {
		this.bScore = bScore;
	}

	public String getBnName() {
		return bnName;
	}

	public void setBnName(String bnName) {
		this.bnName = bnName;
	}

	public String getbAddr() {
		return bAddr;
	}

	public void setbAddr(String bAddr) {
		this.bAddr = bAddr;
	}

	public String getbOpenTime() {
		return bOpenTime;
	}

	public void setbOpenTime(String bOenTime) {
		this.bOpenTime = bOenTime;
	}

	public String getbDesc() {
		return bDesc;
	}

	public void setbDesc(String bDesc) {
		this.bDesc = bDesc;
	}

	public String getbTel() {
		return bTel;
	}

	public void setbTel(String bTel) {
		this.bTel = bTel;
	}

	public Date getbRegDate() {
		return bRegDate;
	}

	public void setbRegDate(Date bRegDate) {
		this.bRegDate = bRegDate;
	}

	@Override
	public String toString() {
		return " 음식점 번호\t= " + getbId() +"\n 음식점 이름\t= " + getBnName() + "\n 가게설명\t\t= " + getbDesc() + "\n 영업시간\t\t= " + getbOpenTime() 
		+ "\n 평점\t\t= " + getbScore() + "\n 전화번호\t\t= " + getbTel() +  "\n 주소\t\t= " + getbAddr() + "\n 등록일자\t\t= " + getbRegDate();
	}
	
	
}
