package lab.dao;

import java.util.List;
import lab.domain.Country;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class HsqlCountryDao extends JdbcDaoSupport implements CountryDao {

	private static Log log = LogFactory.getLog(HsqlCountryDao.class);

	private static final String GET_ALL_COUNTRIES_SQL = "select * from country";

	private static final CountryRowMapper COUNTRY_ROW_MAPPER = new CountryRowMapper();

	@Override
	public void insert(Country country) {
		if (country != null) {
			log.debug( "Processing country: " + country);
			this.getJdbcTemplate().update(
					"insert into country (name, code_name) values (?, ?)",
					country.getName(), country.getCodeName());

		} else {
			log.debug("Domain country is null!");
		}
	}

	@Override
	public Country select(int id) {

		Country country = null;

		if (id > 0) {
			country = this.getJdbcTemplate().queryForObject(
					"select id, name, code_name from country where id = ?",
					new Object[] { id }, new CountryRowMapper());
		}
		log.debug("Receidved country: " + country);

		return country;
	}

	@Override
	public List<Country> selectAll() {
		return getJdbcTemplate().query(
				GET_ALL_COUNTRIES_SQL, COUNTRY_ROW_MAPPER);
	}
}
