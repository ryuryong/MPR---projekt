package domena;

public class Role extends Byt {
	
	private long idRoli;
	private long idUzytkownika;
	private String NazwaRoli;
	private Loginy Login;
	
	public Role(){
		
	}
	
	public long getidRoli(){
		return idRoli;
	}
	
	public Role(long idRoli, long idUzytkownika){
		this.idRoli = idRoli;
		this.idUzytkownika = idUzytkownika;
	}
	
	public Role(long idRoli, long idUzytkownika, String NazwaRoli){
		this.idRoli = idRoli;
		this.idUzytkownika = idUzytkownika;
		this.NazwaRoli = NazwaRoli;
	}
		
	public long getidUzytkownika(){
		return idUzytkownika;
	}
	
	public String getNazwaRoli(){
		return NazwaRoli;
	}
	
	public Loginy getLogin(){
		return Login;
	}
	
	public void setidRoli(long idRoli){
		this.idRoli = idRoli;
	}
	
	public void setidUzytkownika(long idUzytkownika){
		this.idUzytkownika = idUzytkownika;
	}
	
	public void setNazwaRoli(String NazwaRoli){
		this.NazwaRoli = NazwaRoli;
	}
	
	public void setLogin(Loginy Login){
		this.Login = Login;
	}
}
