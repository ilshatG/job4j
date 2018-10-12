package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Banking {
    private Map<User, List<Account>> users = new TreeMap<>();

    public void addUser(User user) {
        users.put(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                users.get(entry.getKey()).add(account);
                break;
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                int index = entry.getValue().indexOf(account);
                if (index != -1) {
                    users.get(entry.getKey()).remove(index);
                    break;
                }
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                result = entry.getValue();
                break;
            }
        }
        return result;
    }

    Account getAccount(String requisite, String passport) {
        List<Account> accounts = getUserAccounts(passport);
        Account result = null;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getRequisites().equals(requisite)) {
                result = accounts.get(i);
                break;
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account src = getAccount(srcRequisite, srcPassport);
        Account dest = getAccount(dstRequisite, destPassport);
        if (src != null && dest != null && src.getValue() >= amount) {
                src.setValue(src.getValue() - amount);
                dest.setValue(dest.getValue() + amount);
                result = true;
        }
        return result;
    }
}
