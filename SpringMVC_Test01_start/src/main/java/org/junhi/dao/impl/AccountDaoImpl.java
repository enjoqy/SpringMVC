package org.junhi.dao.impl;

import org.junhi.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author junhi
 * @date 2019/6/28 9:12
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    public void saveAccount() {
        System.out.println("---------------");
    }
}
