package me.wonwoo.mockito;

import java.lang.reflect.Parameter;
import org.junit.jupiter.api.extension.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.extension.ExtensionContext.*;
import static org.mockito.Mockito.mock;

public class MockitoExtension implements TestInstancePostProcessor, ParameterResolver {

    @Override
    public void postProcessTestInstance(Object o, ExtensionContext extensionContext) throws Exception {
        MockitoAnnotations.initMocks(o);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().isAnnotationPresent(Mock.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return getMock(parameterContext.getParameter(), extensionContext);
    }

    private Object getMock(Parameter parameter, ExtensionContext extensionContext) {
        Class<?> type = parameter.getType();
        Store store = extensionContext.getStore(Namespace.create(MockitoExtension.class, type));
        String mockName = getMockName(parameter);
        if (mockName != null) {
            return store.getOrComputeIfAbsent(mockName, key -> mock(type, mockName));
        } else {
            return store.getOrComputeIfAbsent(type.getCanonicalName(), key -> mock(type));
        }
    }

    private String getMockName(Parameter parameter) {
        String explicitMockName = parameter.getAnnotation(Mock.class).name().trim();
        if (!explicitMockName.isEmpty()) {
            return explicitMockName;
        } else if (parameter.isNamePresent()) {
            return parameter.getName();
        }
        return null;
    }
}
