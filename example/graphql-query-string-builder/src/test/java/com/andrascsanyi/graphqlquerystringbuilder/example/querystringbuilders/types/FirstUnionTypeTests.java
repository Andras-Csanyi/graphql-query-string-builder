package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstUnionTypeTests {

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(
                true,
                true,
                "{ id firstStringValue }"
            ),
            Arguments.of(
                false,
                true,
                "{ firstStringValue }"
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
        Boolean isFirstStringValueFieldQueried,
        String expected
    ) {
        // Given
        FirstUnionType.Builder builder = new FirstUnionType.Builder()
            .id(isIdFieldQueried)
            .firstStringValue(isFirstStringValueFieldQueried);

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
                "... on FirstUnionType { id firstStringValue }"
            ),
            Arguments.of(
                false,
                true,
                "... on FirstUnionType { firstStringValue }"
            ),
            Arguments.of(
                true,
                false,
                "... on FirstUnionType { id }"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("dataForUnionType")
    public void testUnionType(
        Boolean isIdFieldQueried,
        Boolean isFirstStringValueFieldQueried,
        String expected
    ) {
        // Given
        FirstUnionType.Builder builder = new FirstUnionType.Builder()
            .id(isIdFieldQueried)
            .firstStringValue(isFirstStringValueFieldQueried);

        // When
        String result = builder.buildAsUnionType();

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
