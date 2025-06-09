package infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

    @NotBlank(message = "Field firstname cannot be empty or null")
    private String firstname;
    @NotBlank(message = "Field lastname cannot be empty or null")
    private String lastname;
    @NotBlank(message = "Field address cannot be empty or null")
    private String address;
    @NotNull(message = "Field age cannot be null")
    private Integer age;

}
