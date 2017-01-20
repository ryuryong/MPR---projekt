package domena;

public abstract class Byt {

	EntityState state;
	
	private long idBytu;
	
	public long getidBytu(){
		return idBytu;
	}
	
	public EntityState getState(){
		return state;
	}
	
	public void setidBytu(){
		this.idBytu = idBytu;
	}
	
	public void setState(EntityState state){
		this.state = state;
	}

}
