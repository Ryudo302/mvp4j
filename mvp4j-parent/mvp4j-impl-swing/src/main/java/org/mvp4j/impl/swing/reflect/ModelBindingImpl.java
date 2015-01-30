package org.mvp4j.impl.swing.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.MVPBinding;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.exception.PropertyNotFoundException;
import org.mvp4j.exception.PropertyNotInitializedException;
import org.mvp4j.impl.swing.swing.utils.LoggerUtils;

public class ModelBindingImpl implements ModelBinding {

	private ModelInfo modelInfo;
	private Object model;
	private Object view;
	private Converter converter;
	private MVPBinding mvpBinding;
	private Logger logger = LoggerUtils.getLogger();

	public ModelBindingImpl(Object view, Object model, ModelInfo modelInfo, MVPBinding mvpBinding) {

		this.model = model;
		this.view = view;
		this.modelInfo = modelInfo;
		this.mvpBinding = mvpBinding;

	}

	@Override
	public Object getComponent() {
		Object object = null;
		try {
			object = modelInfo.getField().get(view);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public String getPropertyName() {
		return modelInfo.getPropertyName();
	}

	@Override
	public String getInitPropertyName() {
		return modelInfo.getIniPropertyName();
	}

	@Override
	public void setPropertyValue(Object value) {
		try {
			Class modelClass = model.getClass();
			Field field = modelClass.getDeclaredField(getPropertyName());
			field.setAccessible(true);
			field.set(model, getConverter().convertComponentToModel(field.getType(), value));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			logger.fatal("Field " + getPropertyName() + " not found ");
			throw new PropertyNotFoundException(getPropertyName(), model.getClass());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Object getPropertyValue() {
		try {
			Object object = BeanUtils.getNestedProperty(model, getPropertyName());
			logger.debug(getPropertyName() + " = " + object);
			if (object != null) {
				return getConverter().convertModelToComponent(object);
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object getInitPropertyValue() {
		Object fakeObject = new Object();
		Object object = fakeObject;

		String initPropertyName = getInitPropertyName();
		if (initPropertyName.isEmpty()) {
			throw new IllegalStateException("initProperty must be defined");
		}

		try {
			Class modelClass = model.getClass();
			Method[] methods = modelClass.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().equalsIgnoreCase("get" + initPropertyName)) {

					object = method.invoke(model);
				}
			}
			if (object == fakeObject) {
				throw new PropertyNotFoundException(initPropertyName, model);
			}
			if (object == null) {
				throw new PropertyNotInitializedException(initPropertyName);
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	private Converter getConverter() {
		if (modelInfo.getComponentModel().getConverter() == null) {
			converter = getMvpBinding().getGlobalConverter();
		} else {
			converter = modelInfo.getComponentModel().getConverter();
		}
		return converter;
	}

	public MVPBinding getMvpBinding() {
		return mvpBinding;
	}

}
