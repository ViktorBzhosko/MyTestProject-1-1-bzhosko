package by.ita.je.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.String.format;

public class DataIsIncorrectException extends RuntimeException{

    private static final Logger logger= LoggerFactory.getLogger(DataIsIncorrectException.class);

    public DataIsIncorrectException (){
        super(DescribeExceptionForIncorrectData.INCORRECT_DATA.getMessage());
        logger.error(DescribeExceptionForIncorrectData.INCORRECT_DATA.getMessage());
    }
}
