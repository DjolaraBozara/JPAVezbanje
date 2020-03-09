package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.RequestDelegate;

@WebServlet("/math")
public class Math extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Math() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int a = 0;
		int b = 0;
		int c = 0;
		
		boolean signal = true;
		String parametarA = request.getParameter("a");
		
		try {
			if (parametarA.isEmpty())
				throw new Exception("Insert number...");
			a = Integer.parseInt(parametarA);
			// proslo....
		} catch (Exception e) {
			signal = false;
			// greska ili je prazno ili nista nije uneto

			request.setAttribute("errorA", "A is not number!");

		}

		String parametarB = request.getParameter("b");

		try {
			if (parametarB.isEmpty())
				throw new Exception("Insert number...");
			a = Integer.parseInt(parametarB);
			// proslo....
		} catch (Exception e) {
			signal = false;
			// greska ili je prazno ili nista nije uneto

			request.setAttribute("errorB", "B is not number!");

		}
		 if(!signal) {
		        if(request.getParameter("plus") != null) {
			c = a+b;
		    }
		    else if (request.getParameter("minus") != null) {
			   c = a-b;
		    }
	   }
	   else {
		request.setAttribute("errorC", "Invalid values, cannot calculate!");
	}

	request.setAttribute("parametarA", parametarA);
	request.setAttribute("parametarB", parametarB);
	request.setAttribute("parametarC", c);




	RequestDispatcher rd = request.getRequestDispatcher("math.jsp");
	rd.forward(request, response);


	}
	}
