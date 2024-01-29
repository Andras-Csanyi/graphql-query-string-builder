package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

public class ScalarType {

    public static class Builder {

        /**
         * Defines if the {@link com.andrascsanyi.graphql_query_string_builder_example.ScalarType#intType}
         * is queried or not.
         */
        private Boolean isIntTypeFieldQueried;
        private final static String intTypeString = "intType";

        private Boolean isFloatTypeFieldQueried;
        private final static String floatTypeString = "floatType";
        private Boolean isStringTypeFieldQueried;
        private final static String stringTypeString = "stringType";

        /**
         * Adds <b>stringType</b> field to the list of fields will be used in the query.
         * 
         * @return {@link Builder}
         */
        public Builder stringType() {
            this.isStringTypeFieldQueried = true;
            return this;
        }
        
        public Builder stringType(Boolean isStringTypeQueried) {
            this.isStringTypeFieldQueried = isStringTypeQueried;
            return this;
        }

        /**
         * Adds <b>floatType</b> field to the list of fields will be used in the query.
         * 
         * @return {@link Builder}
         */
        public Builder floatType() {
            this.isFloatTypeFieldQueried = true;
            return this;
        }
        
        public Builder floatType(Boolean isFloatTypeFieldQueried) {
            this.isFloatTypeFieldQueried = isFloatTypeFieldQueried;
            return this;
        }

        /**
         * Adds <b>intType</b> field to the list of fields will be used in the query.
         * 
         * @return {@link Builder}
         */
        public Builder intType() {
            this.isIntTypeFieldQueried = true;
            return this;
        }
        
        public Builder intType(Boolean isIntTypeFieldQueried) {
            this.isIntTypeFieldQueried = isIntTypeFieldQueried;
            return this;
        }

        public String build() {
            StringBuilder builder = new StringBuilder("{").append(" ");
            
            if(isFloatTypeFieldQueried) {
                builder.append(floatTypeString).append(" ");
            }

            if(isIntTypeFieldQueried) {
                builder.append(intTypeString).append(" ");
            }
            
            if(isStringTypeFieldQueried) {
                builder.append(stringTypeString).append(" ");
            }

            builder.append("}");
            return builder.toString();
        }
    }
}
