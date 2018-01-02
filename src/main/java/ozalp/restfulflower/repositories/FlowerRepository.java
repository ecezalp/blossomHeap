package ozalp.restfulflower.repositories;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ozalp.restfulflower.domain.Flower;
import ozalp.restfulflower.domain.rowMappers.FlowerRowMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class FlowerRepository {

  private NamedParameterJdbcTemplate template;

  public FlowerRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.template = namedParameterJdbcTemplate;
  }

  public List<Flower> findAll() {
    String sql = "SELECT * FROM flowers";
    return template.query(sql, new FlowerRowMapper());
  }

  public Flower create(Flower flower) {
    String sql = "INSERT INTO flowers (ID, COLOR, PETAL_COUNT, PETAL_SHAPE, CENTER_COLOR, USER_ID) \n" +
      "VALUES (DEFAULT, :color, :petal_count, :petal_shape, :center_color, :user_id)";

    KeyHolder keyHolder = new GeneratedKeyHolder();

    template.update(sql, new MapSqlParameterSource()
      .addValue("color", flower.getColor())
      .addValue("petal_count", flower.getPetalCount())
      .addValue("petal_shape", flower.getPetalShape())
      .addValue("center_color", flower.getCenterColor())
      .addValue("user_id", flower.getUserId()), keyHolder);

    return find((Long) keyHolder.getKey()).get();
  }

  public Optional<Flower> find(Long id) {
    String sql = "SELECT * FROM flowers WHERE ID = :id";

    List<Flower> flowers = template.query(sql, new MapSqlParameterSource()
      .addValue("id", id), new FlowerRowMapper());

    return flowers.isEmpty() ? Optional.empty() : Optional.of(flowers.get(0));
  }
}

