package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

public class FirstUnionType {
    public static class Builder {

        private final static String idFieldString = "id";
        private Boolean isIdFieldQueried = false;

        public Builder id() {
            this.isIdFieldQueried = true;
            return this;
        }

        public Builder id(Boolean isIdFieldQueried) {
            this.isIdFieldQueried = isIdFieldQueried;
            return this;
        }

        private final static String firstStringValueString = "firstStringValue";
        private Boolean isFirstStringValueFieldQueried = false;

        public Builder firstStringValue() {
            this.isFirstStringValueFieldQueried = true;
            return this;
        }

        public Builder firstStringValue(Boolean isFirstStringValueFieldQueried) {
            this.isFirstStringValueFieldQueried = isFirstStringValueFieldQueried;
            return this;
        }

        private final static String typeName = "FirstUnionType";

        public String build() {

            StringBuilder builder = new StringBuilder();

            builder.append("{").append(" ");

            if (isIdFieldQueried) {
                builder.append(idFieldString).append(" ");
            }

            if (isFirstStringValueFieldQueried) {
                builder.append(firstStringValueString).append(" ");
            }

            builder.append("}");

            return builder.toString();
        }

        public String buildAsUnionType() {
            StringBuilder builder = new StringBuilder();

            builder.append(" ").append("...").append(" ");
            builder.append("on").append(" ");
            builder.append(typeName).append(" ");
            builder.append("{").append(" ");

            if (isIdFieldQueried) {
                builder.append(idFieldString).append(" ");
            }

            if (isFirstStringValueFieldQueried) {
                builder.append(firstStringValueString).append(" ");
            }

            builder.append("}");

            return builder.toString();

        }
    }
}
