package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.queries;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GetUnionTypeTests {

    public static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of(

            ));
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(
        Boolean isFooTypeIdQueried,
        Boolean isFooTypeNameQueried,
        Boolean isFooTypeAddressQueried,
    ) {

        // Given
        GetAUnionTypeQuery.Builder builder = new GetAUnionTypeQuery.Builder();



        // When
        String result = builder.build();

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
