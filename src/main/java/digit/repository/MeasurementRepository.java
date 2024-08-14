package digit.repository;

import digit.repository.queryBuilder.QueryBuilder;
import digit.repository.rowMapper.RowMapper;
import digit.web.models.Measurement;
import digit.web.models.MeasurementCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class MeasurementRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private RowMapper rowMapper;

    public List<Measurement> getMeasurements(MeasurementCriteria searchCriteria)
    {
        List<Object> preparedStmtList = new ArrayList<>();
        String query = queryBuilder.getSearchQuery(searchCriteria, preparedStmtList);
        log.info("query = " + query);
        return  jdbcTemplate.query(query, preparedStmtList.toArray(), rowMapper);
    }

}
