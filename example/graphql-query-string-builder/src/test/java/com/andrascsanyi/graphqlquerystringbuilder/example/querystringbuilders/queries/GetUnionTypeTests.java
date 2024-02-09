package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.queries;

import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.FirstUnionType;
import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.FooType;
import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.SecondUnionType;
import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.ThirdUnionType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureHttpGraphQlTester
public class GetUnionTypeTests {

//    @Autowired
//    private HttpGraphQlTester httpGraphQlTester;

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(
                        "customQueryName",
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "query customQueryName { getAUnionType { id name address something { ... on FirstUnionType { id firstStringValue } ... on SecondUnionType { id secondStringValue } ... on ThirdUnionType { id thirdStringValue } } } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "query customQueryName { getAUnionType { name address something { ... on FirstUnionType { id firstStringValue } ... on SecondUnionType { id secondStringValue } ... on ThirdUnionType { id thirdStringValue } } } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        false,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "query customQueryName { getAUnionType { address something { ... on FirstUnionType { id firstStringValue } ... on SecondUnionType { id secondStringValue } ... on ThirdUnionType { id thirdStringValue } } } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        false,
                        false,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "query customQueryName { getAUnionType { something { ... on FirstUnionType { id firstStringValue } ... on SecondUnionType { id secondStringValue } ... on ThirdUnionType { id thirdStringValue } } } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        false,
                        false,
                        false,
                        true,
                        true,
                        true,
                        true,
                        true,
                        "query customQueryName { getAUnionType { something { ... on FirstUnionType { firstStringValue } ... on SecondUnionType { id secondStringValue } ... on ThirdUnionType { id thirdStringValue } } } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        false,
                        false,
                        true,
                        false,
                        true,
                        true,
                        true,
                        true,
                        "query customQueryName { getAUnionType { something { ... on FirstUnionType { id } ... on SecondUnionType { id secondStringValue } ... on ThirdUnionType { id thirdStringValue } } } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        false,
                        false,
                        true,
                        false,
                        false,
                        true,
                        true,
                        true,
                        "query customQueryName { getAUnionType { something { ... on FirstUnionType { id } ... on SecondUnionType { secondStringValue } ... on ThirdUnionType { id thirdStringValue } } } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        false,
                        false,
                        true,
                        false,
                        true,
                        false,
                        true,
                        true,
                        "query customQueryName { getAUnionType { something { ... on FirstUnionType { id } ... on SecondUnionType { id } ... on ThirdUnionType { id thirdStringValue } } } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        false,
                        false,
                        true,
                        false,
                        true,
                        false,
                        false,
                        true,
                        "query customQueryName { getAUnionType { something { ... on FirstUnionType { id } ... on SecondUnionType { id } ... on ThirdUnionType { thirdStringValue } } } }"
                ),
                Arguments.of(
                        "customQueryName",
                        false,
                        false,
                        false,
                        true,
                        false,
                        true,
                        false,
                        true,
                        false,
                        "query customQueryName { getAUnionType { something { ... on FirstUnionType { id } ... on SecondUnionType { id } ... on ThirdUnionType { id } } } }"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void test(
            String customQueryName,
            Boolean isFooTypeIdQueried,
            Boolean isFooTypeNameQueried,
            Boolean isFooTypeAddressQueried,
            Boolean isFirstUnionTypeIdFieldQueried,
            Boolean isFirstUnionTypeFirstStringValueQueried,
            Boolean isSecondUnionTypeIdFieldQueried,
            Boolean isSecondUnionTypeStringValueFieldQueried,
            Boolean isThirdUnionTypeIdFieldQueried,
            Boolean isThirdUnionTypeStringValueFieldQueried,
            String expected
    ) {

        // Given
        FirstUnionType.Builder firstUnionTypeBuilder = new FirstUnionType.Builder()
                .id(isFirstUnionTypeIdFieldQueried)
                .firstStringValue(isFirstUnionTypeFirstStringValueQueried);
        SecondUnionType.Builder secondUnionTypeBuilder = new SecondUnionType.Builder()
                .id(isSecondUnionTypeIdFieldQueried)
                .secondStringValue(isSecondUnionTypeStringValueFieldQueried);
        ThirdUnionType.Builder thirdUnionTypeBuilder = new ThirdUnionType.Builder()
                .id(isThirdUnionTypeIdFieldQueried)
                .thirdStringValue(isThirdUnionTypeStringValueFieldQueried);
        FooType.Builder fooTypeBuilder = new FooType.Builder()
                .id(isFooTypeIdQueried)
                .name(isFooTypeNameQueried)
                .address(isFooTypeAddressQueried)
                .somethingFieldFirstUnionTypeQueriedField(
                        firstUnionTypeBuilder.buildAsUnionType()
                )
                .somethingFieldSecondUnionTypeQueriedField(
                        secondUnionTypeBuilder.buildAsUnionType()
                )
                .somethingFieldThirdUnionTypeQueriedField(
                        thirdUnionTypeBuilder.buildAsUnionType()
                );
        GetAUnionTypeQuery.Builder builder = new GetAUnionTypeQuery.Builder()
                .customQueryName(customQueryName)
                .fooTypeQueriedFields(fooTypeBuilder.build());

        // When
        String result = builder.build();
//        com.andrascsanyi.graphqlquerystringbuilder.example.graphql.FooType fooTypeResult = httpGraphQlTester
//                .document(builder.build())
//                .execute()
//                .path(builder.queryName())
//                .entity(com.andrascsanyi.graphqlquerystringbuilder.example.graphql.FooType.class)
//                .get();

        // Then
        assertThat(result).isEqualTo(expected);
    }
}
