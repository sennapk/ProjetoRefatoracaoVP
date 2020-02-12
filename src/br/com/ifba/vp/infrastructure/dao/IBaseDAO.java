package br.com.ifba.vp.infrastructure.dao;

import br.com.ifba.vp.infrastructure.model.AbstractEntity;
import java.util.List;

/**
 *
 * @author Senna
 * @param <Entity>
 */
public interface IBaseDAO <Entity extends AbstractEntity>{
    
    Entity save(Entity obj);
    
    Entity update(Entity obj);
    
    void delete(Entity obj);
    
    List<Entity> findAll();
    
    Entity findById(Long id);
}