package components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Wheel {
    Boolean isBroken;
    Integer diameter;

    public Wheel(Integer diameter, Boolean isBroken) {
        this.diameter = diameter;
        this.isBroken = isBroken;
    }
}
