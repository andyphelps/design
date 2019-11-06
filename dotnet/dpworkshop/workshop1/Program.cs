using System;
using workshop1.services;
using workshop1.validators;

namespace workshop1
{
    public class Program
    {
        static void Main()
        {

            string content = "1,2,3\n" +
                "4,5,6\n" +
                "7,8,9";

            bool isValid = ValidationService.Validate(DataValidators.CsvValidator, content);

            if (isValid)
            {
                int id = MetadataService.CreateMetadata("3x3 Matrix of first nine numbers", "Andy Phelps");
                bool wasSuccessful = UploadService.UploadData(id, content);
                if (wasSuccessful)
                {
                    ActivationService.Activate(id);
                }
            }

        }
    }
}
