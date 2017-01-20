package uow;

import domena.Byt;

public interface UOWRep {

	public void trwaleDodanie(Byt byt);
	public void trwalaZmiana(Byt byt);
	public void trwaleUsun(Byt byt);
	
}