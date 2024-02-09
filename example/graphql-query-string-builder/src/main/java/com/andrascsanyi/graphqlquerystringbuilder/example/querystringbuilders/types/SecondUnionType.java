package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

public class SecondUnionType {
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

        private final static String secondtStringValueString = "secondStringValue";
        private Boolean isSecondStringValueFieldQueried = false;

        public Builder secondStringValue() {
            this.isSecondStringValueFieldQueried = true;
            return this;
        }

        public Builder secondStringValue(Boolean isFirstStringValueFieldQueried) {
            this.isSecondStringValueFieldQueried = isFirstStringValueFieldQueried;
            return this;
        }

        private final static String typeName = "SecondUnionType";

        public String build() {

            StringBuilder builder = new StringBuilder();

            builder.append("{").append(" ");

            if (isIdFieldQueried) {
                builder.append(idFieldString).append(" ");
            }

            if (isSecondStringValueFieldQueried) {
                builder.append(secondtStringValueString).append(" ");
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

            if (isSecondStringValueFieldQueried) {
                builder.append(secondtStringValueString).append(" ");
            }

            builder.append("}");

            return builder.toString();

        }
    }
}
