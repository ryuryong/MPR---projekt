package domena;

public class Loginy extends Byt {
	
	private long id;
	private String Login;
	private String Haslo;
	private Role Role;
	private Uprawnienia Uprawnienia;
	
	public Loginy() {
		
	}
	
	public Loginy(long id, String Login, String Haslo){
		this.id = id;
		this.Login = Login;
		this.Haslo = Haslo;
	}
	
	public long getId(){
		return id;
	}
	
	public String getLogin(){
		return Login;
	}
	
	public String getHaslo(){
		return Haslo;
	}
	
	public Role getRole(){
		return Role;
	}
	
	public Uprawnienia getUprawnienia(){
		return Uprawnienia;
	}	
	
	public void setId(long id){
		this.id = id;
	}
	
	public void setLogin(String Login){
		this.Login = Login;
	}

	public void setHaslo(String Haslo){
		this.Haslo = Haslo;
	}
	
	public void setRole(Role Role){
		this.Role = Role;
	}
	
	public void setUprawnienia(Uprawnienia Uprawnienia){
		this.Uprawnienia = Uprawnienia;
	}
}
