package ozalp.restfulflower.domain.rowMappers;

import org.springframework.jdbc.core.RowMapper;
import ozalp.restfulflower.domain.Flower;


import java.sql.ResultSet;
import java.sql.SQLException;

public class FlowerRowMapper implements RowMapper<Flower> {

  @Override
  public Flower mapRow(ResultSet rs, int rowNum) throws SQLException {
    return Flower.builder()
      .id(rs.getLong("ID"))
      .userId(rs.getLong("USER_ID"))
      .color(rs.getString("COLOR"))
      .centerColor(rs.getString("CENTER_COLOR"))
      .petalCount(rs.getLong("PETAL_COUNT"))
      .centerColor(rs.getString("CENTER_COLOR"))
      .creationDate(rs.getString("CREATION_DATE"))
      .build();
  }
}
