package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankingTest {
    private static final String DEST_FIRM_NAME = "Roga & Copiyta gmbh";
    private static final String DEST_PASSPORT = "roga-i-copiyta passport";
    private static final String DEST_ACCOUNT_NO = "12221";
    private static final String SRC_FIRM_NAME = "NUTS BROTHERS INC";
    private static final String SRC_PASSPORT = "insane-nuts passport";
    private static final String SRC_ACCOUNT_NO = "4412";
    Banking sberbank = new Banking();

    @Before
    public void initializeData() {
        sberbank.addUser(new User(DEST_FIRM_NAME, DEST_PASSPORT));
        sberbank.addAccountToUser(DEST_PASSPORT, new Account(1000, DEST_ACCOUNT_NO));
        sberbank.addUser(new User(SRC_FIRM_NAME, SRC_PASSPORT));
        sberbank.addAccountToUser(SRC_PASSPORT, new Account(1000, SRC_ACCOUNT_NO));
    }

    @Test
    public void whenSend10ThenResieve10() {
        sberbank.transferMoney(SRC_PASSPORT, SRC_ACCOUNT_NO, DEST_PASSPORT, DEST_ACCOUNT_NO, 10);
        double[] result = {
                sberbank.getUserAccounts(DEST_PASSPORT).get(0).getValue(),
                sberbank.getUserAccounts(SRC_PASSPORT).get(0).getValue()
        };
        assertThat(result, is(new double[] {1010.0, 990.0}));
    }

    @Test
    public void whenSendInsufficientThenResieveNothing() {
        sberbank.transferMoney(SRC_PASSPORT, SRC_ACCOUNT_NO, DEST_PASSPORT, DEST_ACCOUNT_NO, 2000);
        double[] result = {
                sberbank.getUserAccounts(DEST_PASSPORT).get(0).getValue(),
                sberbank.getUserAccounts(SRC_PASSPORT).get(0).getValue()
        };
        assertThat(result, is(new double[] {1000.0, 1000.0}));
    }

    @Test
    public void whenAddAccountToUserThenGot2Accounts() {
        sberbank.addAccountToUser(SRC_PASSPORT, new Account(0, "another account"));
        String[] result = {
                sberbank.getUserAccounts(SRC_PASSPORT).get(0).getRequisites(),
                sberbank.getUserAccounts(SRC_PASSPORT).get(1).getRequisites()
        };
        assertThat(result, is(new String[] {SRC_ACCOUNT_NO, "another account"}));
    }

    @Test
    public void whenRemoveAccountFromUserThenGotNothingAccounts() {
        sberbank.deleteAccountFromUser(SRC_PASSPORT, new Account(0, SRC_ACCOUNT_NO));
        int result = sberbank.getUserAccounts(SRC_PASSPORT).size();
        assertThat(result, is(0));
    }
}