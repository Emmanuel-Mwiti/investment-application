package com.emmanuel.app.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {

    public String getStyle() {
        return "<style>" +
                "    body {" +
                "        background-color: #f0f0f0;" +
                "        font-family: Arial, sans-serif;" +
                "    }" +
                "    .header {" +
                "        background-color: #007BFF;" +
                "        color: white;" +
                "        padding: 20px;" +
                "        text-align: center;" +
                "    }" +
                "    .welcome {" +
                "        text-align: center;" +
                "        margin: 20px;" +
                "    }" +
                "    table {" +
                "        width: 100%;" +
                "        border-collapse: collapse;" +
                "        margin: 20px;" +
                "    }" +
                "    th, td {" +
                "        padding: 8px 15px;" +
                "        text-align: left;" +
                "        border: 1px solid #ddd;" +
                "    }" +
                "    th {" +
                "        background-color: #007BFF;" +
                "        color: white;" +
                "    }" +
                "    tr:nth-child(even) {" +
                "        background-color: #f2f2f2;" +
                "    }" +
                "    tr:hover {" +
                "        background-color: #ddd;" +
                "    }" +
                "    .analysis-button {" +
                "        background-color: #007BFF;" +
                "        color: white;" +
                "        border: none;" +
                "        border-radius: 5px;" +
                "        padding: 8px 15px;" +
                "        cursor: pointer;" +
                "        transition: background-color 0.3s;" +
                "    }" +
                "    .analysis-button:hover {" +
                "        background-color: #0056b3;" +
                "    }" +
                "    .delete-portfolio-button, .update-portfolio-button {" +
                "        background-color: #FF5733;" +
                "        color: white;" +
                "        border: none;" +
                "        border-radius: 5px;" +
                "        padding: 8px 15px;" +
                "        margin-right: 10px;" +
                "        cursor: pointer;" +
                "        transition: background-color 0.3s;" +
                "    }" +
                "    .delete-portfolio-button:hover, .update-portfolio-button:hover {" +
                "        background-color: #E24D2A;" +
                "    }" +
                "    .topnav {" +
                "        background-color: #333;" +
                "        color: #fff;" +
                "        display: flex;" +
                "        justify-content: space-between;" +
                "        padding: 10px;" +
                "    }" +
                "    .topnav a {" +
                "        margin: 0 10px;" +
                "        font-size: 16px;" +
                "        text-decoration: none;" +
                "        color: #fff;" +
                "    }" +
                "    .topnav a.active {" +
                "        text-decoration: underline;" +
                "    }" +
                "</style>";
    }
}
