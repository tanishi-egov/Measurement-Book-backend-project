package digit.controllers;


import digit.util.ResponseInfoFactory;
import digit.web.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.slf4j.Slf4j;
import org.egov.common.contract.response.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.util.*;
import digit.service.measurementBookService;

    import jakarta.validation.constraints.*;
    import jakarta.validation.Valid;
    import jakarta.servlet.http.HttpServletRequest;
        import java.util.Optional;
@jakarta.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2024-07-25T11:34:09.525730997+05:30[Asia/Kolkata]")
@Controller
@Slf4j
    @RequestMapping("")
    public class MeasurementApiController{

        private final ObjectMapper objectMapper;

        private final HttpServletRequest request;

        private final measurementBookService mtbService;

        @Autowired
        private ResponseInfoFactory responseInfoFactory;


        public MeasurementApiController(ObjectMapper objectMapper, HttpServletRequest request, measurementBookService mtbService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.mtbService = mtbService;
        }

                @RequestMapping(value="/measurement/v1/_create", method = RequestMethod.POST)
                public ResponseEntity<MeasurementResponse> measurementV1CreatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody MeasurementRequest measurementRequest) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                                List<Measurement> measurements = mtbService.createMtRequest(measurementRequest);
                                ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(measurementRequest.getRequestInfo(), true);
                                MeasurementResponse response = MeasurementResponse.builder().responseInfo(responseInfo).measurements(measurements).build();
                                return new ResponseEntity<MeasurementResponse>(response, HttpStatus.OK);
//                            return new ResponseEntity<MeasurementResponse>(objectMapper.readValue("{  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"measurements\" : [ {    \"measures\" : [ {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    }, {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    } ],    \"entryDate\" : 6.027456183070403,    \"documents\" : [ null, null ],    \"measurementNumber\" : \"measurementNumber\",    \"tenantId\" : \"pb.jalandhar,dwss\",    \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",    \"physicalRefNumber\" : \"physicalRefNumber\",    \"isActive\" : true,    \"additionalDetails\" : { },    \"referenceId\" : \"Contract number\"  }, {    \"measures\" : [ {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    }, {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    } ],    \"entryDate\" : 6.027456183070403,    \"documents\" : [ null, null ],    \"measurementNumber\" : \"measurementNumber\",    \"tenantId\" : \"pb.jalandhar,dwss\",    \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",    \"physicalRefNumber\" : \"physicalRefNumber\",    \"isActive\" : true,    \"additionalDetails\" : { },    \"referenceId\" : \"Contract number\"  } ]}", MeasurementResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (Exception e) {
                                log.error("Error occurred while processing measurement create request", e);
                                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<MeasurementResponse>(HttpStatus.NOT_ACCEPTABLE);
                }

                @RequestMapping(value="/measurement/v1/_search", method = RequestMethod.POST)
                public ResponseEntity<MeasurementResponse> measurementV1SearchPost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody MeasurementSearchRequest measurementSearchRequest) {
                        String accept = request.getHeader("Accept");
                            if (accept != null && accept.contains("application/json")) {
                            try {
                                List<Measurement> measurements = mtbService.searchMtDetails(measurementSearchRequest);
                                ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(measurementSearchRequest.getRequestInfo(), true);
                                MeasurementResponse response = MeasurementResponse.builder().responseInfo(responseInfo).measurements(measurements).build();
                                return new ResponseEntity<MeasurementResponse>(response, HttpStatus.OK);
//                            return new ResponseEntity<MeasurementResponse>(objectMapper.readValue("{  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"measurements\" : [ {    \"measures\" : [ {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    }, {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    } ],    \"entryDate\" : 6.027456183070403,    \"documents\" : [ null, null ],    \"measurementNumber\" : \"measurementNumber\",    \"tenantId\" : \"pb.jalandhar,dwss\",    \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",    \"physicalRefNumber\" : \"physicalRefNumber\",    \"isActive\" : true,    \"additionalDetails\" : { },    \"referenceId\" : \"Contract number\"  }, {    \"measures\" : [ {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    }, {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    } ],    \"entryDate\" : 6.027456183070403,    \"documents\" : [ null, null ],    \"measurementNumber\" : \"measurementNumber\",    \"tenantId\" : \"pb.jalandhar,dwss\",    \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",    \"physicalRefNumber\" : \"physicalRefNumber\",    \"isActive\" : true,    \"additionalDetails\" : { },    \"referenceId\" : \"Contract number\"  } ]}", MeasurementResponse.class), HttpStatus.NOT_IMPLEMENTED);
                            } catch (Exception e) {
                                log.error("Error occurred while processing measurement search request", e);
                                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                            }

                        return new ResponseEntity<MeasurementResponse>(HttpStatus.NOT_ACCEPTABLE);
                }

//                @RequestMapping(value="/measurement/v1/_update", method = RequestMethod.POST)
//                public ResponseEntity<MeasurementResponse> measurementV1UpdatePost(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody MeasurementRequest body) {
//                        String accept = request.getHeader("Accept");
//                            if (accept != null && accept.contains("application/json")) {
//                            try {
//                            return new ResponseEntity<MeasurementResponse>(objectMapper.readValue("{  \"responseInfo\" : {    \"ver\" : \"ver\",    \"resMsgId\" : \"resMsgId\",    \"msgId\" : \"msgId\",    \"apiId\" : \"apiId\",    \"ts\" : 0,    \"status\" : \"SUCCESSFUL\"  },  \"measurements\" : [ {    \"measures\" : [ {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    }, {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    } ],    \"entryDate\" : 6.027456183070403,    \"documents\" : [ null, null ],    \"measurementNumber\" : \"measurementNumber\",    \"tenantId\" : \"pb.jalandhar,dwss\",    \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",    \"physicalRefNumber\" : \"physicalRefNumber\",    \"isActive\" : true,    \"additionalDetails\" : { },    \"referenceId\" : \"Contract number\"  }, {    \"measures\" : [ {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    }, {      \"comments\" : \"comments\",      \"targetId\" : \"contractlineitemid\",      \"breadth\" : 200,      \"documents\" : [ {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      }, {        \"documentType\" : \"documentType\",        \"documentUid\" : \"documentUid\",        \"fileStore\" : \"fileStore\",        \"id\" : \"id\",        \"additionalDetails\" : { }      } ],      \"length\" : 200,      \"isActive\" : true,      \"additionalDetails\" : { },      \"referenceId\" : \"measurementId\",      \"numItems\" : 1.4658129805029452,      \"auditDetails\" : {        \"lastModifiedTime\" : 7,        \"createdBy\" : \"createdBy\",        \"lastModifiedBy\" : \"lastModifiedBy\",        \"createdTime\" : 2      },      \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",      \"currentValue\" : 5.962133916683182,      \"cumulativeValue\" : 5.637376656633329,      \"height\" : 200    } ],    \"entryDate\" : 6.027456183070403,    \"documents\" : [ null, null ],    \"measurementNumber\" : \"measurementNumber\",    \"tenantId\" : \"pb.jalandhar,dwss\",    \"id\" : \"251c51eb-e970-4e01-a99a-70136c47a934\",    \"physicalRefNumber\" : \"physicalRefNumber\",    \"isActive\" : true,    \"additionalDetails\" : { },    \"referenceId\" : \"Contract number\"  } ]}", MeasurementResponse.class), HttpStatus.NOT_IMPLEMENTED);
//                            } catch (IOException e) {
//                            return new ResponseEntity<MeasurementResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
//                            }
//                            }
//
//                        return new ResponseEntity<MeasurementResponse>(HttpStatus.NOT_IMPLEMENTED);
//                }

        }