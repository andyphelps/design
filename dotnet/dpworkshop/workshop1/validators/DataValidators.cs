namespace workshop1.validators
{
    public static class DataValidators
    {
        public static bool CsvValidator(string content)
        {
            return content.Contains(",");
        }
       
    }
}
