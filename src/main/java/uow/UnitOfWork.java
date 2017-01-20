package uow;

import java.sql.Connection;

import domena.Byt;

public interface UnitOfWork {

	public void saveChanges();
	public void undo();

	public void zaznaczJakoNowe(Byt byt, UOWRep repo);
	public void zaznaczJakoUsuniete(Byt byt, UOWRep repo);
	public void zaznaczJakoZmienione(Byt byt, UOWRep repo);
	
	public void setConnection(Connection polaczenie);
}
