package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.queries;

import java.util.Map;

public class GetCertainTypeWithParametersQueryBuilder {

    public static class Builder {
        private final String queryName = "getCertainTypeWithParameters";

        public String queryName() {
            return queryName;
        }

        private String fields;

        public Builder queriedCertainTypeFields(String fields) {
            this.fields = fields;
            return this;
        }

        private String customQueryName;

        public Builder customQueryName(String customQueryName) {
            this.customQueryName = customQueryName;
            return this;
        }

        private Map<String, Map<String, Boolean>> inputParameters = Map.of(
                "foo", Map.of("CertainTypeInput", true)
        );

        public String build() {

            String s = """
                    query customName($foo: CertainTypeInput!) {
                        getCertainTypeWithParameters(foo : $foo) {
                            id
                            name
                            anotherType {
                                id
                                furtherString
                            }
                        }
                    }
                    """;

            StringBuilder query = new StringBuilder("query ");

            if (customQueryName != null) {
                query.append(customQueryName);
            }

            if (!inputParameters.isEmpty()) {
                query.append(buildQueryParameterList(inputParameters))
                        .append(" ");
            }

            query.append("{").append(" ");
            query.append(queryName);

            if (!inputParameters.isEmpty()) {
                query.append(buildMethodParameterList(inputParameters));
                query.append(" ");
            } else {
                query.append(" ");
            }

            query.append(fields).append(" ");
            query.append("}");

            return query.toString();
        }

        private String buildMethodParameterList(Map<String, Map<String, Boolean>> inputParameters) {

            // we build this here: (foo : $foo)

            StringBuilder builder = new StringBuilder();
            builder.append("(");

            for (Map.Entry<String, Map<String, Boolean>> aParameter : inputParameters.entrySet()) {
                // parameter name
                builder.append(aParameter.getKey());

                builder.append(":");
                builder.append(" ");

                builder.append("$");
                builder.append(aParameter.getKey());

                if (inputParameters.size() > 1) {
                    builder.append(",");
                    builder.append(" ");
                }
            }
            
            builder.append(")");
            return builder.toString();
        }

        private String buildQueryParameterList(Map<String, Map<String, Boolean>> inputParameters) {

            // Building this here: ($input: CertainTypeInput!)

            StringBuilder parameters = new StringBuilder();
            parameters.append("(");

            for (Map.Entry<String, Map<String, Boolean>> aParameter : inputParameters.entrySet()) {
                // parameter name
                parameters.append("$");
                parameters.append(aParameter.getKey());
                parameters.append(":");
                parameters.append(" ");

                // parameter type
                String parameterTypeName = aParameter.getValue().keySet().stream().toList().get(0);
                Boolean isMandatory = aParameter.getValue().values().stream().toList().get(0);
                parameters.append(parameterTypeName);
                if (isMandatory) {
                    parameters.append("!");
                }

                // adding comma if there are more parameters
                if (inputParameters.size() > 1) {
                    parameters.append(", ");
                }
            }

            parameters.append(")");
            return parameters.toString();
        }

    }
}
