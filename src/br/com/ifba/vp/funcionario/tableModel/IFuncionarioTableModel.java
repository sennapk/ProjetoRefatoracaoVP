package br.com.ifba.vp.funcionario.tableModel;

import br.com.ifba.vp.funcionario.model.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Senna
 */
public interface IFuncionarioTableModel {
    public List<Funcionario> funcionarios = new ArrayList<>();
    public String[] colunas = {"Nome", "RG"};
}