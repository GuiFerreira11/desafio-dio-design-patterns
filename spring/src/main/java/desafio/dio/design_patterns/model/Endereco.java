package desafio.dio.design_patterns.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Schema(description = "Representação de um endereço")
public class Endereco {

  @Id
  @Schema(description = "CEP do endereço", example = "01001-000")
  private String cep;

  @Schema(description = "Logradouro", example = "Praça da Sé")
  private String logradouro;

  @Schema(description = "Complemento", example = "lado ímpar")
  private String complemento;

  @Schema(description = "Bairro", example = "Sé")
  private String bairro;

  @Schema(description = "Cidade", example = "São Paulo")
  private String localidade;

  @Schema(description = "Estado (UF)", example = "SP")
  private String uf;

  @Schema(description = "Estado", example = "São Paulo")
  private String estado;

  @Schema(description = "Região", example = "Sudeste")
  private String regiao;

  @Schema(description = "IBGE", example = "3550308")
  private String ibge;

  @Schema(description = "Gia", example = "1004")
  private String gia;

  @Schema(description = "DDD", example = "11")
  private String ddd;

  @Schema(description = "Siafi", example = "7107")
  private String siafi;

}
