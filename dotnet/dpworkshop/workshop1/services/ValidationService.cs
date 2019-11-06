using System;

namespace workshop1.services
{
    public static class ValidationService
    {
        public static bool Validate(Func<string, bool> validator, string content)
        {
            return validator.Invoke(content);
        }
    }
}
