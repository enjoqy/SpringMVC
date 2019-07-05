package org.junhi.ui;

import org.junhi.dao.AccountDao;
import org.junhi.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author junhi
 * @date 2019/6/28 9:13
 */
public class Client {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContent.xml");
        String[] names = ac.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.saveAccount();
        System.out.println(accountService);

        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        System.out.println(accountDao);
    }
}
