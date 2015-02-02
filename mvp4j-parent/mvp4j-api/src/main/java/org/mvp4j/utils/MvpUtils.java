package org.mvp4j.utils;

import java.util.Objects;

import org.mvp4j.annotation.MVP;

public final class MvpUtils {

	private MvpUtils() {

	}

	/**
	 * Get the value of {@link MVP#presenterClass()} from the {@link MVP} annotation in the provided class.
	 * 
	 * @param mvpAnnotedClass
	 * @param <P>
	 *            the presenter class type
	 * @return the presenter class
	 */
	@SuppressWarnings("unchecked")
	public static <P> Class<P> getPresenterClass(Class<?> mvpAnnotedClass) {
		Objects.requireNonNull(mvpAnnotedClass, "AnnotedClass is null");

		MVP mvp = mvpAnnotedClass.getAnnotation(MVP.class);
		if (mvp == null) {
			throw new IllegalArgumentException("The provided class is not annoted with @MVP: " + mvpAnnotedClass);
		}

		return (Class<P>) mvp.presenterClass();
	}
}
