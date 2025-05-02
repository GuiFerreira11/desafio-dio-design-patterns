package desafio.dio.design_patterns.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Representação de um cliente")
public class Cliente {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Schema(description = "ID único do cliente", example = "1")
  private Long id;
  
  @Schema(description = "Nome do cliente", example = "João Silva")
  private String nome;
  
  @ManyToOne
  @Schema(description = "Endereço do cliente")
  private Endereco endereco;
}
