package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import banco.Fabrica;
import entidade.Estado;

public class EstadoDAO {

	private EntityManager manager;
	private EntityTransaction t;

	// Salvar
	public Estado salvar(Estado estado) {
		manager = Fabrica.get().createEntityManager();
		t = manager.getTransaction();

		try {
			t.begin();
			manager.persist(estado);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return estado;
	}

	// Excluir
	public boolean excluir(Long id) {
		manager = Fabrica.get().createEntityManager();
		t = manager.getTransaction();
		try {
			Estado estado = manager.find(Estado.class, id);
			if (estado != null) {
				t.begin();
				manager.remove(estado);
				t.commit();
				return true;
			}
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}

		return false;
	}

	public Estado alterar(Estado estado) {
		manager = Fabrica.get().createEntityManager();
		t = manager.getTransaction();
		try {
			t.begin();
			manager.merge(estado);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return estado;
	}

	public Estado buscar(Long id) {
		manager = Fabrica.get().createEntityManager();
		return manager.find(Estado.class, id);
	}

	public List<Estado> buscarTodos() {
		manager = Fabrica.get().createEntityManager();
		try {
			return manager.createQuery("from Estado").getResultList();
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}
}