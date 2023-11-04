package com.emmanuel.app.view.css;

public class AddPortfolioCss {
    /* AddPortfolio.css */
    private String style = "<style>\n" +
            "    .form-container {\n" +
            "        max-width: 400px;\n" +
            "        margin: 0 auto;\n" +
            "        padding: 20px;\n" +
            "        border: 1px solid #ddd;\n" +
            "        border-radius: 5px;\n" +
            "        background-color: #f2f2f2;\n" +
            "    }\n" +
            "    .form-group {\n" +
            "        margin-bottom: 20px;\n" +
            "    }\n" +
            "    .form-label {\n" +
            "        display: block;\n" +
            "        font-weight: bold;\n" +
            "    }\n" +
            "    .form-input {\n" +
            "        width: 100%;\n" +
            "        padding: 10px;\n" +
            "        border: 1px solid #ddd;\n" +
            "        border-radius: 5px;\n" +
            "    }\n" +
            "    .form-button {\n" +
            "        background-color: #007BFF;\n" +
            "        color: white;\n" +
            "        border: none;\n" +
            "        border-radius: 5px;\n" +
            "        padding: 10px 20px;\n" +
            "        cursor: pointer;\n" +
            "    }\n" +
            "    .form-button:hover {\n" +
            "        background-color: #0056b3;\n" +
            "    }\n" +
            "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
