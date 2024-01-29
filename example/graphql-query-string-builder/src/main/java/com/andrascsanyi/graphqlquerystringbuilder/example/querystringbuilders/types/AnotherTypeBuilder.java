package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import com.andrascsanyi.graphql_query_string_builder_example.AnotherType;

public class AnotherTypeBuilder {
    
    public static class Builder {
        
        private Integer id;
        private final static String idQueryString = "id";
        private Boolean isIdQueried;

        /**
         * Adds <b>id</b> field to the list of queried fields of {@link AnotherType}.
         * 
         * @return {@link Builder}
         */
        public Builder id() {
            this.isIdQueried = true;
            return this;
        }

        /**
         * Adds <b>id</b> field to the list of queried fields of {@link AnotherType}.
         * 
         * @param isIdQueried Switch
         * @return {@link Builder}
         */
        public Builder id(Boolean isIdQueried) {
            this.isIdQueried = isIdQueried;
            return this;
        }
        
        private String furtherString;
        private Boolean isFurtherStringQueried;

        /**
         * Adds <b>furtherString</b> field to the list of queried fields of {@link AnotherType}.
         * 
         * @return {@link Builder}
         */
        public Builder furtherString() {
            this.isFurtherStringQueried = true;
            return this;
        }

        /**
         * Adds <b>furtherString</b> field to the list of queried fields of {@link AnotherType}.
         * 
         * @param isFurtherStringQueried Switch
         * @return {@link Builder}
         */
        public Builder furtherString(Boolean isFurtherStringQueried) {
            this.isFurtherStringQueried = isFurtherStringQueried;
            return this;
        }
        private final static String furtherStringQueryString = "furtherString";

        /**
         * Builds the GraphQL query string for {@link AnotherType}.
         * 
         * @return the GraphQL query string
         */
        public String build() {
            StringBuilder builder = new StringBuilder();
            
            // warning if every field is disabled?
            
            builder.append("{").append(" ");
            
            if(isIdQueried) {
                builder.append(idQueryString).append(" ");
            }
            
            if(isFurtherStringQueried){
                builder.append(furtherStringQueryString).append(" ");
            }
            
            builder.append("}");
            
            return builder.toString();
        }
    }
}
