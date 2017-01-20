package repozytoria;

import java.sql.Connection;

import domena.Role;
import repozytoria.Katalog;
import budowa.BudujLoginy;
import budowa.RepoLoginow;
import uow.UnitOfWork;

public class RepKatalog implements Katalog{
	
	private Connection polaczenie;
	private UnitOfWork uow;
	
	public RepKatalog(Connection polaczenie, UnitOfWork uow) {
		super();
		this.polaczenie = polaczenie;
		this.uow = uow;
	}

	public RepLoginy getLoginy() {
		return new RepoLoginow(polaczenie, new BudujLoginy(), uow);
	}

	public void commit() {
	}

	public Repozytorium<Role> getRole() {
		return null;
	}

}