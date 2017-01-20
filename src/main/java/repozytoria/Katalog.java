package repozytoria;

import domena.Role;

public interface Katalog {
	
	public RepLoginy getLoginy();
	public Repozytorium<Role> getRole();
	public void commit();
	
}
