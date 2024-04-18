package components;

import enums.ComponentType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Component {

    ComponentType componentType;
    Boolean isWorkable;

    public Component(ComponentType componentType, Boolean isWorkable) {
        this.componentType = componentType;
        this.isWorkable = isWorkable;
    }

    public void turnOn() {
        setIsWorkable(true);
    }

    public void turnOff() {
        setIsWorkable(false);
    }
}
