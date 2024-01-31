package org.rak.school.interfaces;

public interface Command<D> {
	void execute(D d);
}
