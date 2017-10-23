package lab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import lab.domain.Country;
import org.springframework.jdbc.core.RowMapper;

public class CountryRowMapper implements RowMapper<Country> {
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String CODE_NAME = "code_name";

	public Country mapRow(ResultSet resultSet, int i) throws SQLException {
		Country country = new Country();
		country.setId(resultSet.getInt(ID));
		country.setName(resultSet.getString(NAME));

		country.setCodeName(resultSet.getString(CODE_NAME));
		return country;
	}
}
