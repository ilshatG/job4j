package servlets.echoservlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JSON extends HttpServlet {
    Map<String, Person> persons = new ConcurrentHashMap();
    ObjectMapper mapper = new ObjectMapper();
    String result = "nothing";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PrintWriter writer = resp.getWriter();
        writer.println(result);*/

        mapper.writeValue(resp.getOutputStream(), persons);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // This will store all received articles
        //List<Article> articles = new LinkedList<Article>();
            // 1. get received JSON data from request
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String json = "";
        if (br != null) {
            json = br.readLine();
            result = json;
        }
        // 2. initiate jackson mapper


        // 3. Convert received JSON to Person
        Person person = mapper.readValue(json, Person.class);
        persons.put(person.getSurname(), person);
        // 6. Send List<Article> as JSON to client
        mapper.writeValue(resp.getOutputStream(), persons);
        //doGet(req, resp);
    }
}
