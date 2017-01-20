package domena;

public class Uprawnienia extends Byt {
	
	private long idRoli;
	private long idUprawnien;
	private String NazwaUprawnienia;
	private Loginy Login;
	
	public Uprawnienia(){
		
	}

	public Uprawnienia(long idRoli, long idUprawnien){
		this.idRoli = idRoli;
		this.idUprawnien = idUprawnien;
	}
	
	public Uprawnienia(long idRoli, long idUprawnien, String NazwaUprawnienia){
		this.idRoli = idRoli;
		this.idUprawnien = idUprawnien;
		this.NazwaUprawnienia = NazwaUprawnienia;
	}
	
	public long getidRoli(){
		return idRoli;
	}
	
	public long getidUprawnien(){
		return idUprawnien;
	}
	
	public String getNazwaUprawnienia(){
		return NazwaUprawnienia;
	}
	
	public Loginy getLogin(){
		return Login;
	}
	
	public void setidRoli(long idRoli){
		this.idRoli = idRoli;
	}
	
	public void setidUprawnien(long idUprawnien){
		this.idUprawnien = idUprawnien;
	}
	
	public void setNazwaUprawnien(String NazwaUprawnienia){
		this.NazwaUprawnienia = NazwaUprawnienia;
	}
	
	public void setLogin(Loginy Login){
		this.Login = Login;
	}

}
