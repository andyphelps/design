using System;

namespace workshop1.models
{
    public class Dataset
    {
        public string Description { get; }
        public string Content { get; }
        public string Author { get; }
        public Func<string, bool> Validator { get; }

        public Dataset(string content, string description, string author, Func<string, bool> validator)
        {
            Content = content;
            Description = description;
            Author = author;
            Validator = validator;
        }
    }
}
