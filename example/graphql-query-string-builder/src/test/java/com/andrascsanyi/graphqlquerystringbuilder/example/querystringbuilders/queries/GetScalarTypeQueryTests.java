package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.queries;

import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.ScalarType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.HttpGraphQlTester;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureHttpGraphQlTester
public class GetScalarTypeQueryTests {

    @Autowired
    private HttpGraphQlTester httpGraphQlTester;

    @Test
    public void test() {

        // Given
        ScalarType.Builder scalarTypeFields = new ScalarType.Builder()
                .floatType()
                .intType()
                .stringType();
        GetScalarTypeQuery.Builder getScalarTypeQuery = new GetScalarTypeQuery.Builder()
                .customQueryName("customQueryName")
                .fields(scalarTypeFields.build());

        // Act
        com.andrascsanyi.graphqlquerystringbuilder.example.graphql.ScalarType result = httpGraphQlTester
                .document(getScalarTypeQuery.build())
                .execute()
                .path(getScalarTypeQuery.queryName())
                .entity(com.andrascsanyi.graphqlquerystringbuilder.example.graphql.ScalarType.class)
                .get();
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(
                        "customQueryName",
                        true,
                        true,
                        true,
                        "query customQueryName { getScalarType { floatType intType stringType } }"
                ),
                Arguments.of(
                        null,
                        true,
                        true,
                        true,
                        "query { getScalarType { floatType intType stringType } }"
                ),                
                Arguments.of(
                        null,
                        false,
                        true,
                        true,
                        "query { getScalarType { intType stringType } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        true,
                        true,
                        "query customQueryName { getScalarType { intType stringType } }"
                ),
                Arguments.of(
                        "customQueryName",
                        true,
                        false,
                        true,
                        "query customQueryName { getScalarType { floatType stringType } }"
                ),
                Arguments.of(
                        "customQueryName",
                        true,
                        false,
                        false,
                        "query customQueryName { getScalarType { floatType } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        false,
                        true,
                        "query customQueryName { getScalarType { stringType } }"
                )
                );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void permutation(
            String customQueryName,
            Boolean isFloatRequired,
            Boolean isIntRequired,
            Boolean isStringRequired,
            String expectedResult
    ) {
        // When
        ScalarType.Builder scalarType = new ScalarType.Builder()
                .floatType(isFloatRequired)
                .stringType(isStringRequired)
                .intType(isIntRequired);
        GetScalarTypeQuery.Builder getScalarTypeQuery = new GetScalarTypeQuery.Builder()
                .fields(scalarType.build());

        if (customQueryName != null) {
            getScalarTypeQuery.customQueryName(customQueryName);
        }

        // Then
        assertThat(getScalarTypeQuery.build()).isEqualTo(expectedResult);

    }
}
