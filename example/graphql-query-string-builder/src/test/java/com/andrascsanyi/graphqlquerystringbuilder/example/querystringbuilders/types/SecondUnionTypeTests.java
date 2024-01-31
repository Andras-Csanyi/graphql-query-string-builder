package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SecondUnionTypeTests {

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(
                true,
                true,
                "{ id secondStringValue }"
            ),
            Arguments.of(
                false,
                true,
                "{ secondStringValue }"
            ),
            Arguments.of(
                true,
                false,
                "{ id }"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(
        Boolean isIdFieldQueried,
        Boolean isSecondStringValueFieldQueried,
        String expected
    ) {
        // Given
        SecondUnionType.Builder builder = new SecondUnionType.Builder()
            .id(isIdFieldQueried)
            .secondStringValue(isSecondStringValueFieldQueried);

        // When
        String result = builder.build();

        // Then
        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> dataForUnionType() {
        return Stream.of(
            Arguments.of(
                true,
                true,
                "... on SecondUnionType { id secondStringValue }"
            ),
            Arguments.of(
                false,
                true,
                "... on SecondUnionType { secondStringValue }"
            ),
            Arguments.of(
                true,
                false,
                "... on SecondUnionType { id }"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("dataForUnionType")
    public void testForUnionType(
        Boolean isIdFieldQueried,
        Boolean isSecondStringValueFieldQueried,
        String expected
    ) {
        // Given
        SecondUnionType.Builder builder = new SecondUnionType.Builder()
            .id(isIdFieldQueried)
            .secondStringValue(isSecondStringValueFieldQueried);

        // When
        String result = builder.buildAsUnionType();

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
