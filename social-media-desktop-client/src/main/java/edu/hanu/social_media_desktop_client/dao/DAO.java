package edu.hanu.social_media_desktop_client.dao;

import java.util.List;

public interface DAO<T> {
	
	T get(long id);
	
	List<T> getAll();
	
	void save(T t);
	
	void update(T t);
	
	void delete(long id);
	
}

