package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types;

import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.CertainType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CertainTypeBuilderTests {
    
    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(
                        true,
                        true,
                        "{ id name }"
                ),
                Arguments.of(
                        false,
                        true,
                        "{ name }"
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
            Boolean isNameFieldQueried,
            String expected
    ) {
        // Given
        CertainType.Builder builder = new CertainType.Builder()
                .id(isIdFieldQueried)
                .name(isNameFieldQueried);
        
        // When
        String result = builder.build();
        
        // Then
        assertThat(result).isEqualTo(expected);
    }
}
