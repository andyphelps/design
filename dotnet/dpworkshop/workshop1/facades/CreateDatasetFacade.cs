using System;
using workshop1.services;

namespace workshop1.facades
{
    public static class CreateDatasetFacade
    {
        public static void CreateDataset(string content,
                                        string description,
                                        string author,
                                        Func<String, Boolean> validator)
        {
            bool isValid = ValidationService.Validate(validator, content);

            if (isValid)
            {
                int id = MetadataService.CreateMetadata(description, author);
                bool wasSuccessful = UploadService.UploadData(id, content);
                if (wasSuccessful)
                {
                    ActivationService.Activate(id);
                }
            }
        }
    }
}
