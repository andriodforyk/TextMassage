package com.example.textmassage;

public class Msg {
	public static final int MESSAGE_SEND = 1;
	public static final int MESSAGE_RECEIVE = 0;
	private String message;
	private int type;

	public Msg(String message, int type) {
		this.message = message;
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public int getType() {
		return type;
	}
}
