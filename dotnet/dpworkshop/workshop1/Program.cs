using workshop1.facades;
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

            CreateDatasetFacade.CreateDataset(content,
                "3x3 Matrix of first nine numbers", "Andy Phelps",
                DataValidators.CsvValidator);
        }
    }
}
