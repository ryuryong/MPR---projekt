package repozytoria;

public interface Repozytorium<TEntity> {

	public void add(TEntity entity);
	public void count();
	public void modify(TEntity entity);
	public void delete(TEntity entity);
	public TEntity withId(long id);
	
	public void allOnPage(Strony strona);
}
