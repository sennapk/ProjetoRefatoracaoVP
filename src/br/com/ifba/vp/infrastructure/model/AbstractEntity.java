package br.com.ifba.vp.infrastructure.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Senna
 */
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    private long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}