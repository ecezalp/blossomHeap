package ozalp.restfulflower.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ozalp.restfulflower.domain.Flower;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "flowers", path = "flowers")
public interface FlowerRepository extends PagingAndSortingRepository<Flower, Long> {
  List<Flower> findByColor(@Param("color") String color);
}