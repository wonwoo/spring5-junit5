package me.wonwoo.spring;

import java.lang.annotation.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import me.wonwoo.mockito.TimingExtension;

@ExtendWith({SpringExtension.class, TimingExtension.class})
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SpringTimingExtension {
}
