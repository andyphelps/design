using workshop1.models;
using workshop1.services;

namespace workshop1.facades
{
    public static class CreateDatasetFacade
    {
        public static void CreateDataset(Dataset dataset)
        {
            bool isValid = ValidationService.Validate(dataset.Validator, dataset.Content);

            if (isValid)
            {
                int id = MetadataService.CreateMetadata(dataset.Description, dataset.Author);
                bool wasSuccessful = UploadService.UploadData(id, dataset.Content);

                if (wasSuccessful)
                {
                    ActivationService.Activate(id);
                }
            }
        }
    }
}
