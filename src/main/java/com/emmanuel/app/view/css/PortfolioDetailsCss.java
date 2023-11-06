package com.emmanuel.app.view.css;

public class PortfolioDetailsCss {
    private String style = "<style>\n" +
            ".portfolio-details {\n" +
            "    max-width: 600px;\n" +
            "    margin: 0 auto;\n" +
            "    padding: 20px;\n" +
            "    border: 1px solid #ddd;\n" +
            "    border-radius: 5px;\n" +
            "    background-color: #f2f2f2;\n" +
            "    text-align: left;\n" +
            "}\n" +
            ".analyze-risk-button,\n" +
            ".add-investment-button {\n" +
            "    background-color: #007BFF;\n" +
            "    color: white;\n" +
            "    border: none;\n" +
            "    border-radius: 5px;\n" +
            "    padding: 10px 20px;\n" +
            "    margin: 10px;\n" +
            "    cursor: pointer;\n" +
            "}\n" +
            ".analyze-risk-button:hover,\n" +
            ".add-investment-button:hover {\n" +
            "    background-color: #0056b3;\n" +
            "}\n" +
            ".button-container {\n" +
            "    display: flex;\n" +
            "    justify-content: space-between;\n" +
            "    }\n" +
            "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
