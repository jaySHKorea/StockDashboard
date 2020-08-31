package db;

// 주가 정보 정의 Class
public class Stock {
	
	private Long id; // 종목코드
	private String name; // 종목명
	private Long present; //현재가
	private Long diffprev; // 전일대비
	private Long prevClose; // 전일종가
	private Long volume; //거래량
	private Long volumeMoney; // 거래대금
	private Long open; //시가
	private Long high; //고가
	private Long low; //저가
	private Long high52; //52주 최고
	private Long low52; //52주 최저
	private Long ulprice; //상한가
	private Long llprice; //하한가
	private float per; //per
	private Long totalcnt; //상장주식수
	private Long faceValue; //액면가
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPresent() {
		return present;
	}
	public void setPresent(Long present) {
		this.present = present;
	}
	public Long getDiffprev() {
		return diffprev;
	}
	public void setDiffprev(Long diffprev) {
		this.diffprev = diffprev;
	}
	public Long getPrevClose() {
		return prevClose;
	}
	public void setPrevClose(Long prevClose) {
		this.prevClose = prevClose;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public Long getVolumeMoney() {
		return volumeMoney;
	}
	public void setVolumeMoney(Long volumeMoney) {
		this.volumeMoney = volumeMoney;
	}
	public Long getOpen() {
		return open;
	}
	public void setOpen(Long open) {
		this.open = open;
	}
	public Long getHigh() {
		return high;
	}
	public void setHigh(Long high) {
		this.high = high;
	}
	public Long getLow() {
		return low;
	}
	public void setLow(Long low) {
		this.low = low;
	}
	public Long getHigh52() {
		return high52;
	}
	public void setHigh52(Long high52) {
		this.high52 = high52;
	}
	public Long getLow52() {
		return low52;
	}
	public void setLow52(Long low52) {
		this.low52 = low52;
	}
	public Long getUlprice() {
		return ulprice;
	}
	public void setUlprice(Long ulprice) {
		this.ulprice = ulprice;
	}
	public Long getLlprice() {
		return llprice;
	}
	public void setLlprice(Long llprice) {
		this.llprice = llprice;
	}
	public float getPer() {
		return per;
	}
	public void setPer(float per) {
		this.per = per;
	}
	public Long getTotalcnt() {
		return totalcnt;
	}
	public void setTotalcnt(Long totalcnt) {
		this.totalcnt = totalcnt;
	}
	public Long getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(Long faceValue) {
		this.faceValue = faceValue;
	}
}
