package edu.mum.dream.dao;

import java.util.List;

public interface GenericDao<T> {
	/**
     * Method that returns the number of entries from a table that meet some
     * criteria (where clause params)
     * @param params
     *  sql parameters
     * @return the number of records meeting the criteria
     */

    void save(T t);

    void delete(Long id);

    T findOne(Long id);

    T update(T t);   
    
    List<T> findAll();

    
    
}
