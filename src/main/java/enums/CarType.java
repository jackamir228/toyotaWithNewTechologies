package enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum CarType {
    CAMRY(new BigDecimal(10_000), new BigDecimal(5_000)),
    SOLARA(new BigDecimal(12_000), new BigDecimal(8_000)),
    DYNA(new BigDecimal(22_000), new BigDecimal(12_000)),
    HIANCE(new BigDecimal(15_000), new BigDecimal(10_000)),
    NULL_CAR(new BigDecimal(0), new BigDecimal(0));

    final BigDecimal price;
    final BigDecimal costPrice;
}
