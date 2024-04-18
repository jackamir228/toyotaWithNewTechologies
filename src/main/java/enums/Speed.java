package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum Speed {

    CAMRY_SPEED(228),
    SOLARA_SPEED(200),
    DYNA_SPEED(150),
    HIANCE_SPEED(140),
    DEFAULT_SPEED(0);

    final int value;
}
