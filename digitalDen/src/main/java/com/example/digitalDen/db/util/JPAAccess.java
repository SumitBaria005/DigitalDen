package com.example.digitalDen.db.util;

import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class JPAAccess {

    private EntityManager entityManager;

    public <T> T get(Class<T> entityClass, Object id){
        return entityManager.find(entityClass, id);
    }

    public void save(Object entity){entityManager.persist(entity);}

    public void update(Object entity){entityManager.merge(entity);}

    public void delete(Object entity){
        entityManager.merge(entity);
        entityManager.remove(entity);
    }

    public <T> List<T> find(CriteriaQuery<T> query){return entityManager.createQuery(query).getResultList();}

    public <T> List<T> findByPagination(String query, int pageNo, int pageSize, Class<T> entityClass){
        List<T> results = entityManager.createQuery(query, entityClass).setFirstResult(pageNo * pageSize).setMaxResults(pageSize).getResultList();
        return results;
    }

    public <T> List<T> findByPaginationUsingNamedQuery(String nameOfQuery, HashMap<String, Object> params, int pageNo, int pageSize, Class<T> entityClass){
        Query query = entityManager.createNamedQuery(nameOfQuery, entityClass).setFirstResult(pageNo * pageSize).setMaxResults(pageSize);

        if(Objects.nonNull(params)){
            params.forEach((k,v) -> query.setParameter(k,v));
        }
        List<T> results = query.getResultList();
        return results;
    }

    public void executeUpdateUsingNamedQuery(String nameOfQuery, HashMap<String, Object> params){
        Query query = entityManager.createNamedQuery(nameOfQuery);
        if(Objects.nonNull(params))
            params.forEach((k,v) -> query.setParameter(k,v));
        query.executeUpdate();
    }

    public <T> T findOneUsingNamedQuery(String nameOfQuery, HashMap<String, Object> params, Class<T> entityClass) {
        Query query = entityManager.createNamedQuery(nameOfQuery, entityClass);
        if (Objects.nonNull(params))
            params.forEach((k,v) -> query.setParameter(k,v));
        List<T> results = query.getResultList();
        if(CollectionUtils.isEmpty(results))
            return null;
        return results.get(0);
    }

    public void flush(){entityManager.flush();}

    public <T> void bulkUpdate(T[] entities) {
        int batchSize = 50;
        boolean remaining = false;
        for (int i = 0; i < entities.length; i++){
            entityManager.merge(entities[i]);
            remaining = true;
            if (i % batchSize == 0){
                entityManager.flush();
                entityManager.clear();
                remaining = false;
            }
        }

        if (remaining){
            entityManager.flush();
            entityManager.clear();
        }
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){this.entityManager = entityManager;}
}
