package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import digit.web.models.MeasurementService;
import digit.web.models.RequestInfo;
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
 * Encapsulates a measurement book service request. Takes a singleton along with workflow.
 */
@Schema(description = "Encapsulates a measurement book service request. Takes a singleton along with workflow.")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:34:09.525730997+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeasurementServiceRequest   {
        @JsonProperty("requestInfo")

          @Valid
                private RequestInfo requestInfo = null;

        @JsonProperty("measurements")
          @Valid
                private List<MeasurementService> measurements = null;


        public MeasurementServiceRequest addMeasurementsItem(MeasurementService measurementsItem) {
            if (this.measurements == null) {
            this.measurements = new ArrayList<>();
            }
        this.measurements.add(measurementsItem);
        return this;
        }

}
