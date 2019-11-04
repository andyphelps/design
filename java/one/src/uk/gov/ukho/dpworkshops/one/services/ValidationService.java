package uk.gov.ukho.dpworkshops.one.services;

import java.util.function.Function;

public class ValidationService {

  public static Boolean validate(final Function<String, Boolean> validator, final String content) {
    return validator.apply(content);
  }
}
