package uk.gov.ukho.dpworkshops.one.facades;

import uk.gov.ukho.dpworkshops.one.models.Dataset;
import uk.gov.ukho.dpworkshops.one.services.ActivationService;
import uk.gov.ukho.dpworkshops.one.services.MetadataService;
import uk.gov.ukho.dpworkshops.one.services.UploadService;
import uk.gov.ukho.dpworkshops.one.services.ValidationService;

public class CreateDatasetFacade {

    public static void createDataset(final Dataset dataset) {
        final Boolean isValid = ValidationService.validate(dataset.getValidator(), dataset.getContent());

        if (isValid) {
            final int id = MetadataService.createMetadata(dataset.getDescription(), dataset.getAuthor());
            final Boolean wasSuccessful = UploadService.uploadData(id, dataset.getContent());

            if (wasSuccessful) {
                ActivationService.activate(id);
            }
        }
    }
}
