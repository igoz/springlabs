package lab.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.stereotype.Repository;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager em = emf.createEntityManager();

		if (em != null) {
			EntityTransaction transaction = em.getTransaction();

			transaction.begin();
			em.persist(country);
			transaction.commit();

			em.close();
		}
	}

	@Override
	public List<Country> getAllCountries() {
		EntityManager em = emf.createEntityManager();

		List<Country> countries = new ArrayList<>();
		if (em != null) {
			countries = em.createQuery("FROM Country", Country.class).getResultList();

			em.close();
		}

		return countries;
	}

	@Override
	public Country getCountryByName(String name) {
		EntityManager em = emf.createEntityManager();

		if (em != null) {
			Country country = em.createQuery(
					"SELECT c FROM Country c WHERE c.name LIKE :name",
					Country.class)
					.setParameter("name", name)
					.getSingleResult();

			em.close();

			return country;
		}

		return null;
	}
}
