package org.mvp4j.impl.swing.reflect;

import java.lang.reflect.Field;

import org.mvp4j.adapter.ModelComponent;

public class ModelInfo {

	private String propertyName;
	private String iniPropertyName;
	private Field field;
	private ModelComponent componentModel;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getIniPropertyName() {
		return iniPropertyName;
	}

	public void setIniPropertyName(String iniPropertyName) {
		this.iniPropertyName = iniPropertyName;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public ModelComponent getComponentModel() {
		return componentModel;
	}

	public void setComponentModel(ModelComponent componentModel) {
		this.componentModel = componentModel;
	}

}
