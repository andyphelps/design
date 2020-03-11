package uk.gov.ukho.dpworkshops.two.facades;

import uk.gov.ukho.dpworkshops.two.events.EventManager;
import uk.gov.ukho.dpworkshops.two.events.EventType;
import uk.gov.ukho.dpworkshops.two.models.Dataset;
import uk.gov.ukho.dpworkshops.two.services.ActivationService;
import uk.gov.ukho.dpworkshops.two.services.MetadataService;
import uk.gov.ukho.dpworkshops.two.services.UploadService;
import uk.gov.ukho.dpworkshops.two.services.ValidationService;

public class CreateDatasetFacade {

  public static void createDataset(final Dataset dataset, final EventManager eventManager) {
    final Boolean isValid = ValidationService.validate(dataset.getValidator(), dataset.getContent());

    if (isValid) {
      final int id = MetadataService.createMetadata(dataset.getDescription(), dataset.getAuthor());
      final Boolean wasSuccessful = UploadService.uploadData(id, dataset.getContent());

      if (wasSuccessful) {
        eventManager.emit(EventType.DATASET_UPLOADED, dataset);
        ActivationService.activate(id);
        eventManager.emit(EventType.DATASET_ACTIVATED, dataset);
      }
    }
  }
}
