package ozalp.restfulflower.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ozalp.restfulflower.domain.Flower;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "flowers", path = "flowers")
public interface FlowerRepository extends JpaRepository<Flower, Long> {
  List<Flower> findByColor(@Param("color") String color);

  <S extends Flower> List<S> save(Iterable<S> var1);

}

