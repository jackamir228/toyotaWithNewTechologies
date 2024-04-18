package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum CarryingCapacity {

    DEFAULT_CAPACITY(0), DYNA_CAPACITY(1488), HIANCE_CAPACITY(1232);

    int value;
}
