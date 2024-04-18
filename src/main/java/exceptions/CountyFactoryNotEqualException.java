package exceptions;

import enums.Country;

public class CountyFactoryNotEqualException extends RuntimeException {
    public CountyFactoryNotEqualException(String message) {
        System.out.printf("");
    }

    public CountyFactoryNotEqualException(String message, Country country, Country country1) {
    }
}
