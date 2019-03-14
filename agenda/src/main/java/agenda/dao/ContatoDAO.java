package agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import agenda.models.Contato;

@Repository
@Transactional
public class ContatoDAO {
	
	@PersistenceContext //funciona como Container que guarda as entidades que estão sendo gerenciadas pelo EntityManager
	private EntityManager manager; //recurso responsável por realizar as operações de sincronismo com o banco de dados
	
	public void gravar(Contato contato) {
		manager.persist(contato);
	}
	
	public List<Contato> listar(){
		return manager.createQuery("select c from Contato c", Contato.class)
				.getResultList();
	}
	
	public void deletar(Integer id) {
		Contato contato = manager.find(Contato.class, id);
		manager.remove(contato);
	}
	
	/*public Contato findById(Integer id) {
        return manager.createQuery("select from Contato c where c.id = :id", Contato.class).getSingleResult();
	}*/
	
}
