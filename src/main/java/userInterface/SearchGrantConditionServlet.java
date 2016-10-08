package userInterface;

import dataAccess.entity.GrantCondition;
import dataAccess.entity.LoanType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchGrantConditionServlet", urlPatterns = {"/SearchGrantConditionServlet"})
public class SearchGrantConditionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoanType loanType = (LoanType) request.getSession().getAttribute("loanType");
        GrantCondition grantCondition = (GrantCondition) request.getSession().getAttribute("grantCondition");
        System.out.println("hkashdfkahsdfkhaksdfhk " + loanType);
        System.out.println("hkashdfkahsdfkhaksdfhk " + grantCondition);

        GrantCondition grantCondition1 = new GrantCondition(1, "s", "مشسنیتب", "s", "1", "2");
        GrantCondition grantCondition2 = new GrantCondition(2, "r", "بمستنیب", "r", "1", "2");
        GrantCondition grantCondition3 = new GrantCondition(3, "k", "k", "k", "1", "2");
        GrantCondition grantCondition4 = new GrantCondition(4, "بشبشسیب", "m", "m", "1", "2");
        GrantCondition grantCondition5 = new GrantCondition(5, "n", "n", "n", "1", "2");

        List<GrantCondition> grantConditionList = new ArrayList<GrantCondition>();

        grantConditionList.add(grantCondition1);
        grantConditionList.add(grantCondition2);
        grantConditionList.add(grantCondition3);
        grantConditionList.add(grantCondition4);
        grantConditionList.add(grantCondition5);

        System.out.println(grantConditionList);

        String html = getGrantConditionsTable(grantConditionList);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(html);
    }


    private String getGrantConditionsTable(List<GrantCondition> grantConditionList) {
        String beginHtml = "<center>" + "<table>" +
                "<caption> Grant Conditions: </caption>" +
                "<th> id </th> \n" +
                "<th> name </th> \n" +
                "<th> minDuration </th> \n" +
                "<th> maxDuration </th> \n" +
                "<th> minCost </th> \n" +
                "<th> maxCost </th> \n";

        String tableRows = "";
        for (GrantCondition grantCondition : grantConditionList) {
            tableRows +=
                    "<tr >" + "<td>" + grantCondition.getId() + "</td>\n" +
                            "<td>" + grantCondition.getName() + "</td>\n" +
                            "<td>" + grantCondition.getMinDuration() + "</td>\n" +
                            "<td>" + grantCondition.getMaxDuration() + "</td>\n" +
                            "<td>" + grantCondition.getMinCost() + "</td>\n" +
                            "<td>" + grantCondition.getMaxCost() + "</td>\n" +
                            "</tr>";
        }

        String endHtml =
                "</table>" + "</center>";

        return beginHtml + tableRows + endHtml;
    }
}