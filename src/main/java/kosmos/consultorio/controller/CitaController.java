package kosmos.consultorio.controller;

import kosmos.consultorio.dto.request.AltaCitaRequest;
import kosmos.consultorio.dto.request.CitaFiltroRequest;
import kosmos.consultorio.service.CitaService;
import kosmos.consultorio.service.ConsultorioService;
import kosmos.consultorio.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/cita")
public class CitaController {

  private final ConsultorioService consultorioService;

  private final DoctorService doctorService;

  private final CitaService citaService;
  public CitaController(ConsultorioService consultorioService, DoctorService doctorService,
      CitaService citaService) {
    this.consultorioService = consultorioService;
    this.doctorService = doctorService;
    this.citaService = citaService;
  }

  @GetMapping("/alta")
  public String altaCita(Model model) {
    model.addAttribute("listDoctores", doctorService.getDoctores());
    model.addAttribute("listConsultorios", consultorioService.getConsultorios());
    model.addAttribute("altaCitaRequest", new AltaCitaRequest());
    return "cita/alta";
  }

  @PostMapping("/alta")
  public RedirectView addBook(@ModelAttribute("altaCitaRequest") AltaCitaRequest altaCitaRequest,
      RedirectAttributes redirectAttributes) {
    final RedirectView redirectView = new RedirectView("/cita/alta", true);
    redirectAttributes.addFlashAttribute("cita", citaService.saveCita(altaCitaRequest));
    redirectAttributes.addFlashAttribute("altaSuccess", true);
    return redirectView;
  }

  @GetMapping("/consulta")
  public String consultaCita(Model model) {
    return "consulta-cita";
  }


  @PostMapping(value = "/consulta", consumes = "application/json")
  public ResponseEntity<?> getCitasFiltro(@RequestBody CitaFiltroRequest citaFiltroRequest) {
    return new ResponseEntity<>(citaService.getCitasFiltro(citaFiltroRequest), HttpStatus.OK);
  }
}
