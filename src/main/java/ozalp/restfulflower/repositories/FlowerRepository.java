package ozalp.restfulflower.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ozalp.restfulflower.domain.Flower;

@RepositoryRestResource(collectionResourceRel = "flowers", path = "flowers")
public interface FlowerRepository extends JpaRepository<Flower, Long> {
}

