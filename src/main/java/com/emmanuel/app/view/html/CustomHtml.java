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

        StringBuilder htmlForm = new StringBuilder("<br/>Add " + manuHtmlForm.label() + "<br/><form action=\"" + manuHtmlForm.url()
                + "\" method=\"" + manuHtmlForm.httpMethod() + "\">");

        Field[] fields = model.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(ManuHtmlFormField.class))
                continue;

            ManuHtmlFormField formField = field.getAnnotation(ManuHtmlFormField.class);

            String fieldName = field.getName();

            htmlForm.append("<label for=\"").append(StringUtils.isBlank(formField.labelFor()) ? fieldName : formField.labelFor()).append("\">").append(StringUtils.isBlank(formField.label()) ? fieldName : formField.label()).append(":</label><br>");
            htmlForm.append("<input type=\"text\" id=\"").append(StringUtils.isBlank(formField.id()) ? fieldName : formField.id()).append("\" name=\"").append(StringUtils.isBlank(formField.name()) ? fieldName : formField.name()).append("\" ><br>");
        }
        htmlForm.append("<input type=\"submit\" value=\"Submit\">");
        htmlForm.append("</form><br/>");

        return htmlForm.toString();
    }



}
