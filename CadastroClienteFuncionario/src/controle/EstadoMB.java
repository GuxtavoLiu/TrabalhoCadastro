package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.EstadoDAO;
import entidade.Estado;

@ManagedBean
@ViewScoped
public class EstadoMB {
	private Estado estado = new Estado();
	private List<Estado> estados = new ArrayList<>();
	private EstadoDAO estadoDAO = new EstadoDAO();

	public EstadoMB() {
		estados = estadoDAO.buscarTodos();
	}

	public void inserir() {
		if (estado.getId() == null) {
			estadoDAO.salvar(estado);
			estados = estadoDAO.buscarTodos();
			estado = new Estado();

		} else {
			estadoDAO.alterar(estado);
		}
	}

	public void excluir(Long id) {
		estadoDAO.excluir(id);
		estados = estadoDAO.buscarTodos();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

}
