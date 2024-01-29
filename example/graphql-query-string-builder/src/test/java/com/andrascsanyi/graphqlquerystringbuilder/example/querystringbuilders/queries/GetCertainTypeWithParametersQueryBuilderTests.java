package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.queries;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GetCertainTypeWithParametersQueryBuilderTests {

    public static Stream<Arguments> testDataForWithoutFieldsTest() {
        return Stream.of(
                Arguments.of(
                        "customName",
                        "query customName($foo: CertainTypeInput!) { getCertainTypeWithParameters(foo: $foo) null }"
                ),
                Arguments.of(
                        null,
                        "query ($foo: CertainTypeInput!) { getCertainTypeWithParameters(foo: $foo) null }"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testDataForWithoutFieldsTest")
    public void testsWithoutFields(
            String customQueryName,
            String expected
    ) {

        // Given
        GetCertainTypeWithParametersQueryBuilder.Builder builder =
                new GetCertainTypeWithParametersQueryBuilder.Builder();
        builder.customQueryName(customQueryName);

        // When
        String result = builder.build();

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
