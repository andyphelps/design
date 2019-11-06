using workshop1.builders;
using workshop1.facades;
using workshop1.models;

namespace workshop1
{
    public class Program
    {
        static void Main()
        {
            Dataset dataset = DatasetBuilder
                .Builder()
                .AddRow("1,2,3")
                .AddRow("4,5,6")
                .AddRow("7,8,9")
                .Description("3x3 Matrix of first nine numbers")
                .Build();

            CreateDatasetFacade.CreateDataset(dataset);
        }
    }
}
