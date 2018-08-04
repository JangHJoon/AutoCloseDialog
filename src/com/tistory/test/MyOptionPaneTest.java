package com.tistory.test;

import com.tistory.janggom.MyOptionPane;

public class MyOptionPaneTest {

	public static void main(String[] args) {
		String[] buttons = new String[]{"수락", "거절"};
		String result = MyOptionPane.showAutoCloseDialog(null, 5, "친구수락이 왔습니다.", "친구요청", buttons, 1);
		if(result.equals(buttons[0])){
			System.out.println("수락");
		} else if(result.equals(buttons[1])){
			System.out.println("거절");
		} else {
			System.out.println("오류");
		}
		
	}

}
