package org.mvp4j.impl.swing.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ActionInfo {
	private String action;
	private Class<?> eventType;
	private String eventAction;
	private Field field;
	private Method actionMethod;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Class<?> getEventType() {
		return eventType;
	}

	public void setEventType(Class<?> eventType) {
		this.eventType = eventType;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Method getActionMethod() {
		return actionMethod;
	}

	public void setActionMethod(Method actionMethod) {
		this.actionMethod = actionMethod;
	}

	public String getEventAction() {
		return eventAction;
	}

	public void setEventAction(String eventAction) {
		this.eventAction = eventAction;
	}

}
