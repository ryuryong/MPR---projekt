package mapery;

import java.sql.ResultSet;
import java.sql.SQLException;

import domena.Loginy;

public class MapujUzytkownika implements MapujDoBytu<Loginy> {

	public Loginy map(ResultSet rs) throws SQLException {
		Loginy result = new Loginy();
		result.setId(rs.getLong("id"));
		result.setLogin(rs.getString("Login"));
		result.setHaslo(rs.getString("Haslo"));
		return result;
	}
	
}
