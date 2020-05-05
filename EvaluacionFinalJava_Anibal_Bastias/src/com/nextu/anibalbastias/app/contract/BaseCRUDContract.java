package com.nextu.anibalbastias.app.contract;

import java.util.ArrayList;

/**
 *
 * @author anibalbastias
 * @param <T> Abstract for entity
 */
public interface BaseCRUDContract<T> {

    public ArrayList<T> getAll();

    public T get(String id);

    public void update(T item);

    public void delete(T item);

    public void insert(T item);
    
}
