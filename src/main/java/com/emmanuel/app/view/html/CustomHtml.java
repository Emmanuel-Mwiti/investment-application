package com.emmanuel.app.view.html;

import com.emmanuel.app.view.html.ManuHtmlForm;
import com.emmanuel.app.view.html.ManuHtmlFormField;
import com.emmanuel.app.view.html.ManuTableColumnHeader;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class CustomHtml implements Serializable {
    public static String table(List<?> models) {
        if (models == null || models.isEmpty())
            return StringUtils.EMPTY;

        Field[] fields = models.get(0).getClass().getDeclaredFields();

        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<table><tr>");

        for (Field field : fields) {
            if (!field.isAnnotationPresent(ManuTableColumnHeader.class))
                continue;

            trBuilder.append("<th>").append(field.getAnnotation(ManuTableColumnHeader.class).header()).append("</th>");
        }

        trBuilder.append("</tr>");

        for (Object model : models) {

            trBuilder.append("<tr>");
            for (Field field : fields) {
                if (!field.isAnnotationPresent(ManuTableColumnHeader.class))
                    continue;

                try {
                    field.setAccessible(true);
                    trBuilder.append("<td>").append(field.get(model)).append("</td>");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            trBuilder.append("<tr>");
        }

        trBuilder.append("</table>");

        return trBuilder.toString();
    }

    public static String form(Class<?> model) {
        ManuHtmlForm manuHtmlForm = null;
        if (model.isAnnotationPresent(ManuHtmlForm.class))
            manuHtmlForm = model.getAnnotation(ManuHtmlForm.class);

        if (manuHtmlForm == null)
            return StringUtils.EMPTY;

        String htmlForm = "<br/>Add " + manuHtmlForm.label() + "<br/><form action=\"" + manuHtmlForm.url()
                + "\" method=\"" + manuHtmlForm.httpMethod() + "\">";

        Field[] fields = model.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(ManuHtmlFormField.class))
                continue;

            ManuHtmlFormField formField = field.getAnnotation(ManuHtmlFormField.class);

            String fieldName = field.getName();

            htmlForm += "<label for=\""
                    + (StringUtils.isBlank(formField.labelFor()) ? fieldName : formField.labelFor())
                    + "\">"
                    + (StringUtils.isBlank(formField.label()) ? fieldName : formField.label()) + ":</label><br>";
            htmlForm += "<input type=\"text\" id=\""
                    + (StringUtils.isBlank(formField.id()) ? fieldName : formField.id()) + "\" name=\""
                    + (StringUtils.isBlank(formField.name()) ? fieldName : formField.name()) + "\" ><br>";
        }


        htmlForm += generateInvestmentDetailsForm();

        htmlForm += "<input type=\"submit\" value=\"Submit\">";
        htmlForm += "</form><br/>";

        return htmlForm;
    }

    private static String generateInvestmentDetailsForm() {
        StringBuilder form = new StringBuilder();

        form.append("<h3>Investment Details</h3>");


        form.append("<div class=\"form-group\">");
        form.append("<label class=\"form-label\" for=\"investmentType\">Investment Type:</label>");
        form.append("<select class=\"form-input\" name=\"investmentType[]\">");
        form.append("<option value=\"stocks\">Stocks</option>");
        form.append("<option value=\"bonds\">Bonds</option>");
        form.append("<option value=\"moneyMarket\">Money Market</option>");
        form.append("</select>");
        form.append("</div>");

        form.append("<div class=\"form-group\">");
        form.append("<label class=\"form-label\" for=\"initialAmount\">Initial Amount:</label>");
        form.append("<input class=\"form-input\" type=\"number\" name=\"initialAmount[]\">");
        form.append("</div>");

        form.append("<div class=\"form-group\">");
        form.append("<label class=\"form-label\" for=\"finalAmount\">Final Amount:</label>");
        form.append("<input class=\"form-input\" type=\"number\" name=\"finalAmount[]\">");
        form.append("</div>");

        form.append("<div class=\"form-group\">");
        form.append("<label class=\"form-label\" for=\"targetAllocation\">Target Allocation (%):</label>");
        form.append("<input class=\"form-input\" type=\"number\" name=\"targetAllocation[]\">");
        form.append("</div>");

        return form.toString();
    }
}
