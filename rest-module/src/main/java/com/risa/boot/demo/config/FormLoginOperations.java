package com.risa.boot.demo.config;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiListingBuilder;
import springfox.documentation.builders.OperationBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.ApiListing;
import springfox.documentation.service.Operation;
import springfox.documentation.spring.web.plugins.DocumentationPluginsManager;
import springfox.documentation.spring.web.readers.operation.CachingOperationNameGenerator;
import springfox.documentation.spring.web.scanners.ApiDescriptionReader;
import springfox.documentation.spring.web.scanners.ApiListingScanner;
import springfox.documentation.spring.web.scanners.ApiListingScanningContext;
import springfox.documentation.spring.web.scanners.ApiModelReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class FormLoginOperations extends ApiListingScanner {
    @Autowired
    private TypeResolver typeResolver;

    @Autowired
    public FormLoginOperations(ApiDescriptionReader apiDescriptionReader, ApiModelReader apiModelReader, DocumentationPluginsManager pluginsManager) {
        super(apiDescriptionReader, apiModelReader, pluginsManager);
    }

    @Override
    public Multimap<String, ApiListing> scan(ApiListingScanningContext context) {
        final Multimap<String, ApiListing> def = super.scan(context);

        final List<ApiDescription> apis = new LinkedList<>();

        final List<Operation> operations = new ArrayList<>();
        operations.add(new OperationBuilder(new CachingOperationNameGenerator())
                .method(HttpMethod.POST)
                .uniqueId("login")
                .parameters(Arrays.asList(
                        new ParameterBuilder()
                                .name("username")
                                .description("Имя пользователя")
                                .parameterType("query")
                                .type(typeResolver.resolve(String.class))
                                .modelRef(new ModelRef("string"))
                                .order(0)
                                .build(),

                        new ParameterBuilder()
                                .name("password")
                                .description("Пароль")
                                .parameterType("query")
                                .type(typeResolver.resolve(String.class))
                                .modelRef(new ModelRef("string"))
                                .order(100)
                                .build()))
                .summary("Log in") //
                .notes("Тут вы можете войти в сервис")
                .build());
        apis.add(new ApiDescription("/login", "Authentication documentation", operations, false));

        def.put("authentication", new ApiListingBuilder(context.getDocumentationContext().getApiDescriptionOrdering())
                .apis(apis)
                .description("Custom authentication")
                .build());

        return def;
    }
}