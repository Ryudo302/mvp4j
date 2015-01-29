package org.mvp4j.impl.swing.swing;

import java.awt.event.*;
import java.util.List;

import javax.swing.JComboBox;

import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.*;
import org.mvp4j.exception.PropertyNotBindableException;
import org.mvp4j.impl.swing.swing.utils.LoggerUtils;

public class JComboBoxModelComponent extends ModelComponent {

	private JComboBox jcombobox;
	private ItemListener itemlistener;
	private List<Object> initValues;
	private Logger logger = LoggerUtils.getLogger();

	public JComboBoxModelComponent() {
	}

	@Override
	public void bind() {
		Object propertyValue = modelBinding.getPropertyValue();
		if (propertyValue != null) {
			for (int i = 0; i < initValues.size(); i++) {
				if (initValues.get(i).toString().equals(propertyValue)) {
					jcombobox.setSelectedIndex(i);
					break;
				} else {
					jcombobox.setSelectedIndex(0);
				}
			}

		}
		if (!initValues.isEmpty()) {

			if (jcombobox.getItemCount() == 0) {
				for (Object object : initValues) {
					jcombobox.addItem(object);

				}
			}
		} else {
			logger.error("The value of Init Property is empty!!!");
			throw new IllegalArgumentException();
		}

		int selectedIndex = jcombobox.getSelectedIndex();
		modelBinding.setPropertyValue(selectedIndex != -1 ? initValues.get(selectedIndex) : null);

		itemlistener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				int selectedIndex = jcombobox.getSelectedIndex();
				modelBinding.setPropertyValue(selectedIndex != -1 ? initValues.get(selectedIndex) : null);

			}
		};
		jcombobox.addItemListener(itemlistener);

	}

	@Override
	public void unbind() {
	}

	@Override
	public void setConverter(Converter converter) {
		// TODO Auto-generated method stub

	}

	@Override
	public Converter getConverter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ModelBinding modelBinding) {
		super.init(modelBinding);
		jcombobox = (JComboBox) modelBinding.getComponent();
		try {
			initValues = (List<Object>) modelBinding.getInitPropertyValue();
		} catch (ClassCastException e) {
			logger.error("initProperty '" + modelBinding.getInitPropertyName() + "' must be Collection");
			throw new PropertyNotBindableException(modelBinding.getInitPropertyName(), modelBinding.getInitPropertyName()
					.getClass(), jcombobox.getClass());
		}

	}

}
