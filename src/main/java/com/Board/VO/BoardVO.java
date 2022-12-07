package com.Board.VO;

import java.util.Date;

public class BoardVO {
	private int bid, uid, readcount;
	private String title, name, content;
	private Date write_date;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", uid=" + uid + ", readcount=" + readcount + ", title=" + title + ", name="
				+ name + ", content=" + content + ", write_date=" + write_date + "]";
	}
	
	
	
}
