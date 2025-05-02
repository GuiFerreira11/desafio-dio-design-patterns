package desafio.dio.design_patterns.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "Design Patterns API",
        version = "1.0",
        description = "API para demonstração de padrões de projeto com Spring Boot"
    )
)
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Design Patterns API")
                        .version("1.0")
                        .description("API demonstrating design patterns implementation using Spring Boot"));
    }
}

