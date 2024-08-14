package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.Measurement;
//import digit.web.models.RequestInfo;
import org.egov.common.contract.request.RequestInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Encapsulates a measurement entry request
 */
@Schema(description = "Encapsulates a measurement entry request")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:34:09.525730997+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeasurementRequest   {
        @JsonProperty("RequestInfo")

          @Valid
                private RequestInfo requestInfo = null;

        @JsonProperty("measurements")
          @Valid
        @Size(min=1)         private List<Measurement> measurements = null;


        public MeasurementRequest addMeasurementsItem(Measurement measurementsItem) {
            if (this.measurements == null) {
            this.measurements = new ArrayList<>();
            }
        this.measurements.add(measurementsItem);
        return this;
        }

}
