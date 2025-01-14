package digit.web.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * MeasurementCriteria
 */
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:34:09.525730997+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeasurementCriteria   {
        @JsonProperty("referenceId")

                private List<String> referenceId = null;

        @JsonProperty("measurementNumber")

                private String measurementNumber = null;

        @JsonProperty("ids")

                private List<String> ids = null;


        public MeasurementCriteria addReferenceIdItem(String referenceIdItem) {
            if (this.referenceId == null) {
            this.referenceId = new ArrayList<>();
            }
        this.referenceId.add(referenceIdItem);
        return this;
        }

        public MeasurementCriteria addIdsItem(String idsItem) {
            if (this.ids == null) {
            this.ids = new ArrayList<>();
            }
        this.ids.add(idsItem);
        return this;
        }

}
