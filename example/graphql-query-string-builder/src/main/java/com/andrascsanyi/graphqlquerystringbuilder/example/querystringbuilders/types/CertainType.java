package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import com.andrascsanyi.graphql_query_string_builder_example.AnotherType;
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
        private String anotherTypeFields;

        /**
         * Adds <b>anotherType</b> field to the list of queried fields.
         *
         * @return {@link Builder}
         */
        public Builder anotherType() {
            this.isAnotherTypeQueried = true;
            return this;
        }

        /**
         * Adds <b>anotherType</b> field to the list of queried fields.
         *
         * @param isAnotherTypeQueried switch
         * @return {@link Builder}
         */
        public Builder anotherType(Boolean isAnotherTypeQueried) {
            this.isAnotherTypeQueried = isAnotherTypeQueried;
            return this;
        }

        /**
         * Fields of {@link AnotherType} type going to be queried in GQL string format.
         * This string is built by {@link AnotherType.Builder}.
         *
         * @param fields the list of fields in GQL text format
         * @return {@link Builder}
         */
        public Builder anotherTypeFields(String fields) {
            this.anotherTypeFields = fields;
            return this;
        }

        private final static String anotherTypeFieldString = "anotherType";
        private Boolean isAnotherTypeQueried = false;

        /**
         * Builds the Graphql query string for {@link CertainType}.
         *
         * <p>
         * Since {@link com.andrascsanyi.graphql_query_string_builder_example.CertainType#getAnotherType()} 
         * is not scalar type building includes validation.
         * Invalid configuration will throw {@link GraphQLQueryStringGeneratingException}.
         * </p>
         *
         * @return the GraphQL string
         */
        public String build() {

            // validation
            if (isAnotherTypeQueried
                    && (anotherTypeFields.isEmpty() || anotherTypeFields.isBlank())) {
                String msg = """
                        CertainType#anotherType is type of AnotherType.
                        The settings says that it is queried but no list of fields provided.
                        please use the CertainType.Builder.anotherTypeFields() method to provide list of fields
                        to be queried, or disable querying this field.
                        """;
                throw new GraphQLQueryStringGeneratingException(msg);
            }

            StringBuilder builder = new StringBuilder();
            
            builder.append("{").append(" ");

            if (isIdFieldQueried) {
                builder.append(idFieldString).append(" ");
            }

            if (isNameFieldQueried) {
                builder.append(nameFieldString).append(" ");
            }

            if (isAnotherTypeQueried) {
                builder.append(anotherTypeFieldString).append(" ");

                builder.append(anotherTypeFields);
            }
            
            builder.append("}");
            
            return builder.toString();
        }
    }
}
