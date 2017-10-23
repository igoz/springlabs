package lab.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Country implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String codeName;

}
