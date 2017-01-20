package uow;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import domena.Byt;
import domena.EntityState;

public class UOW implements UnitOfWork {
	
	private Connection polaczenie;

	public UOW(Connection polaczenie) {
		super();
		this.setConnection(polaczenie);
		
		try {
			polaczenie.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Map<Byt, UOWRep> byty = 
			new LinkedHashMap<Byt, UOWRep>();
	
	public void saveChanges() {
		for(Byt byt: byty.keySet()){
			
			switch(byt.getState()){
			
			case Deleted:
				byty.get(byt).trwaleUsun(byt);
				break;
			case Modified:
				byty.get(byt).trwalaZmiana(byt);
				break;
			case New:
				byty.get(byt).trwaleDodanie(byt);
				break;
			default:
				break;
			}
		}try {
			polaczenie.commit();
			byty.clear();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void undo() {
		try {
			polaczenie.rollback();
			byty.clear();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void zaznaczJakoNowe(Byt byt, UOWRep repo) {
		byt.setState(EntityState.New);
		byty.put(byt, repo);
		
	}

	public void zaznaczJakoUsuniete(Byt byt, UOWRep repo) {
		byt.setState(EntityState.Deleted);
		byty.put(byt, repo);
		
	}

	public void zaznaczJakoZmienione(Byt byt, UOWRep repo) {
		byt.setState(EntityState.Modified);
		byty.put(byt, repo);
		
	}

	public Connection getConnection() {
		return polaczenie;
	}

	public void setConnection(Connection polaczenie) {
		this.polaczenie = polaczenie;
	}

}