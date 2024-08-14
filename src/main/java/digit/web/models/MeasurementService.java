package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.AuditDetails;
import digit.web.models.Document;
import digit.web.models.Measure;
import digit.web.models.Measurement;
import digit.web.models.Workflow;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * MeasurementService
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:34:09.525730997+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class MeasurementService extends Measurement  {
        @JsonProperty("wfStatus")

                private String wfStatus = null;

        @JsonProperty("workflow")

          @Valid
                private Workflow workflow = null;


}
