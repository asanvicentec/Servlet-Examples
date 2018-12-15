import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Xavi Torrens
 */
public class HelloServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World en branca test";
        Object o = Injector.object;
        System.out.println("Servlet " + HelloServlet.class.getName() + " OK");

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();



        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");

        // Create cookies for first and last names.
        Cookie firstName = new Cookie("first_name",
                first_name);
        Cookie lastName = new Cookie("last_name",
                last_name);

        // Set expiry date after 24 Hrs for both the cookies.
        firstName.setMaxAge(60*60*24);
        lastName.setMaxAge(60*60*24);

        // Add both the cookies in the response header.
        response.addCookie( firstName );
        response.addCookie( lastName );

        // Set response content type
        response.setContentType("text/html");


        String title = "Using POST Method to Read Form Data";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>First Name</b>: "
                + first_name + "\n" +
                "  <li><b>Last Name</b>: "
                + last_name + "\n" +
                "  <li><b>Fisica</b>: "
                + request.getParameter("fisica") + "</li>\n" +
                "  <li><b>Mates</b>: "
                + request.getParameter("mates") + "</li>\n" +
                "  <li><b>Quimica</b>: "
                + request.getParameter("quimica") + "</li>\n" +
                "</ul>\n" +
                "</body></html>");

    }


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {



        // Set response content type
        response.setContentType("text/html");

        String nom = request.getParameter("nom");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + " " + nom + "</h1>");
    }

    public void destroy()
    {
        System.out.println("Hello World!!!");
    }


}
