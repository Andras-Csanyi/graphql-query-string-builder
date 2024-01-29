package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders;

public class GraphQLQueryStringGeneratingException extends RuntimeException {
    public GraphQLQueryStringGeneratingException() {
    }

    public GraphQLQueryStringGeneratingException(String message) {
        super(message);
    }

    public GraphQLQueryStringGeneratingException(String message, Throwable cause) {
        super(message, cause);
    }

    public GraphQLQueryStringGeneratingException(Throwable cause) {
        super(cause);
    }

    public GraphQLQueryStringGeneratingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
