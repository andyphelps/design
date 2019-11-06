package uk.gov.ukho.dpworkshops.one;

import uk.gov.ukho.dpworkshops.one.services.ActivationService;
import uk.gov.ukho.dpworkshops.one.services.MetadataService;
import uk.gov.ukho.dpworkshops.one.services.UploadService;
import uk.gov.ukho.dpworkshops.one.services.ValidationService;
import uk.gov.ukho.dpworkshops.one.validators.DataValidators;

public class Main {
  public static void main(String[] args) {

    final String content = "1,2,3\n" +
        "4,5,6\n" +
        "7,8,9";

    final Boolean isValid = ValidationService.validate(DataValidators::csvValidator, content);

    if (isValid) {
        final int id = MetadataService.createMetadata("3x3 Matrix of first nine numbers", "Andy Phelps");
        final Boolean wasSuccessful = UploadService.uploadData(id, content);
        if (wasSuccessful) {
            ActivationService.activate(id);
        }
    }
  }
}
