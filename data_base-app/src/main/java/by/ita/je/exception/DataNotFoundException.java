package by.ita.je.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataNotFoundException extends RuntimeException {

    private final static Logger logger = LogManager.getLogger(DataNotFoundException.class);

    public DataNotFoundException() {
        super(DescribeExceptionForNoData.DESCRIBE_EXCEPTION.getMessage());
        logger.error(DescribeExceptionForNoData.DESCRIBE_EXCEPTION.getMessage());

    }
}
