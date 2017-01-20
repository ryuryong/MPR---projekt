package budowa;

import java.sql.ResultSet;
import java.sql.SQLException;

import domena.Loginy;
import mapery.MapujDoBytu;

public class BudujLoginy implements MapujDoBytu<Loginy> {

	public Loginy map(ResultSet rs) throws SQLException {
		Loginy u = new Loginy();
		u.setLogin(rs.getString("login"));
		u.setHaslo(rs.getString("haslo"));
		u.setId(rs.getInt("id"));
		return u;
	}

}