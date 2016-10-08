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

@WebServlet(name = "CreateGrantConditionServlet", urlPatterns = {"/CreateGrantConditionServlet"})
public class CreateGrantConditionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoanType loanType = (LoanType) request.getSession().getAttribute("loanType");
        GrantCondition grantCondition = (GrantCondition) request.getSession().getAttribute("grantCondition");
        System.out.println("hkashdfkahsdfkhaksdfhk " + loanType);
        System.out.println("hkashdfkahsdfkhaksdfhk " + grantCondition);


        response.setCharacterEncoding("UTF-8");
      //  response.getWriter().print(html);
    }
}