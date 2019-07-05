package org.junhi.service.impl;

import org.junhi.dao.AccountDao;
import org.junhi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现
 * xml配置
 * <bean id="accountService" class="org.AccountServiceImpl" scope=""
 * init-method="" destory-method="">
 *      <property name="" value="" | ref=""></property>
 * </bean>
 *  用于创建对象的，bean
 *      @Component
 *          作用：用于把当前类对象存入spring容器
 *          属性：
 *              value:用于指定bean的id，当我们不写时，默认当前类型，且首字母小写
 *      @Controller，和Component效果一样，建议建议用在表现层
 *      @service，建议用在业务层
 *      @Repository，建议用在持久层
 *      三层对象更加清晰
 *  用于注入数据的，property
 *      @Autowired:
 *          作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和注入的变量类型匹配，就可以注入成功
 *          出现位置：可以是变量或方法
 *      @Qualifier:
 *          需要autowried配合使用，
 *          作用：在按照类中注入的基础上在按照名称注入
 *          属性：value：用于指定bean的id
 *      @Resource
 *          作用是直接按照bean的id注入，可以独立使用
 *          属性：name用于指定bean的id
 *      以上三个注解都只能注入其他bean类型的数据，基本类型和string类型无法使用上述注解实现
 *      另外集合的注入只能通过xml文件实现
 *
 *      @Value:
 *          作用：用于注入基本类型和String类型的数据
 *          属性：value用于指定数据的值，可以使用spring的SpEl（spring的el表达式）
 *              SpEl的写法：${表达式}
 *
 *  用于改变左右范围的，scope
 *      @Scope
 *          作用：用于指定bean的作用范围
 *          属性：value：指定取值的范围
 *  和生命周期相关的，init-method,destroy-method，常用取值：singleton，prototype
 *      @PreDestroy:
 *          作用：指定销毁方法
 *      @PostConstruct
 *          作用：用于指定初始化方法
 *
 *
 * @author junhi
 * @date 2019/6/28 9:10
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveAccount(){
        accountDao.saveAccount();
    }
}
