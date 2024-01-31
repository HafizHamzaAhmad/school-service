package org.rak.school.interfaces;

public interface BusinessService<D> {
	D create(D dto);
	D update(D dto, String id);
	void delete(String uuid);

}
