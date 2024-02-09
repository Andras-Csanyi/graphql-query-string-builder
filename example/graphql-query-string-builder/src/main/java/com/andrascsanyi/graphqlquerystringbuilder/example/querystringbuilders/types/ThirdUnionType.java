package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

public class ThirdUnionType {
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

        private final static String thirdStringValueString = "thirdStringValue";
        private Boolean isThirdStringValueFieldQueried = false;

        public Builder thirdStringValue() {
            this.isThirdStringValueFieldQueried = true;
            return this;
        }

        public Builder thirdStringValue(Boolean isFirstStringValueFieldQueried) {
            this.isThirdStringValueFieldQueried = isFirstStringValueFieldQueried;
            return this;
        }

        private final static String typeName = "ThirdUnionType";

        public String build() {

            StringBuilder builder = new StringBuilder();

            builder.append("{").append(" ");

            if (isIdFieldQueried) {
                builder.append(idFieldString).append(" ");
            }

            if (isThirdStringValueFieldQueried) {
                builder.append(thirdStringValueString).append(" ");
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

            if (isThirdStringValueFieldQueried) {
                builder.append(thirdStringValueString).append(" ");
            }

            builder.append("}");

            return builder.toString();

        }
    }
}
