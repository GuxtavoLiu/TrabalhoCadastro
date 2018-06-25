package banco;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {

	private static EntityManagerFactory fabrica;

	public static EntityManagerFactory get() {
		if (fabrica != null) {
			try {
				fabrica = Persistence.createEntityManagerFactory("cadastroClienteFuncionarioPU");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Fai� a cria��o da f�brica.");
			}
		}
		return fabrica;
	}
}
