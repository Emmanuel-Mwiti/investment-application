package com.emmanuel.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {
    private String style = "<style>" +
            "        body {" +
            "            background-color: #f0f0f0;" +
            "            font-family: Arial, sans-serif;" +
            "        }" +
            "        .header {" +
            "            background-color: #007BFF;" +
            "            color: white;" +
            "            padding: 20px;" +
            "            text-align: center;" +
            "        }" +
            "        .welcome {" +
            "            text-align: center;" +
            "            margin: 20px;" +
            "        }" +
            "        table {" +
            "            width: 100%;" +
            "            border-collapse: collapse;" +
            "            margin: 20px;" +
            "        }" +
            "        th, td {" +
            "            padding: 8px 15px;" +
            "            text-align: left;" +
            "            border: 1px solid #ddd; /* Add border lines */" +
            "        }" +
            "        th {" +
            "            background-color: #007BFF;" +
            "            color: white;" +
            "            border: 1px solid #ddd; /* Add border lines to header cells */" +
            "        }" +
            "        tr:nth-child(even) {" +
            "            background-color: #f2f2f2;" +
            "        }" +
            "        tr:hover {" +
            "            background-color: #ddd;" +
            "        }" +
            "        .analysis-button {" +
            "            background-color: #007BFF;" +
            "            color: white;" +
            "            border: none;" +
            "            border-radius: 5px;" +
            "            padding: 8px 15px;" +
            "            cursor: pointer;" +
            "            transition: background-color 0.3s;" +
            "        }" +
            "        .analysis-button:hover {" +
            "            background-color: #0056b3;" +
            "        }" +
            "    </style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
