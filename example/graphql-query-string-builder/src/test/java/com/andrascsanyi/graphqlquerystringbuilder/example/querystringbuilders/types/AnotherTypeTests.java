package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class AnotherTypeTests {

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(
                        true,
                        true,
                        "{ id furtherString } "
                ),
                Arguments.of(
                        false,
                        true,
                        "{ furtherString } "
                ),
                Arguments.of(
                        true,
                        false,
                        "{ id } "
                )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(
            Boolean isIdQueried,
            Boolean isFurtherStringQueried,
            String expected
    ) {

        // Given
        AnotherType.Builder builder = new AnotherType.Builder()
                .id(isIdQueried)
                .furtherString(isFurtherStringQueried);

        // When
        String queryString = builder.build();

        // Then
        assertThat(queryString).isEqualTo(expected);
    }
}
