package br.com.ifba.vp.cliente.model;

import br.com.ifba.vp.infrastructure.model.Pessoa;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Senna
 */
@Entity
@Table(name = "Cliente")
public class Cliente extends Pessoa implements Serializable {}