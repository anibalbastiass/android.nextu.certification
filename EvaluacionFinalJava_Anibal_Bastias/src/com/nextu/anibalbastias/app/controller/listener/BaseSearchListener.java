package com.nextu.anibalbastias.app.controller.listener;

/**
 *
 * @author anibalbastias
 * @param <T> entity
 */

public interface BaseSearchListener<T> {
    void onSearchResource(T item);
}
