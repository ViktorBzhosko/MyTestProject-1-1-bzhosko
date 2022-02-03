package by.ita.je.exception;

public enum DescribeExceptionForNoData {
    DESCRIBE_EXCEPTION("Not found");

    private final String message;

    DescribeExceptionForNoData(String message) {
        this.message = message;
    }
    public String getMessage() {
       return message;
    }
}
