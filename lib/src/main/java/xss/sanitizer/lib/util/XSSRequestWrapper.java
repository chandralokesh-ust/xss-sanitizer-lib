package xss.sanitizer.lib.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSRequestWrapper extends HttpServletRequestWrapper {

    public XSSRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        return InputSanitizer.sanitize(value);
    }

    @Override
    public String[] getParameterValues(String parameter) {

        String[] values = super.getParameterValues(parameter);

        if (values == null) {
            return null;
        }

        String[] sanitizedValues = new String[values.length];

        for (int i = 0; i < values.length; i++) {
            sanitizedValues[i] = InputSanitizer.sanitize(values[i]);
        }

        return sanitizedValues;
    }

}
