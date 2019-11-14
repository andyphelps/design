package uk.gov.ukho.dpworkshops.two.validators;

public class DataValidators {

  public static Boolean csvValidator(final String content) {
    return content.contains(",");
  }
}
