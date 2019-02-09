package servlets.echoservlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContextListener implements ServletContextListener {
    //private final ValidateService logic = ValidateService.getInstance();
    @Override
    public void contextInitialized(ServletContextEvent event) {
        List<TownCountry> townCountries = new ArrayList();
        townCountries.add(new TownCountry("Russia", "Moskow"));
        townCountries.add(new TownCountry("Russia", "Stalingrad"));
        townCountries.add(new TownCountry("Russia", "Rostov"));
        townCountries.add(new TownCountry("Zimbabwe", "Harare"));
        townCountries.add(new TownCountry("Afganistan", "Kabul"));
        townCountries.add(new TownCountry("Afganistan", "Mazarasharif"));

        event.getServletContext().setAttribute("townContriesList", townCountries);

        //Unique set of countries
        Set<String> countries = new HashSet<>();
        for(TownCountry item : townCountries) {
            countries.add(item.getCountry());
        }
        event.getServletContext().setAttribute("countries", countries);

        ObjectMapper mapper = new ObjectMapper();
        String allTowns = "";
        try {
            allTowns = mapper.writeValueAsString(townCountries);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        event.getServletContext().setAttribute("townsCountries", allTowns);

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }
}
