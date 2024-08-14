CREATE TABLE measurement(
  id VARCHAR(64),
  tenantId VARCHAR(64),
  measurementNumber VARCHAR(64),
  physicalRefNumber VARCHAR(100),
  referenceId VARCHAR(64),
  entryDate VARCHAR(64),
  isActive BOOLEAN,
  createdBy VARCHAR(64),
  lastModifiedBy VARCHAR(64),
  createdTime BIGINT,
  lastModifiedTime BIGINT,
  CONSTRAINT uk_measurement_id PRIMARY KEY (id)
);

CREATE TABLE measures(
   id VARCHAR(64),
   referenceId VARCHAR(64),
   targetId VARCHAR(64),
   "length" INT,
   breadth INT,
   height INT,
   numItems INT,
   currentValue INT,
   cumulativeValue INT,
   isActive BOOLEAN,
   comments VARCHAR(256),

   CONSTRAINT uk_measures_id PRIMARY KEY (id),
   CONSTRAINT fk_measures FOREIGN KEY (referenceId) REFERENCES measurement (id)
     ON UPDATE CASCADE
     ON DELETE CASCADE
);

CREATE TABLE documents(
    id VARCHAR(64),
    measurementId VARCHAR(64),
    documentType VARCHAR(64),
    fileStore VARCHAR(64),
    documentUid VARCHAR(64),

    CONSTRAINT fk_documents FOREIGN KEY (measurementId) REFERENCES measurement (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)