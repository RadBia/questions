package pl.redx.project.questions.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.redx.project.questions.dto.HealthCheckDto;

@RestController
@RequestMapping("/api/health")
public class HealthCheckRestController {

    @GetMapping("/check") //doprecyzowanie ścieżki, jeśli chcemy
    public HealthCheckDto healthCheck() {
        HealthCheckDto dto = new HealthCheckDto(true, "It's working!");
        return dto;
    }
}

