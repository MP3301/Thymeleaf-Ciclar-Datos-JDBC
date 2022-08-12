package mx.com.gm.web;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

@Controller
@Slf4j
public class ControladorInicio {

   @Autowired
   private PersonaDao personaDao;

   @GetMapping("/")
   public String inicio(Model model) {
      Iterable<Persona> personasIterable = personaDao.findAll();

     // List<Persona> personas = new ArrayList<>();
    //  personasIterable.forEach(personas::add);

      log.info("ejecutando el controlador Spring MVC");
      model.addAttribute("personas", personasIterable);
      return "index";
   }
}
