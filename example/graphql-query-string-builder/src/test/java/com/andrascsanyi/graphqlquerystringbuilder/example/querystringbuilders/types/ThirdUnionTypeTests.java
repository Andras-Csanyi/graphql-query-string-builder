package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ThirdUnionTypeTests {

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(
                true,
                true,
                "{ id thirdStringValue }"
            ),
            Arguments.of(
                false,
                true,
                "{ thirdStringValue }"
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
        Boolean isThirdStringValueFieldQueried,
        String expected
    ) {
        // Given
        ThirdUnionType.Builder builder = new ThirdUnionType.Builder()
            .id(isIdFieldQueried)
            .thirdStringValue(isThirdStringValueFieldQueried);

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
                "... on ThirdUnionType { id thirdStringValue }"
            ),
            Arguments.of(
                false,
                true,
                "... on ThirdUnionType { thirdStringValue }"
            ),
            Arguments.of(
                true,
                false,
                "... on ThirdUnionType { id }"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("dataForUnionType")
    public void testForUnionType(
        Boolean isIdFieldQueried,
        Boolean isThirdStringValueFieldQueried,
        String expected
    ) {
        // Given
        ThirdUnionType.Builder builder = new ThirdUnionType.Builder()
            .id(isIdFieldQueried)
            .thirdStringValue(isThirdStringValueFieldQueried);

        // When
        String result = builder.buildAsUnionType();

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
