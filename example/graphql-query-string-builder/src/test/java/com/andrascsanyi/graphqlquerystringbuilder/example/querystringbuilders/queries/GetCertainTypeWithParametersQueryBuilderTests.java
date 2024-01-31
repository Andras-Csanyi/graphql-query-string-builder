package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.queries;

import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.AnotherType;
import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.CertainType;
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

    public static Stream<Arguments> testDataForWithFieldsTest() {
        return Stream.of(
            Arguments.of(
                "customQueryName",
                true,
                true,
                true,
                true,
                "query customQueryName($foo: CertainTypeInput!) { getCertainTypeWithParameters(foo: $foo) { id name anotherType { id furtherString } } }"
            ),
            Arguments.of(
                null,
                true,
                true,
                true,
                true,
                "query ($foo: CertainTypeInput!) { getCertainTypeWithParameters(foo: $foo) { id name anotherType { id furtherString } } }"
            ),
            Arguments.of(
                "customQueryName",
                false,
                true,
                true,
                true,
                "query customQueryName($foo: CertainTypeInput!) { getCertainTypeWithParameters(foo: $foo) { name anotherType { id furtherString } } }"
            ),
            Arguments.of(
                "customQueryName",
                false,
                false,
                true,
                true,
                "query customQueryName($foo: CertainTypeInput!) { getCertainTypeWithParameters(foo: $foo) { anotherType { id furtherString } } }"
            ),
            Arguments.of(
                "customQueryName",
                false,
                false,
                false,
                true,
                "query customQueryName($foo: CertainTypeInput!) { getCertainTypeWithParameters(foo: $foo) { anotherType { furtherString } } }"
            ),
            Arguments.of(
                "customQueryName",
                false,
                false,
                false,
                false,
                "query customQueryName($foo: CertainTypeInput!) { getCertainTypeWithParameters(foo: $foo) { anotherType { } } }"
            ),
            Arguments.of(
                "customQueryName",
                true,
                false,
                false,
                true,
                "query customQueryName($foo: CertainTypeInput!) { getCertainTypeWithParameters(foo: $foo) { id anotherType { furtherString } } }"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("testDataForWithFieldsTest")
    public void testDataForWithFields(
        String customQueryName,
        Boolean isCertainTypeIdFieldQueried,
        Boolean isCertainTypeNameFieldQueried,
        Boolean isAnotherTypeIdFieldQueried,
        Boolean isAnotherTypeFurtherStringFieldQueried,
        String expected
    ) {

        // Given
        GetCertainTypeWithParametersQueryBuilder.Builder builder =
            new GetCertainTypeWithParametersQueryBuilder.Builder();
        builder.customQueryName(customQueryName);

        CertainType.Builder certainTypeBuilder = new CertainType.Builder()
            .id(isCertainTypeIdFieldQueried)
            .name(isCertainTypeNameFieldQueried)
            .queriedAnotherTypeFields(
                new AnotherType.Builder()
                    .id(isAnotherTypeIdFieldQueried)
                    .furtherString(isAnotherTypeFurtherStringFieldQueried)
                    .build());

        builder.queriedCertainTypeFields(certainTypeBuilder.build());

        // When
        String result = builder.build();

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
