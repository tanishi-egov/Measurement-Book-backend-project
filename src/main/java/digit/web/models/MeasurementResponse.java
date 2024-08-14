package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.egov.common.contract.response.ResponseInfo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

/**
 * Encapsulates a measurement response
 */
@Schema(description = "Encapsulates a measurement response")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:34:09.525730997+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeasurementResponse   {
        @JsonProperty("responseInfo")

          @Valid
                private ResponseInfo responseInfo = null;

        @JsonProperty("measurements")
          @Valid
                private List<Measurement> measurements = null;


        public MeasurementResponse addMeasurementsItem(Measurement measurementsItem) {
            if (this.measurements == null) {
            this.measurements = new ArrayList<>();
            }
        this.measurements.add(measurementsItem);
        return this;
        }

}
