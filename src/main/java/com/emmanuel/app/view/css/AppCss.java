package com.emmanuel.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {
    private String style = "<style>\n" +
            "    body {\n" +
            "        background-color: #f0f0f0;\n" +
            "        font-family: Arial, sans-serif;\n" +
            "    }\n" +
            "    .header {\n" +
            "        background-color: #007BFF;\n" +
            "        color: white;\n" +
            "        padding: 20px;\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "    .welcome {\n" +
            "        text-align: center;\n" +
            "        margin: 20px;\n" +
            "    }\n" +
            "    table {\n" +
            "        width: 100%;\n" +
            "        border-collapse: collapse;\n" +
            "        margin: 20px;\n" +
            "    }\n" +
            "    th, td {\n" +
            "        padding: 8px 15px;\n" +
            "        text-align: left;\n" +
            "        border: 1px solid #ddd; /* Add border lines */\n" +
            "    }\n" +
            "    th {\n" +
            "        background-color: #007BFF;\n" +
            "        color: white;\n" +
            "        border: 1px solid #ddd; /* Add border lines to header cells */\n" +
            "    }\n" +
            "    tr:nth-child(even) {\n" +
            "        background-color: #f2f2f2;\n" +
            "    }\n" +
            "    tr:hover {\n" +
            "        background-color: #ddd;\n" +
            "    }\n" +
            "    .analysis-button {\n" +
            "        background-color: #007BFF;\n" +
            "        color: white;\n" +
            "        border: none;\n" +
            "        border-radius: 5px;\n" +
            "        padding: 8px 15px;\n" +
            "        cursor: pointer;\n" +
            "        transition: background-color 0.3s;\n" +
            "    }\n" +
            "    .analysis-button:hover {\n" +
            "        background-color: #0056b3;\n" +
            "    }\n" +
            "    .delete-portfolio-button, .update-portfolio-button {\n" +
            "        background-color: #FF5733; /* Choose your preferred background color */\n" +
            "        color: white;\n" +
            "        border: none;\n" +
            "        border-radius: 5px;\n" +
            "        padding: 8px 15px;\n" +
            "        margin-right: 10px;\n" +
            "        cursor: pointer;\n" +
            "        transition: background-color 0.3s;\n" +
            "    }\n" +
            "    .delete-portfolio-button:hover, .update-portfolio-button:hover {\n" +
            "        background-color: #E24D2A;\n" +
            "    }\n" +
            "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
