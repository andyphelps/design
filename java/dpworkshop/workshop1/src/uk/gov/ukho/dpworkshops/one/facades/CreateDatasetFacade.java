package uk.gov.ukho.dpworkshops.one.facades;

import uk.gov.ukho.dpworkshops.one.services.ActivationService;
import uk.gov.ukho.dpworkshops.one.services.MetadataService;
import uk.gov.ukho.dpworkshops.one.services.UploadService;
import uk.gov.ukho.dpworkshops.one.services.ValidationService;

import java.util.function.Function;

public class CreateDatasetFacade {

    public static void createDataset(final String content,
                                     final String description,
                                     final String author,
                                     final Function<String, Boolean> validator) {
        final Boolean isValid = ValidationService.validate(validator, content);

        if (isValid) {
            final int id = MetadataService.createMetadata(description, author);
            final Boolean wasSuccessful = UploadService.uploadData(id, content);
            if (wasSuccessful) {
                ActivationService.activate(id);
            }
        }
    }
}
