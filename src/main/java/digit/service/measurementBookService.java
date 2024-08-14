package digit.service;

import digit.enrichment.enrichMeasurement;
import digit.kafka.Producer;
import digit.repository.MeasurementRepository;
import digit.web.models.Measurement;
import digit.web.models.MeasurementRequest;
import digit.web.models.MeasurementSearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class measurementBookService {

    @Autowired
    private Producer producer;
    @Autowired
    private enrichMeasurement enrichmentUtil;
    @Autowired
    private MeasurementRepository repository;

    public List<Measurement> createMtRequest(MeasurementRequest measurementRequest)
    {
        log.info("inside service ----------" + measurementRequest.toString());
        enrichmentUtil.enrichMeasurementRequest(measurementRequest);
        producer.push("save-mt-book", measurementRequest);
        return measurementRequest.getMeasurements();
    }

    public List<Measurement> searchMtDetails(MeasurementSearchRequest searchRequest)
    {
        List<Measurement> measurementList = repository.getMeasurements(searchRequest.getCriteria());
        return measurementList;
    }
}
