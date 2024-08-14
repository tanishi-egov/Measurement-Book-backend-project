package digit.repository.queryBuilder;

import digit.web.models.MeasurementCriteria;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class QueryBuilder {
    private final String BASE_QUERY = " SELECT mtb.id as mtid, mtb.tenantId as mttenantId, mtb.measurementNumber as mtmeasurementNumber, mtb.physicalRefNumber as mtphysicalRefNumber, mtb.referenceId as mtreferenceId, mtb.entryDate as mtentryDate, mtb.isActive as mtisActive, mtb.createdBy as mtcreatedBy, mtb.lastModifiedBy as mtlastModifiedBy, mtb.createdTime as mtcreatedTime, mtb.lastModifiedTime as mtlastModifiedTime, ";

    private final String MEASURES_QUERY = " ms.id as mid, ms.referenceId as mreferenceId, ms.targetId as mtargetId, ms.length as mlength, ms.breadth as mbreadth, ms.height as mheight, ms.numItems as mnumItems, ms.currentValue as mcurrentValue, ms.cumulativeValue as mcumulativeValue, ms.isActive as misActive, ms.comments as mcomments, ";

    private final String DOCUMENTS_QUERY = " doc.id as dcid, doc.measurementId as dcmeasurementId, doc.documentType as dcdocumentType, doc.fileStore as dcfileStore,  doc.documentUid as dcdocumentUid ";

    private final String FROM_TABLES = " FROM measurement mtb LEFT JOIN measures ms ON mtb.id = ms.referenceId LEFT JOIN documents doc ON doc.measurementId = mtb.id ";

    private final String ORDERBY = " ORDER BY mtb.createdTime DESC ";

    public String getSearchQuery(MeasurementCriteria criteria, List<Object> preparedStmtList)
    {
        StringBuilder query = new StringBuilder(BASE_QUERY);
        query.append(MEASURES_QUERY);
        query.append(DOCUMENTS_QUERY);
        query.append(FROM_TABLES);

        if(!CollectionUtils.isEmpty(criteria.getIds()))
        {
            addClause(query, preparedStmtList);
            query.append(" mtb.id IN ( ");
            appendPlaceholder(query, criteria.getIds());
            query.append(" ) ");
            preparedStmtList.addAll(criteria.getIds());
        }

        if(!ObjectUtils.isEmpty(criteria.getMeasurementNumber()))
        {
            addClause(query, preparedStmtList);
            query.append(" mtb.measurementNumber = ? ");
            preparedStmtList.add(criteria.getMeasurementNumber());
        }

        if(!CollectionUtils.isEmpty(criteria.getReferenceId()))
        {
            addClause(query, preparedStmtList);
            query.append(" mtb.referenceId IN ( ");
            appendPlaceholder(query, criteria.getReferenceId());
            query.append(" ) ");
            preparedStmtList.addAll(criteria.getReferenceId());
        }

        query.append(ORDERBY);
        return query.toString();
    }

    private void addClause(StringBuilder query, List<Object> preparedStmtList)
    {
        if(preparedStmtList.isEmpty())
        {
            query.append(" WHERE ");
        }
        else query.append(" AND ");
    }

    private void appendPlaceholder(StringBuilder query, List<String> ids)
    {
        for(int i = 0; i<ids.size()-1; i++)
        {
            query.append("?, ");
        }
        query.append("?");
    }
}
