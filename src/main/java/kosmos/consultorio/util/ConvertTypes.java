package kosmos.consultorio.util;


import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConvertTypes {

  private final String pattern = "yyyy-MM-dd";

  private final SimpleDateFormat formato = new SimpleDateFormat(pattern, new Locale("es", "ES"));

  private final String patternHora = "HH:mm";

  private final SimpleDateFormat formatoHora = new SimpleDateFormat(patternHora, new Locale("es", "ES"));
  public Date transformStringDate(String fecha) {
    try {
      return formato.parse(fecha);
    } catch (ParseException e) {
      log.error("Error al parsear la fecha: " + fecha);
      log.error("Dettalle del error: " + e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public Time transformStringTime(String hora) {
    try {
      return new Time(formatoHora.parse(hora).getTime());
    } catch (ParseException e) {
      log.error("Error al parsear la hora: " + hora);
      log.error("Dettalle del error: " + e.getMessage());
      throw new RuntimeException(e);
    }
  }
}
