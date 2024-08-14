package digit.enrichment;


import digit.web.models.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class enrichMeasurement {
    public void enrichMeasurementRequest(MeasurementRequest measurementRequest)
    {
        for(Measurement measurement : measurementRequest.getMeasurements())
        {
            measurement.setId(UUID.randomUUID().toString());

            String userId = measurementRequest.getRequestInfo().getUserInfo().getUuid();
            AuditDetails auditDetails = AuditDetails.builder().createdBy(userId).lastModifiedBy(userId).createdTime(System.currentTimeMillis()).lastModifiedTime(System.currentTimeMillis()).build();
            measurement.setAuditDetails(auditDetails);

            for(Document document : measurement.getDocuments())
            {
                document.setMeasurementId(measurement.getId());
                document.setId(UUID.randomUUID().toString());
            }

            for(Measure measure : measurement.getMeasures())
            {
                measure.setId(UUID.randomUUID().toString());
                measure.setReferenceId(measurement.getId());
                measure.setAuditDetails(auditDetails);
                measure.setDocuments(measurement.getDocuments());
            }


        }
    }
}
