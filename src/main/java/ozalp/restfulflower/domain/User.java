package ozalp.restfulflower.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String userId;
  private String firstName;
  private String lastName;
  private String handle;
  private String tag;
  private String createdAt;
}




