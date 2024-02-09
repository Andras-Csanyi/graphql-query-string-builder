package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import java.util.ArrayList;
import java.util.List;

public class FooType {
    public static class Builder {

        private Boolean isIdFieldQueried = false;
        private final static String idFieldString = "id";

        public Builder id() {
            this.isIdFieldQueried = true;
            return this;
        }

        public Builder id(Boolean isIdFieldQueried) {
            this.isIdFieldQueried = isIdFieldQueried;
            return this;
        }

        private Boolean isNameFieldQueried = false;
        private final static String nameFieldString = "name";

        public Builder name() {
            this.isNameFieldQueried = true;
            return this;
        }

        public Builder name(Boolean isNameFieldQueried) {
            this.isNameFieldQueried = isNameFieldQueried;
            return this;
        }

        private Boolean isAddressFieldQueried = false;
        private final static String addressFieldString = "address";

        public Builder address() {
            this.isAddressFieldQueried = true;
            return this;
        }

        public Builder address(Boolean isAddressFieldQueried) {
            this.isAddressFieldQueried = isAddressFieldQueried;
            return this;
        }

        private final static String somethingFieldString = "something";

        private List<String> somethingTypeQueriedFields = new ArrayList<>();

        /**
         * Adds the query string of {@link com.andrascsanyi.graphqlquerystringbuilder.example.graphql.FirstUnionType} to
         * the builder.
         *
         * <p>This method includes one of the union type names for better workflow.</p>
         *
         * <p>
         * The result will look like this:
         * <pre>
         *  query {customQueryName}{
         *      somethingQuery {
         *          id
         *          name
         *          somethingType {
         *              ... on FirstUnionType {
         *                  # queried FirstUnionType fields
         *              }
         *          }
         *      }
         *  }
         * </pre>
         * </p>
         *
         * @param firstUnionQueriedFields the queried fields string
         * @return {@link Builder}
         */
        public Builder somethingFieldFirstUnionTypeQueriedField(String firstUnionQueriedFields) {
            this.somethingTypeQueriedFields.add(firstUnionQueriedFields);
            return this;
        }

        public Builder somethingFieldSecondUnionTypeQueriedField(String secondUnionQueriedFields) {
            this.somethingTypeQueriedFields.add(secondUnionQueriedFields);
            return this;
        }

        public Builder somethingFieldThirdUnionTypeQueriedField(String thirdUnionQueriedFields) {
            this.somethingTypeQueriedFields.add(thirdUnionQueriedFields);
            return this;
        }

        /**
         * Adds the provided query string to {@link com.andrascsanyi.graphqlquerystringbuilder.example.graphql.FooType#something}
         * field.
         *
         * <p>This method makes possible to pass raw string which will be injected directly.</p>
         * <p>
         * <pre>
         *         query {customQueryName} {
         *             queryName {
         *                 id
         *                 name
         *                 somethingUnionType {
         *                     # the string will be injected here
         *                 }
         *             }
         *         }
         *     </pre>
         * </p>
         *
         * @param unionTypesQueryString the raw query string
         * @return
         */
        public Builder somethingFieldUnionsQueryString(String unionTypesQueryString) {
            this.somethingTypeQueriedFields.add(unionTypesQueryString);
            return this;
        }

        /**
         * Adds the provided list of query strings to the {@link com.andrascsanyi.graphqlquerystringbuilder.example.graphql.FooType#something}.
         *
         * <p>
         * An item in the list should contain only query string for one union type.
         * </p>
         *
         * @param unionTypesQueryString {@link List} of query strings
         * @return {@link Builder}
         */
        public Builder somethingFieldUnionsQueryString(List<String> unionTypesQueryString) {
            this.somethingTypeQueriedFields = unionTypesQueryString;
            return this;
        }

        public String build() {

            StringBuilder builder = new StringBuilder();

            builder.append("{").append(" ");

            if (isIdFieldQueried) {
                builder.append(idFieldString).append(" ");
            }

            if (isNameFieldQueried) {
                builder.append(nameFieldString).append(" ");
            }

            if (isAddressFieldQueried) {
                builder.append(addressFieldString).append(" ");
            }

            if (!somethingTypeQueriedFields.isEmpty()) {
                builder.append(somethingFieldString)
                        .append(" ")
                        .append("{");

                for (String q : somethingTypeQueriedFields) {
                    builder.append(q);
                }

                builder.append(" ")
                        .append("}");
            }

            builder.append(" ")
                    .append("}");

            return builder.toString();
        }
    }
}
