package kosmos.consultorio.controller;

import kosmos.consultorio.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

  private final DoctorService doctorService;

  public DoctorController(DoctorService doctorService) {
    this.doctorService = doctorService;
  }

  @GetMapping("/consulta")
  public String getDoctores(Model model) {
    model.addAttribute("listDoctores", doctorService.getDoctores());
    return "doctor/consulta";
  }
}
