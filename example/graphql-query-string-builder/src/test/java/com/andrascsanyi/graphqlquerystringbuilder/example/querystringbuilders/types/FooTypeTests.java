package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FooTypeTests {

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(
                true,
                true,
                true,
                "{ id name address }"
            ),
            Arguments.of(
                false,
                true,
                true,
                "{ name address }"
            ),
            Arguments.of(
                true,
                false,
                true,
                "{ id address }"
            ),
            Arguments.of(
                false,
                false,
                true,
                "{ address }"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(
        Boolean isIdFieldQueried,
        Boolean isNameFieldQueried,
        Boolean isAddressFieldQueried,
        String expected
    ) {
        // Given
        FooType.Builder builder = new FooType.Builder()
            .id(isIdFieldQueried)
            .name(isNameFieldQueried)
            .address(isAddressFieldQueried);

        // When
        String result = builder.build();

        // Then
        assertThat(result).isEqualTo(expected);
    }

}
