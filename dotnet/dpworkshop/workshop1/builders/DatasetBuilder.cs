using System;
using workshop1.models;
using workshop1.validators;

namespace workshop1.builders
{
    public class DatasetBuilder
    {
        private string _content = "";
        private string _description;
        private string _author = "Unknown Author";
        private Func<string, bool> _validator = DataValidators.CsvValidator;

        public static DatasetBuilder Builder()
        {
            return new DatasetBuilder();
        }

        public DatasetBuilder Description(string description)
        {
            _description = description;
            return this;
        }

        public DatasetBuilder Author(string author)
        {
            _author = author;
            return this;
        }

        public DatasetBuilder Validator(Func<string, bool> validator)
        {
            _validator = validator;
            return this;
        }

        public DatasetBuilder AddRow(string row)
        {
            _content += row + "\n";
            return this;
        }

        public Dataset Build()
        {
            CheckReadyToBuild();
            return new Dataset(_content.TrimEnd(), _description, _author, _validator);
        }

        private void CheckReadyToBuild()
        {
            if (_content == "")
            {
                throw new ArgumentException("Content must be set");
            }

            if (_description == null)
            {
                throw new ArgumentException("Description must be set");
            }
        }
    }
}
