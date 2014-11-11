package net.linzhihui.bestPractice.itxdlInAction.JavaSE03.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented	//javadoc执行时一并生成注释
@Retention(RetentionPolicy.RUNTIME) //定义使用范围（在运行时，或源码，或class文件）
@Target(ElementType.TYPE)//定义注解用于什么范围,type-类，method方法，field属性等
@Inherited //表示注解可以被子类继承
public @interface AnnotationDef2 {
	public String name();
	public String id() default "10001";
	public AnnotationEnum2 e() default AnnotationEnum2.GG;
}
