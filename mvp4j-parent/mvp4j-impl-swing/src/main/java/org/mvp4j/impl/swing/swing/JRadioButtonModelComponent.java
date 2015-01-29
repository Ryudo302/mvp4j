package org.mvp4j.impl.swing.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import org.apache.log4j.Logger;
import org.mvp4j.Converter;
import org.mvp4j.adapter.ModelBinding;
import org.mvp4j.adapter.ModelComponent;
import org.mvp4j.impl.swing.swing.utils.LoggerUtils;

public class JRadioButtonModelComponent extends ModelComponent {

	private ActionListener actionListerner;
	private JRadioButton radionButton;
	private Logger logger = LoggerUtils.getLogger();

	
	public JRadioButtonModelComponent() {
	}

	@Override
	public void bind() {
		actionListerner = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object object = modelBinding.getInitPropertyValue();
				modelBinding.setPropertyValue(object);

			}
		};
		radionButton.addActionListener(actionListerner);

		if (modelBinding.getPropertyValue() != null) {
			if (modelBinding.getPropertyValue()
					.equals(modelBinding.getInitPropertyValue().toString())) {
				radionButton.setSelected(true);
			}
		}
	}

	@Override
	public void unbind() {
		// TODO Auto-generated method stub

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
		radionButton = (JRadioButton) modelBinding.getComponent();
		
	}

}
