package com.develop.reflecttest;

import com.develop.lib.Tempload;

public class Classloadtest extends ClassLoad {

	public static void main(String[] args) {

		ClassLoad cl = new ClassLoad();
		Tempload tl = new Tempload();

		try {
			//cl.LoadMethodwithoutPara("com.develop.lib.Tempload", "cc");
			//cl.LoadMethodwithClassNameandPara("com.develop.lib.Tempload", "cc", null);
			/*
			 * if use LoadMethodwithClassNameandPara to invoke tt method as below, then type of parameters should be change to Class Integer, Float...
			 */
			//cl.LoadMethodwithClassNameandPara("com.develop.lib.Tempload", "tt", new Object[]{0,1});
			cl.LoadMethodSwithPara("com.develop.lib.Tempload", "tt", new Object[]{"0sdsd","1sdsd"});
			cl.LoadMethodSwithPara("com.develop.lib.Tempload", "tt", new Object[]{2,4});
			//cl.LoadMethodwithPara("tt", tl, new Object[]{0,1});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
