package com.ggstudy.logic.suanfa;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author xcj
 *
 *         原理： 你选了一个门，然后可以理解为主持人拥有剩下的两个门，此时你换的话，相当于与用一个门，换了他手里的两个门。</br>
 * 		主持人排除掉一个没有车的门，并不影响他拥有两个门的事实。
 */
public class GameFactory {
	public static final String CAR_NAME = "car";
	public static final String SHEEP_NAME = "sheep";

	public static void main(String[] args) {
		boolean change = true;// 主持人让你换的时候，你是否换,true-换，false-不换。
		int sum = 10000;// 总实验次数
		int car = 0;// 得到车次数
		for (int i = 0; i < sum; i++) {
			String ss = play(change);
			if (ss.equals(CAR_NAME)) {
				car++;
			}
		}
		NumberFormat nt = NumberFormat.getPercentInstance();
		// 设置百分数精确度2即保留两位小数
		nt.setMinimumFractionDigits(4);
		System.out.println("共玩游戏：" + sum + "次");
		System.out.println("每次主持人询问是否更换时选择：" + (change == true ? "换" : "不换"));
		System.out.println("拿到车的次数：" + car);
		System.out.println("拿到车的概率：" + nt.format((double) car / (double) sum));
	}

	public static String play(boolean change) {
		Random ra = new Random();
		int carDoor = Math.abs(ra.nextInt() % 3);
		Map<Integer, Door> doors = new HashMap<Integer, Door>();
		for (int i = 0; i < 3; i++) {
			if (i == carDoor) {
				doors.put(i, new Door(CAR_NAME));
			} else {
				doors.put(i, new Door(SHEEP_NAME));
			}
		}
		int selected = Math.abs(ra.nextInt() % 3);
		Door selectedDoor = doors.remove(selected);
		for (Integer key : doors.keySet()) {
			if (doors.get(key).getGiftName().equals(SHEEP_NAME)) {
				doors.remove(key);
				break;
			}
		}
		if (change) {
			if (doors.size() == 1) {
				for (Door d : doors.values()) {
					selectedDoor = d;
				}
			}
		}
		return selectedDoor.getGiftName();
	}

}

class Door {
	private String giftName;

	public Door(String giftName) {
		this.giftName = giftName;
	}

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

}
