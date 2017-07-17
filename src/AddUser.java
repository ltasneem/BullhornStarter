import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bhuser;
import customTools.DbUser;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddUser() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		//This page does not require user to be logged in
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userMotto = request.getParameter("userMotto");
		String nextURL = "/error.jsp";
		//check if user exists (by email)
		Bhuser u = DbUser.getUserByEmail(userEmail);
		
		//create user and add them if they don't exit
		if (u == null){
			u = new Bhuser();
			u.setUsername(userName);
			u.setUseremail(userEmail);
			u.setUserpassword(userPassword);
			u.setMotto(userMotto);
			session.setAttribute("user", u);
			DbUser.insert(u);
			nextURL = "/home.jsp";
		}else{
			String message = "You have an account - ";
			request.setAttribute("message", message);
			nextURL = "/login.jsp";
		}
		//redirect to next page as indicated by the value of the nextURL variable
		getServletContext().getRequestDispatcher(nextURL).forward(request,response);
	}

}