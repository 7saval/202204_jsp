package dto;

public class Iso {
	private String code;
	private String name;
	public Iso() {
		super();
	}
	public Iso(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Iso [code=" + code + ", name=" + name + "]";
	}
	
}
