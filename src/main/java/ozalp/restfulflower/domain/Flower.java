package ozalp.restfulflower.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Flower {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String color;

  private String border;
}