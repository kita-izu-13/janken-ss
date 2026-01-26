package model;

import java.io.Serializable;

public class Mutter implements Serializable {
	private String userName;	//ユーザー名
	private String hand;	//手
	public Mutter() {}
	public Mutter(String userName, String hand) {
		this.userName = userName;
		this.hand = hand;
	}
	public String getUserName() { return userName; }
	public String getHand() { return hand; }
}
