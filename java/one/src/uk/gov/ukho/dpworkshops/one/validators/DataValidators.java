package uk.gov.ukho.dpworkshops.one.validators;

public class DataValidators {

  public static Boolean csvValidator(final String content) {
    return content.contains(",");
  }
}
