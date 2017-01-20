package repozytoria;

import java.util.List;

import domena.*;

public interface RepLoginy extends Repozytorium<Loginy>  {
	
	public List<Loginy> zL(String Login);
	public List<Loginy> zLiH(String Login, String Haslo);
	public void ustawUprawnienie(Loginy Login);

}
