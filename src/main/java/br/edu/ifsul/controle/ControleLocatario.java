package br.edu.ifsul.controle;

import br.edu.ifsul.dao.LocatarioDAO;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "controleLocatario")
@ViewScoped
public class ControleLocatario implements Serializable{
    
    @EJB
    private LocatarioDAO<Locatario> dao;
    private Locatario objeto;

    public ControleLocatario() {
        
    }
    
    public String listar() {
        return "/privado/locatario/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Locatario();
    }
    
    public void alterar(Object id) {
        try{
            objeto = dao.getObjetcByID(id);
        }catch(Exception e) {
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void remover(Object id) {
        try{
            objeto = dao.getObjetcByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        }catch(Exception e) {
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar() {
        try{
            if(objeto.getCpf() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        }catch(Exception e) {
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    public LocatarioDAO<Locatario> getDao() {
        return dao;
    }

    public void setDao(LocatarioDAO<Locatario> dao) {
        this.dao = dao;
    }

    public Locatario getObjeto() {
        return objeto;
    }

    public void setObjeto(Locatario objeto) {
        this.objeto = objeto;
    }
}
