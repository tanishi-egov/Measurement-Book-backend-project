ALTER TABLE measures
  ALTER COLUMN "length" TYPE NUMERIC(10, 2),
  ALTER COLUMN breadth TYPE NUMERIC(10, 2),
  ALTER COLUMN height TYPE NUMERIC(10, 2),
  ALTER COLUMN numItems TYPE NUMERIC(10, 2),
  ALTER COLUMN currentValue TYPE NUMERIC(10, 2),
  ALTER COLUMN cumulativeValue TYPE NUMERIC(10, 2);
