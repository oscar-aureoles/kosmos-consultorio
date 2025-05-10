package kosmos.consultorio.controller;

import kosmos.consultorio.service.ConsultorioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consultorio")
public class ConsultorioController {

  private final ConsultorioService consultorioService;

  public ConsultorioController(ConsultorioService consultorioService) {
    this.consultorioService = consultorioService;
  }

  @GetMapping("/consulta")
  public String getConsultorios(Model model) {
    model.addAttribute("listConsultorios", consultorioService.getConsultorios());
    return "consultorio/consulta";
  }
}
