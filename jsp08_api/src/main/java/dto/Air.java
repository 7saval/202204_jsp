package dto;

public class Air {
	private String clearVal;
	private int sn;
	private String districtName;
	private String dataDate;
	private String issueVal;
	private String issueTime;
	private String clearDate;
	private String issueDate;
	private String moveName;
	private String clearTime;
	private String issueGbn;
	private String itemCode;
	public Air() {
		super();
	}
	public Air(String clearVal, int sn, String districtName, String dataDate, String issueVal, String issueTime,
			String clearDate, String issueDate, String moveName, String clearTime, String issueGbn, String itemCode) {
		super();
		this.clearVal = clearVal;
		this.sn = sn;
		this.districtName = districtName;
		this.dataDate = dataDate;
		this.issueVal = issueVal;
		this.issueTime = issueTime;
		this.clearDate = clearDate;
		this.issueDate = issueDate;
		this.moveName = moveName;
		this.clearTime = clearTime;
		this.issueGbn = issueGbn;
		this.itemCode = itemCode;
	}
	public String getClearVal() {
		return clearVal;
	}
	public void setClearVal(String clearVal) {
		this.clearVal = clearVal;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDataDate() {
		return dataDate;
	}
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	public String getIssueVal() {
		return issueVal;
	}
	public void setIssueVal(String issueVal) {
		this.issueVal = issueVal;
	}
	public String getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(String issueTime) {
		this.issueTime = issueTime;
	}
	public String getClearDate() {
		return clearDate;
	}
	public void setClearDate(String clearDate) {
		this.clearDate = clearDate;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getMoveName() {
		return moveName;
	}
	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}
	public String getClearTime() {
		return clearTime;
	}
	public void setClearTime(String clearTime) {
		this.clearTime = clearTime;
	}
	public String getIssueGbn() {
		return issueGbn;
	}
	public void setIssueGbn(String issueGbn) {
		this.issueGbn = issueGbn;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	@Override
	public String toString() {
		return "Air [clearVal=" + clearVal + ", sn=" + sn + ", districtName=" + districtName + ", dataDate=" + dataDate
				+ ", issueVal=" + issueVal + ", issueTime=" + issueTime + ", clearDate=" + clearDate + ", issueDate="
				+ issueDate + ", moveName=" + moveName + ", clearTime=" + clearTime + ", issueGbn=" + issueGbn
				+ ", itemCode=" + itemCode + "]";
	}
	
}
