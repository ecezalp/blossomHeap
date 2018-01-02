package ozalp.restfulflower.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flower {

  private Long id;
  private Long userId;

  private Long petalCount;
  private String petalShape;

  private String color;
  private String centerColor;

  private String creationDate;
}