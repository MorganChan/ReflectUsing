package com.develop.reflecttest;

import java.lang.reflect.Method;

public class ClassLoad {
	/**
	 * @author chenaib
	 * @param ClassName
	 * @param FunctionName
	 * @throws Exception
	 * @desc load class and function dynamically, just for method without parameters
	 */
	public void LoadMethodwithoutPara(String ClassName, String FunctionName) throws Exception, NoSuchMethodException {
		// find class based on class full name eg.
		// com.dreamworks.selenium.businessLib.Login
		Class<?> clz = Class.forName(ClassName);

		Object o = clz.newInstance();
		// get method in the class
		Method m = clz.getMethod(FunctionName);
		// invoke this method to the object so that we can use the method
		m.invoke(o);
	}

	/**
	 * @author chenaib
	 * @param strClassName
	 * @param strFunctionName
	 * @param paras
	 * @throws Exception
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @desc load class and function dynamically, just for method without parameters
	 * @notice The type of parameters in method should be Class, eg: Integer, Float..  NOT int, float
	 */
	public void LoadMethodwithClassNameandPara(String strClassName, String strFunctionName, Object []paras)
			throws Exception, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		Class<?> clz = Class.forName(strClassName);
		Object o = clz.newInstance();

		Class<?> cl[] = null;
		if (paras != null) {
			int lenparas = paras.length;
			cl = new Class[lenparas];
			for (int i = 0; i < lenparas; i++) {
				cl[i] = paras[i].getClass();
			}
		}
		Method m = clz.getDeclaredMethod(strFunctionName, cl);
		m.invoke(o, paras);
	}
	
	/**
	 * @author chenaib
	 * @param strFunctionName
	 * @param o
	 * @param paras
	 * @throws Exception
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	public void LoadMethodwithPara(String strFunctionName, Object o, Object[] paras)
			throws Exception, NoSuchMethodException, SecurityException, ClassNotFoundException {

		Class<?> cl[] = null;
		if (paras != null) {
			int lenparas = paras.length;
			cl = new Class[lenparas];
			for (int i = 0; i < lenparas; i++) {
				cl[i] = paras[i].getClass();
			}
		}
		Method m = o.getClass().getDeclaredMethod(strFunctionName, cl);
		m.invoke(o, paras);
	}

	/**
	 * @author chenaib
	 * @param strFunctionName
	 * @param o
	 * @param paras
	 * @throws Exception
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @desc: To solve one problem is that, the type of paras in method just input Integer, Float these CLASS
	 */
	public void LoadMethodSwithPara(String strClassName, String strFunctionName, Object[] paras)
			throws Exception, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		Class<?> clz = Class.forName(strClassName);
		Object o = clz.newInstance();
		
		//get paramaters
		Class<?> cl[] = null;
		if (paras != null) {
			int lenparas = paras.length;
			cl = new Class[lenparas];
			for (int i = 0; i < lenparas; i++) {
				cl[i] = paras[i].getClass();
			}
		}
		Method[] m = o.getClass().getMethods();
		int lenM = m.length;
		//Compare function name
		for (int i = 0; i < lenM; i++) {
			if (m[i].getName().equals(strFunctionName)) {
				try {
					m[i].invoke(o, paras);
				} catch (Exception e) {
					//handle the situation: same function name with different paras
					continue;
				}
				break;
			}
			continue;
		}
	}
}
