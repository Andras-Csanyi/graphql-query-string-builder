package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.queries;

import com.andrascsanyi.graphqlquerystringbuilder.example.graphql.CertainType;

public class GetCertainTypeWhereFieldIsAnotherTypeQueryBuilder {

    public static class Builder {
        private final String queryName = "getCertainTypeWhereFieldIsAnotherType";
        public String queryName() {
            return queryName;
        }

        private String fields;

        /**
         * Adds the return type fields to the query. The list of fields used in the query
         * is defined in {@link CertainType}.
         *
         * <pre>
         *     query [customQueryName] {
         *         exampleQuery {
         *             # list of fields come here
         *         }
         *     }
         * </pre>
         *
         * @param fields
         * @return
         */
        public Builder fields(String fields) {
            this.fields = fields;
            return this;
        }

        private String customQueryName;

        /**
         * Sets up the provided string as query name.
         *
         * <p>
         * This setup is useful from diagnostics point of view.
         * For example Apollo displays the query names which is useful when
         * we want to know if the query eventually hit the endpoint or not.
         * </p>
         * <p>
         * The result will be the following:
         *
         * <pre>
         *     query [customQueryName] {
         *         exampleQuery {
         *             # list of fields
         *         }
         *     }
         * </pre>
         *
         * @param customQueryName custom query name
         * @return {@link GetScalarTypeQuery.Builder}
         */
        public Builder customQueryName(String customQueryName) {
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
            query.append(fields).append(" ");
            query.append("}");

            return query.toString();
        }
    }
}
