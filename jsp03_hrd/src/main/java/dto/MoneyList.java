package dto;

//회원매출조회 dto
public class MoneyList {
	private int custno;
	private String custname;
	private String grade;
	private int price;
	public MoneyList() {
	}
	public MoneyList(int custno, String custname, String grade, int price) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.price = price;
	}
	public int getCustno() {
		return custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MoneyList [custno=" + custno + ", custname=" + custname + ", grade=" + grade + ", price=" + price + "]";
	}
	
}
