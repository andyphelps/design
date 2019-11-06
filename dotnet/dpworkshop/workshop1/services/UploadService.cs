using System;
namespace workshop1.services
{
    public static class UploadService
    {
        public static bool UploadData(int id, string content)
        {
            Console.WriteLine("Stored id " + id + " with content '" + content + "'");
            return true;
        }
    }
}
