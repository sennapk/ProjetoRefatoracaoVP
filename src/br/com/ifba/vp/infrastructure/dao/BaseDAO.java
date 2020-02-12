package br.com.ifba.vp.infrastructure.dao;

import br.com.ifba.vp.infrastructure.model.AbstractEntity;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Senna
 * @param <Entity>
 */
public class BaseDAO<Entity extends AbstractEntity> implements IBaseDAO<Entity> {
    
    protected static EntityManager entityManager;
    
    static {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("VP");
        entityManager = fac.createEntityManager();
    }
    
    @Override
    public Entity save(Entity obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public Entity update(Entity obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public void delete(Entity obj) {
        obj = findById(obj.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit(); 
    }

    @Override
    public List<Entity> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }

    @Override
    public Entity findById(Long id) {
        return (Entity) entityManager.find(getTypeClass(), id);
    }
    
    protected Class<?> getTypeClass(){
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
}