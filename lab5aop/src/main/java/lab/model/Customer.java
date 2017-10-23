package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Person {
    private String name;
    private boolean broke;

    public Customer(String name) {
        this.name = name;
    }

    public void sayHello(Person person) {
    }
}
