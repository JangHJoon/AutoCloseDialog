package com.tistory.test;

import com.tistory.janggom.MyOptionPane;

public class MyOptionPaneTest {

	public static void main(String[] args) {
		String[] buttons = new String[]{"����", "����"};
		String result = MyOptionPane.showAutoCloseDialog(null, 5, "ģ�������� �Խ��ϴ�.", "ģ����û", buttons, 1);
		if(result.equals(buttons[0])){
			System.out.println("����");
		} else if(result.equals(buttons[1])){
			System.out.println("����");
		} else {
			System.out.println("����");
		}
		
	}

}
