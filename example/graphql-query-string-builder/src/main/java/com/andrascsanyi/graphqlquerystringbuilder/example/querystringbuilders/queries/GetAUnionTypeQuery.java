package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.queries;

public class GetAUnionTypeQuery {
    public static class Builder {
        private final String queryName = "getAUnionType";
        public String queryName() { return queryName; }

        private String fooTypeQueriedFields;

        private Builder fooTypeQueriedFields(String fooTypeQueriedFields) {
            this.fooTypeQueriedFields = fooTypeQueriedFields;
            return this;
        }

        private String customQueryName;

        private Builder customQueryName(String customQueryName) {
            this.customQueryName = customQueryName;
            return this;
        }

        public String build() {
            StringBuilder query = new StringBuilder("query ");

            if(customQueryName != null) {
                query.append(customQueryName).append(" ");
            }

            query.append("{").append(" ");
            query.append(queryName).append(" ");
            query.append(fooTypeQueriedFields).append(" ");
            query.append("}");

            return query.toString();
        }
    }
}
