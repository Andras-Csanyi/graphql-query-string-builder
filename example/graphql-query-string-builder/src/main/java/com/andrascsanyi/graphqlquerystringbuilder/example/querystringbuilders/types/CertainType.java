package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import com.andrascsanyi.graphqlquerystringbuilder.example.graphql.AnotherType;
import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.GraphQLQueryStringGeneratingException;

public class CertainType {

    public static class Builder {

        // id field
        private String id;

        /**
         * Adds <b>id</b> field to the list of queried fields.
         *
         * @return {@link Builder}
         */
        public Builder id() {
            this.isIdFieldQueried = true;
            return this;
        }

        /**
         * Adds <b>id</b> field to the list of queried fields.
         *
         * @param isIdFieldQueried switch
         * @return {@link Builder}
         */
        public Builder id(Boolean isIdFieldQueried) {
            this.isIdFieldQueried = isIdFieldQueried;
            return this;
        }

        private final static String idFieldString = "id";
        private Boolean isIdFieldQueried = false;


        // name field
        private String name;

        /**
         * Adds <b>name</b> field to the list of queried fields.
         *
         * @return {@link Builder}
         */
        public Builder name() {
            this.isNameFieldQueried = true;
            return this;
        }

        /**
         * Adds <b>name</b> field to the list of queried fields.
         *
         * @param isNameFieldQueried switch
         * @return {@link Builder}
         */
        public Builder name(Boolean isNameFieldQueried) {
            this.isNameFieldQueried = isNameFieldQueried;
            return this;
        }

        private final static String nameFieldString = "name";
        private Boolean isNameFieldQueried = false;


        // anotherType field
        private String anotherType;
        private String anotherTypeQueriedFields;

        /**
         * Adds <b>anotherType</b> field to the list of queried fields.
         *
         * @return {@link Builder}
         */
        public Builder queriedAnotherTypeFields() {
            this.isAnotherTypeQueried = true;
            return this;
        }

        /**
         * Adds <b>anotherType</b> field to the list of queried fields.
         *
         * @param isAnotherTypeQueried switch
         * @return {@link Builder}
         */
        public Builder queriedAnotherTypeFields(String anotherTypeQueriedFields) {
            this.anotherTypeQueriedFields = anotherTypeQueriedFields;
            return this;
        }

        private final static String anotherTypeFieldString = "anotherType";
        private Boolean isAnotherTypeQueried = false;

        /**
         * Builds the Graphql query string for {@link CertainType}.
         *
         * <p>
         * Since {@link CertainType#getAnotherType()}
         * is not scalar type building includes validation.
         * Invalid configuration will throw {@link GraphQLQueryStringGeneratingException}.
         * </p>
         *
         * @return the GraphQL string
         */
        public String build() {

            StringBuilder builder = new StringBuilder();
            
            builder.append("{").append(" ");

            if (isIdFieldQueried) {
                builder.append(idFieldString).append(" ");
            }

            if (isNameFieldQueried) {
                builder.append(nameFieldString).append(" ");
            }

            if (anotherTypeQueriedFields != null && !anotherTypeQueriedFields.isEmpty()) {
                builder.append(anotherTypeFieldString).append(" ");

                builder.append(anotherTypeQueriedFields);
            }
            
            builder.append("}");
            
            return builder.toString();
        }
    }
}
