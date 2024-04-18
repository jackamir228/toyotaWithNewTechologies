package enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public enum ComponentType {
    ENGINE,
    LIGHTS,
    ELECTRICIAN,
    CRUISE_CONTROL,
    ROOF,
    USB,
    FRIDGE,
    ROSETTE;
}
