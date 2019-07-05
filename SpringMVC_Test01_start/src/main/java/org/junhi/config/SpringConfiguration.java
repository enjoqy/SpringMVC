package org.junhi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 该类是一个配置类，他的作用和bean.xml是一样的
 * spring中的新注解
 * Configuration
 *      作用：指定当前类是一个配置类
 * ComponentScan
 *      作用：用于通过注解指定spring在创建容器时需要扫描的包
 *      属性：
 *          value：它和basePackages的作用是一样的，都是用于指定创建容器时需要扫描的包
 *                  我们使用注解，就等同于在xml中配置了：
 *                      <context:component-scan base-package="org.junhi"></context:component-scan>
 * Bean
 *      作用：用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性：
 *          name：用于指定bean的id。当不写时，默认是当前方法的名称
 * Import
 *      作用：用于导入其他配置类
 *      属性：
 *          value：用于指定其他配置类的字节码
 *                  当我们使用Import的注解之后，有Import注解的类就是父配置类，而导入的都是子配置类
 * PropertySource
 *      作用：指定peoperties文件所在的位置
 *          value:用于指定当前类的字节码
 *          classpath：关键字指定是类路径
 * bean对象的生命周期
 *      单例对象：
 *          出生：当容器创建时出生
 *          活着：只要容器还在，对象一直活着
 *          死亡：容器销毁，对象消亡
 *          总结：单例对象的生命周期和容器相同
*       多例对象：
 *          出生：当我们使用对象时，spring为我们创建
 *          活着：对象只要是在使用过程中，就一直活着
 *          死亡：当对象长时间不用，且没有别的引用对象时，由java的垃圾回收器回收
 *
 *
 * @author junhi
 * @date 2019/7/2 10:34
 */
@Configuration
@ComponentScan("org.junhi")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {


}
