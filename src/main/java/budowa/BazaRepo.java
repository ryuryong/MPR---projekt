package budowa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import domena.Byt;
import mapery.MapujDoBytu;
import uow.UnitOfWork;
import uow.UOWRep;


public abstract class BazaRepo<TEntity extends Byt>
	implements UOWRep{


	protected Connection polaczenie;


	MapujDoBytu<TEntity> maper;
	
	protected Statement createTable;
	protected PreparedStatement insert;
	protected PreparedStatement selectById;
	protected PreparedStatement delete;
	protected PreparedStatement selectAll;
	protected PreparedStatement update;
	protected UnitOfWork uow;
	
	protected BazaRepo(Connection polaczenie,
			MapujDoBytu<TEntity> maper, 
			UnitOfWork uow){
		try {
			if(polaczenie == null)
				{
					this.polaczenie = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
					uow.setConnection(this.polaczenie);
				}
			this.polaczenie.setAutoCommit(false);
			this.uow = uow;
			this.maper = maper;
			createTable = polaczenie.createStatement();
			createTableIfNotExists();
			insert = polaczenie.prepareStatement(getInsertQuery());
			selectById = polaczenie.prepareStatement(getSelectByIdQuery());
			delete = polaczenie.prepareStatement(getDeleteQuery());
			selectAll = polaczenie.prepareStatement(getSelectAllQuery());
			update = polaczenie.prepareStatement(getUpdateQuery());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createTableIfNotExists() throws SQLException {
		boolean tableExists = false;
		ResultSet rs = polaczenie.getMetaData().getTables(null, null, null, null);
		while(rs.next()){
			if(getTableName().equalsIgnoreCase(rs.getString("TABLE_NAME"))){
				tableExists=true;
				break;
			}
		}
		
		if(!tableExists)
			createTable.executeUpdate(getCreateTableQuery());
	}
	
	protected abstract String getTableName();
	protected abstract String getCreateTableQuery();
	protected abstract String getInsertQuery();
	protected abstract String getUpdateQuery();
	protected abstract void setUpInsert(Byt person) throws SQLException;
	protected abstract void setUpUpdate(Byt p) throws SQLException;


	protected String getDeleteQuery() {
		return "DELETE FROM "
				+ getTableName()
				+ " WHERE id=?";
	}
	protected String getSelectByIdQuery() {
		return "SELECT * FROM "
				+ getTableName()
				+ " WHERE id = ?"; 
	}
	protected String getSelectAllQuery() {
		return "SELECT * FROM "
				+ getTableName();
	}

	public void persistDelete(Byt p){
		try{
			delete.setLong(1, p.getidBytu());
			delete.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void delete(TEntity byt){
		uow.zaznaczJakoUsuniete(byt, this);
	}

	public void persistUpdate(Byt p){
		try{
			setUpUpdate(p);
			update.executeUpdate();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void update(TEntity p){
		uow.zaznaczJakoZmienione(p, this);
	}

	public void persistInsert(Byt byt){
		try{
		setUpInsert(byt);
		insert.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public void add(TEntity byt){
		uow.zaznaczJakoNowe(byt, this);
	}
	

	public TEntity get(int id){
		try{
			selectById.setInt(1, id);
			ResultSet rs = selectById.executeQuery();
			while(rs.next()){
				return maper.map(rs);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return null;
	}

	public List<TEntity> getAll(){
		List<TEntity> result = null;
		try{
			
			ResultSet rs = selectAll.executeQuery();
			result = new ArrayList<TEntity>();
			while(rs.next()){
				result.add(maper.map(rs));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return result;
	}
}