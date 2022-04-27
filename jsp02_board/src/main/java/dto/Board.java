package dto;

import java.util.Date;

public class Board {
	private int seq;
	private String writer;
	private String subject;
	private String contents;
	private Date regidate;
	private Date modidate;
	public Board() {
	}
	
	public Board(String writer, String subject, String contents) {
		super();
		this.writer = writer;
		this.subject = subject;
		this.contents = contents;
	}

	public Board(int seq, String writer, String subject, String contents, Date regidate, Date modidate) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.subject = subject;
		this.contents = contents;
		this.regidate = regidate;
		this.modidate = modidate;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", writer=" + writer + ", subject=" + subject + ", contents=" + contents
				+ ", regidate=" + regidate + ", modidate=" + modidate + "]";
	}
	
}
