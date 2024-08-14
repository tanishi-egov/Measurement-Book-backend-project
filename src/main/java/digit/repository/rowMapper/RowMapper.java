package digit.repository.rowMapper;

import digit.web.models.*;
//import org.egov.common.contract.models.AuditDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Slf4j
@Component
public class RowMapper implements ResultSetExtractor<List<Measurement>> {
    public List<Measurement> extractData(ResultSet rs) throws SQLException , DataAccessException{
        log.info(rs.toString());
        log.info("rowMapper");
        Map<String, Measurement> measurementMap = new LinkedHashMap<>();
        Map<String, Measure> measuresMap = new LinkedHashMap<>();
        Map<String, Document> documentMap = new LinkedHashMap<>();

        while(rs.next()) {

            String uuid = rs.getString("mtid");
            Measurement measurement = measurementMap.get(uuid);

            if(measurement == null)
            {
                String tenantId = rs.getString("mttenantId");
                String measurementNumber = rs.getString("mtmeasurementNumber");
                String physicalRefNumber = rs.getString("mtphysicalRefNumber");
                String referenceId = rs.getString("mtreferenceId");
                BigDecimal entryDate = rs.getBigDecimal("mtentryDate");
                Boolean isActive = rs.getBoolean("mtisActive");

                AuditDetails auditdetails = AuditDetails.builder()
                        .createdBy(rs.getString("mtcreatedBy"))
                        .createdTime(rs.getLong("mtcreatedTime"))
                        .lastModifiedBy(rs.getString("mtlastModifiedBy"))
                        .lastModifiedTime(rs.getLong("mtlastModifiedTime"))
                        .build();

                measurement = Measurement.builder()
                        .id(uuid)
                        .tenantId(tenantId)
                        .measurementNumber(measurementNumber)
                        .physicalRefNumber(physicalRefNumber)
                        .referenceId(referenceId)
                        .entryDate(entryDate)
                        .isActive(isActive)
                        .auditDetails(auditdetails)
                        .measures(new ArrayList<>())
                        .documents(new ArrayList<>()).build();

                measurementMap.put(uuid, measurement);
            }
            else measurement = measurementMap.get(uuid);


            // ADDING MEASURE
            String measureId = rs.getString("mid");
            Measure measure = measuresMap.get(measureId);
            if(measure == null)
                addMeasureToMeasurement(rs, measurement, measuresMap);


            // ADDING DOCUMENT
            String documentId = rs.getString("dcid");
            Document document = documentMap.get(documentId);
            if(document == null)
                addDocumentToMeassurement(rs, measurement, documentMap);

            log.info("added 1 item");
        }
        return new ArrayList<>(measurementMap.values());
    }

    private void addMeasureToMeasurement(ResultSet rs, Measurement measurement, Map<String, Measure> measureMap) throws SQLException, DataAccessException {
        String measureId = rs.getString("mid");
        if(measureId != null)
        {
            Measure measure = Measure.builder()
                    .id(measureId)
                    .referenceId(rs.getString("mreferenceId"))
                    .targetId(rs.getString("mtargetId"))
                    .length(rs.getBigDecimal("mlength"))
                    .breadth(rs.getBigDecimal("mbreadth"))
                    .height(rs.getBigDecimal("mheight"))
                    .numItems(rs.getBigDecimal("mnumItems"))
                    .currentValue(rs.getBigDecimal("mcurrentValue"))
                    .cumulativeValue(rs.getBigDecimal("mcumulativeValue"))
                    .isActive(rs.getBoolean("misActive"))
                    .comments(rs.getString("mcomments"))
                    .auditDetails(measurement.getAuditDetails()).build();

            measureMap.put(measureId, measure);
            measurement.getMeasures().add(measure);
        }
    }

    private void addDocumentToMeassurement(ResultSet rs, Measurement measurement, Map<String, Document> documentMap) throws SQLException , DataAccessException{
        String documentId = rs.getString("dcid");
        if (documentId != null) {
            Document document = Document.builder()
                    .id(documentId)
                    .measurementId(rs.getString("dcmeasurementId"))
                    .documentType(rs.getString("dcdocumentType"))
                    .fileStore(rs.getString("dcfileStore"))
                    .documentUid(rs.getString("dcdocumentUid"))
                    .build();

            documentMap.put(documentId, document);
            measurement.getDocuments().add(document);
        }
    }
}
