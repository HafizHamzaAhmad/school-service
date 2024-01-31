package org.rak.school.interfaces;

public interface RequestValidator<D> {
	boolean validateRequest(D dto);
}
