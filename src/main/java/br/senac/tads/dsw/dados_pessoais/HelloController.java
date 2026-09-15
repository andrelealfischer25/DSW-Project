package br.senac.tads.dsw.dados_pessoais;
import tools.jackson.databind.json.JsonMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Mensagem hello() {
        return new Mensagem("André", "Olá, mundo! Meu primeiro endpoint Spring Boot.");
    }

    @GetMapping(value = "/hello-manual", produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloManual() {
        Mensagem mensagem = new Mensagem("André", "JSON gerado manualmente com JsonMapper.");
        JsonMapper mapper = JsonMapper.builder().build();
        return mapper.writeValueAsString(mensagem);
    }
}
