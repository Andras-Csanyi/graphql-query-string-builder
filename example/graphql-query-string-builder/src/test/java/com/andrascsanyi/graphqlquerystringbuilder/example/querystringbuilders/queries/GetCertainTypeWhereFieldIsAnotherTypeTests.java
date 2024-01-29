package com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.queries;

import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.AnotherTypeBuilder;
import com.andrascsanyi.graphqlquerystringbuilder.example.querystringbuilders.types.CertainType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.HttpGraphQlTester;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureHttpGraphQlTester
public class GetCertainTypeWhereFieldIsAnotherTypeTests {

    @Autowired
    private HttpGraphQlTester httpGraphQlTester;

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(
                        true,
                        true,
                        true,
                        true,
                        true,
                        "customName",
                        "query customName { getCertainTypeWhereFieldIsAnotherType { id name anotherType { id furtherString }} }"
                ),
                Arguments.of(
                        false,
                        true,
                        true,
                        true,
                        true,
                        "customName",
                        "query customName { getCertainTypeWhereFieldIsAnotherType { id name anotherType { furtherString }} }"
                ),
                Arguments.of(
                        true,
                        false,
                        true,
                        true,
                        true,
                        "customName",
                        "query customName { getCertainTypeWhereFieldIsAnotherType { id name anotherType { id }} }"
                ),
                Arguments.of(
                        true,
                        true,
                        true,
                        true,
                        false,
                        "customName",
                        "query customName { getCertainTypeWhereFieldIsAnotherType { id name } }"
                ),
                Arguments.of(
                        true,
                        true,
                        false,
                        true,
                        true,
                        "customName",
                        "query customName { getCertainTypeWhereFieldIsAnotherType { name anotherType { id furtherString }} }"
                ),
                Arguments.of(
                        true,
                        true,
                        true,
                        false,
                        true,
                        "customName",
                        "query customName { getCertainTypeWhereFieldIsAnotherType { id anotherType { id furtherString }} }"
                ),
                Arguments.of(
                        false,
                        true,
                        true,
                        false,
                        true,
                        "customName",
                        "query customName { getCertainTypeWhereFieldIsAnotherType { id anotherType { furtherString }} }"
                ),
                Arguments.of(
                        true,
                        false,
                        true,
                        false,
                        true,
                        "customName",
                        "query customName { getCertainTypeWhereFieldIsAnotherType { id anotherType { id }} }"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    public void tests(
            Boolean isAnotherTypeIdFieldQueried,
            Boolean isAnotherTypeFurtherStringFieldQueried,
            Boolean isCertainTypeIdFieldQueried,
            Boolean isCertainTypeNameFieldQueried,
            Boolean isCertainTypeAnotherTypeFieldQueried,
            String customQueryName,
            String expected
    ) {
        // Given
        GetCertainTypeWhereFieldIsAnotherTypeQueryBuilder.Builder queryBuilder =
                new GetCertainTypeWhereFieldIsAnotherTypeQueryBuilder.Builder();
        CertainType.Builder certainTypeBuilder = new CertainType.Builder();
        AnotherTypeBuilder.Builder anotherTypeBuilder = new AnotherTypeBuilder.Builder();

        anotherTypeBuilder
                .id(isAnotherTypeIdFieldQueried)
                .furtherString(isAnotherTypeFurtherStringFieldQueried);

        certainTypeBuilder
                .id(isCertainTypeIdFieldQueried)
                .name(isCertainTypeNameFieldQueried)
                .anotherType(isCertainTypeAnotherTypeFieldQueried)
                .anotherTypeFields(anotherTypeBuilder.build());

        queryBuilder
                .customQueryName(customQueryName)
                .fields(certainTypeBuilder.build());
        
        // When
        com.andrascsanyi.graphql_query_string_builder_example.CertainType result = httpGraphQlTester
                .document(queryBuilder.build())
                .execute()
                .path(queryBuilder.queryName())
                .entity(com.andrascsanyi.graphql_query_string_builder_example.CertainType.class)
                .get();
        
        // Then
        assertThat(queryBuilder.build()).isEqualTo(expected);
        
    }
}
