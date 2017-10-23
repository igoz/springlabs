package lab.mvc.form.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFormBean {

	@NotNull(message="{NotNull.userFormBean.firstName}")
	@Size(min = 2, max = 20)
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;
}
