package com.emmanuel.home;

import com.emmanuel.app.bean.PortfolioBeanI;
import com.emmanuel.app.bean.impl.PortfolioBeanImpl;
import com.emmanuel.app.model.Portfolio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/home")
public class Home extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PortfolioBeanI portfolioBean = new PortfolioBeanImpl();

        PrintWriter print = resp.getWriter();

        print.write("<!DOCTYPE html>");
        print.write("<html lang=\"en\">");
        print.write("<head>");
        print.write("    <meta charset=\"UTF-8\">");
        print.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        print.write("    <title>Investment App Homepage</title>");
        print.write("    <style>");
        print.write("        body {");
        print.write("            background-color: #f0f0f0;");
        print.write("            font-family: Arial, sans-serif;");
        print.write("        }");
        print.write("        .header {");
        print.write("            background-color: #007BFF;");
        print.write("            color: white;");
        print.write("            padding: 20px;");
        print.write("            text-align: center;");
        print.write("        }");
        print.write("        .welcome {");
        print.write("            text-align: center;");
        print.write("            margin: 20px;");
        print.write("        }");
        print.write("        .portfolio-container {");
        print.write("            display: flex;");
        print.write("            justify-content: space-around;");
        print.write("            flex-wrap: wrap;");
        print.write("            padding: 20px;");
        print.write("        }");
        print.write("        .portfolio-card {");
        print.write("            background-color: #fff;");
        print.write("            border: 1px solid #ddd;");
        print.write("            border-radius: 5px;");
        print.write("            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);");
        print.write("            margin: 10px;");
        print.write("            width: 300px;");
        print.write("            padding: 15px;");
        print.write("        }");
        print.write("        .portfolio-card h3 {");
        print.write("            color: #007BFF;");
        print.write("            font-size: 1.5rem;");
        print.write("            margin: 0;");
        print.write("        }");
        print.write("        .portfolio-description {");
        print.write("            color: #555;");
        print.write("            margin: 10px 0;");
        print.write("        }");
        print.write("        ul {");
        print.write("            list-style: none;");
        print.write("            padding: 0;");
        print.write("        }");
        print.write("        li {");
        print.write("            color: #333;");
        print.write("            margin: 5px 0;");
        print.write("        }");
        print.write("        .performance {");
        print.write("            display: flex;");
        print.write("            justify-content: space-between;");
        print.write("            align-items: center;");
        print.write("        }");
        print.write("        .performance p {");
        print.write("            color: #4CAF50;");
        print.write("            font-weight: bold;");
        print.write("        }");
        print.write("        .analysis-button {");
        print.write("            background-color: #007BFF;");
        print.write("            color: white;");
        print.write("            border: none;");
        print.write("            border-radius: 5px;");
        print.write("            padding: 10px 20px;");
        print.write("            cursor: pointer;");
        print.write("            transition: background-color 0.3s;");
        print.write("        }");
        print.write("        .analysis-button:hover {");
        print.write("            background-color: #0056b3;");
        print.write("        }");
        print.write("    </style>");
        print.write("</head>");
        print.write("<body>");
        print.write("<div class=\"header\">");
        print.write("    <h1>Welcome Back, Emmanuel Mwiti!</h1>");
        print.write("    <p>Logged in at (dynamic log time and date)</p>");
        print.write("</div>");
        print.write("<div class=\"welcome\">");
        print.write("    <p>This is your investment dashboard.</p>");
        print.write("</div>");
        print.write("<div class=\"portfolio-container\">");
        print.write(portfolioBean.portfolios());
        print.write("</div>");
        print.write("</body>");
        print.write("</html>");

    }
}
