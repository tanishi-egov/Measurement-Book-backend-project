package digit.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
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
 * This defines a measurement with or without detailed measures.
 */
@Schema(description = "This defines a measurement with or without detailed measures.")
@Validated
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:34:09.525730997+05:30[Asia/Kolkata]")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Measurement   {
        @JsonProperty("id")

          @Valid
                private String id = null;

        @JsonProperty("tenantId")

        @Size(min=2,max=64)         private String tenantId = null;

        @JsonProperty("measurementNumber")

        @Size(min=2,max=64)         private String measurementNumber = null;

        @JsonProperty("physicalRefNumber")

        @Size(min=2,max=100)         private String physicalRefNumber = null;

        @JsonProperty("referenceId")
          @NotNull

        @Size(min=2,max=64)         private String referenceId = null;

        @JsonProperty("entryDate")
          @NotNull

          @Valid
                private BigDecimal entryDate = null;

        @JsonProperty("measures")
          @Valid
                private List<Measure> measures = null;

        @JsonProperty("isActive")

                private Boolean isActive = true;

        @JsonProperty("documents")
          @Valid
        @Size(min=1)         private List<Document> documents = null;

        @JsonProperty("auditDetails")

          @Valid
                private AuditDetails auditDetails = null;

        @JsonProperty("additionalDetails")

                private Object additionalDetails = null;


        public Measurement addMeasuresItem(Measure measuresItem) {
            if (this.measures == null) {
            this.measures = new ArrayList<>();
            }
        this.measures.add(measuresItem);
        return this;
        }

        public Measurement addDocumentsItem(Document documentsItem) {
            if (this.documents == null) {
            this.documents = new ArrayList<>();
            }
        this.documents.add(documentsItem);
        return this;
        }

}
