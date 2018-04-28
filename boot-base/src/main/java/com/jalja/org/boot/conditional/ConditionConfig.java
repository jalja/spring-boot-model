package com.jalja.org.boot.conditional;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;


/**
 * @Conditional 一般配合Condition使用，只有接口实现类返回true 时才会被装配 否则不装配
 * @Conditional 作用域：
 * 方法上：只对该方法起作用
 * 类上：该类下面的所有方法都将受影响
 * 因而在我们做Condition 限制Bean 装配时可以结合 @Conditional 修饰类和 @Conditional 修饰方法两种灵活作用。
 * spring boot 也给 我们提供了大量的 Condition 供我们使用 org.springframework.boot.autoconfigure.condition
 */

@SpringBootConfiguration
public class ConditionConfig {
	
	@Bean
	@Conditional(MyConditional.class)
	public Runnable getRunnable() {
		return ()->{
			
		};
	}
}
