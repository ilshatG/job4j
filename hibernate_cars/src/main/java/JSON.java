import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JSON extends HttpServlet {
    private final Logic logic = Logic.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = "SELECT ad.id, brands.name AS brand, models.name AS model, year, price, car_meleage, engine_volume, transmission.name AS transmission, " +
                "power_of_engine, car_body.name AS car_body, drive.name AS drive, engine_type.name as fuel FROM ad " +
                "LEFT OUTER JOIN brands ON brands.id=brand_id " +
                "LEFT OUTER JOIN models ON models.id=model_id " +
                "LEFT OUTER JOIN transmission ON transmission.id=transmission " +
                "LEFT OUTER JOIN car_body ON car_body.id=car_body " +
                "LEFT OUTER JOIN drive ON drive.id=drive " +
                "LEFT OUTER JOIN engine_type ON engine_type.id=engine_type;"
                ;
        ObjectMapper mapper = new ObjectMapper();
        java.util.List items = logic.getListFromSQL(query);
        mapper.writeValue(resp.getOutputStream(), items);
    }

}