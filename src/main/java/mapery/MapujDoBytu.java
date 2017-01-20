package mapery;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MapujDoBytu<TByt> {

	public TByt map(ResultSet rs) throws SQLException;
	
}