package org.mvp4j.impl.gwt.reflect;



public class AppControllerReflectFactory {
	private static AppControllerReflect appControllerReflect;

	public static AppControllerReflect getAppControllerInstance() {
		if (appControllerReflect == null) {
			return new AppControllerReflect();
		}
		return appControllerReflect;
	}

}
