package managedBeans;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import facade.AbstractFacade;

public abstract class GenericBean<T> {
	
	protected String delInitPage, createInitPage, updateInitPage;
	
	protected T entity;
	protected List<T> entities = new ArrayList<>();
	
	public GenericBean() {
		newEntityInstance();
	}
	
	protected abstract AbstractFacade<T> getFacade(); 
	
	public List<T> getList() {
		return this.entities;
	}
	
	public void setList (List<T> entities) {
		this.entities = entities;
	}
	
	public T get() {
		return this.entity;
	}
	
	public void set(T entity) {
		this.entity = entity;
	}
	
	public void loadElements() {
		this.entities = getFacade().findAll();
	}
	
	public void find() throws NoSuchMethodException, SecurityException, 
						IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.entity = getFacade().find(getId());		
	}
	
	public void clear() {
		newEntityInstance();
	}
	
	public String delete(T entity) {
		try {
			getFacade().delete(entity);
			MessageUtil.addSuccessMessage("successfully deleted.");
		} catch (Exception e) {
			MessageUtil.addErrorMessage("Could not delete!");
		}
		return delInitPage;
	}
	
	public String create() {
		try {
			getFacade().save(this.entity);
			MessageUtil.addSuccessMessage("successfully created.");
		} catch (Exception e) {
			MessageUtil.addErrorMessage("could not be saved. A Persisting error occured.");
		}
		return createInitPage;
	}
	
	public String update() throws NoSuchMethodException, SecurityException, IllegalAccessException, 
								IllegalArgumentException, InvocationTargetException {
		try {
			getFacade().update(this.entity);
			MessageUtil.addSuccessMessage("id " + getId() + " was successfully updated.");
		} catch (Exception e) {
			MessageUtil.addErrorMessage("id " + getId() + " could not be saved. An update error occured.");
		}
		return updateInitPage;
	}
	
	@SuppressWarnings("unchecked")
	protected void newEntityInstance() {
		String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
		try {
			entity = (T) Class.forName(className).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
			MessageUtil.addErrorMessage("Could not instantiate the entity!");
		}
	}
	
	private int getId() throws NoSuchMethodException, SecurityException, 
						IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method getId = entity.getClass().getDeclaredMethod("getId");
		return (int) getId.invoke(entity);	
	}
}
