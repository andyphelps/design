package uk.gov.ukho.dpworkshops.one;

import uk.gov.ukho.dpworkshops.one.facades.CreateDatasetFacade;
import uk.gov.ukho.dpworkshops.one.validators.DataValidators;

public class Main {
  public static void main(final String[] args) {

    final String content = "1,2,3\n" +
        "4,5,6\n" +
        "7,8,9";

      CreateDatasetFacade.createDataset(content,
              "3x3 Matrix of first nine numbers",
              "Andy Phelps",
              DataValidators::csvValidator);
  }
}
