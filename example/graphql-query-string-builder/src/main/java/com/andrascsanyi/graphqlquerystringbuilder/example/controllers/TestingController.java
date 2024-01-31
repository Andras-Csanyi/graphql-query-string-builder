package com.andrascsanyi.graphqlquerystringbuilder.example.controllers;

import com.andrascsanyi.graphqlquerystringbuilder.example.graphql.AnotherType;
import com.andrascsanyi.graphqlquerystringbuilder.example.graphql.CertainType;
import com.andrascsanyi.graphqlquerystringbuilder.example.graphql.CertainTypeInput;
import com.andrascsanyi.graphqlquerystringbuilder.example.graphql.ScalarType;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;


@Controller
public class TestingController {

    @QueryMapping(name = "getScalarType")
    public ScalarType getScalarType(DataFetchingEnvironment env) {
        
        return ScalarType.builder().build();
    }

    @QueryMapping(name = "getCertainTypeWhereFieldIsAnotherType")
    public CertainType getScalarTypes(DataFetchingEnvironment env) {
        return CertainType.builder()
                .setId("100")
                .setName("name")
                .setAnotherType(AnotherType.builder()
                        .setId("101")
                        .setFurtherString("futherrrr")
                        .build())
                .build();
    }
    
    @QueryMapping(name = "getCertainTypeWithParameters")
    public CertainType getCertainTypeWithParameters(
            @Argument("foo") CertainTypeInput input,
            DataFetchingEnvironment env) {
        return CertainType.builder()
                .setId("100")
                .setName("name")
                .setAnotherType(AnotherType.builder()
                        .setId("101")
                        .setFurtherString("futherrrr")
                        .build())
                .build();
    }

}
