package com.company.Repository;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepo<T> implements ICrudRepo<T> {
    protected List<T> repo_list;
    public InMemoryRepo() {
        repo_list = new ArrayList<>();
    }

    /**
     * @param entity ist die zurückzugebende Entität und darf nicht null sein
     * @return die angegebene Entität zurück oder null - wenn es keine solche Entität gibt
     */
    @Override
    public T findOne(T entity) {
        for(T t:repo_list)
        {
            if(t.equals(entity))
                return t;
        }
        return null;
    }

    /**
     * @return alle Objekten
     */
    @Override
    public Iterable<T> findAll() {
        return repo_list;
    }

    /**
     * @param entity entity darf nicht null sein
     * @return null - wenn die angegebene Entität gespeichert wird,
     * gibt die Entität zurück (id bereits vorhanden)
     */
    @Override
    public T save(T entity) {
        for(T t:repo_list)
        {
            if(t.equals(entity))
                return t;
        }
        repo_list.add(entity);
        return null;
    }

    /**
     * entfernt die Entity mit der angegebenen ID
     * @param entity darf nicht null sein
     * @return die entfernte Entität zurück oder null, wenn es keine Entität mit der angegebenen ID gibt
     */
    @Override
    public T delete(T entity) {
        for(T t: repo_list){
            if(t.equals(entity)) {
                repo_list.remove(t);
                return t;
            }
        }
        return null;

    }
}
