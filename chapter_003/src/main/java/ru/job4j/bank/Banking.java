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

    int getAccountIndex(String requisite, String passport) {
        List<Account> srcAccounts = getUserAccounts(passport);
        int index = -1;
        for (int i = 0; i < srcAccounts.size(); i++) {
            if (srcAccounts.get(i).getRequisites().equals(requisite)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        int srcIndex = getAccountIndex(srcRequisite, srcPassport);
        int destIndex = getAccountIndex(dstRequisite, destPassport);
        if (srcIndex != -1 && destIndex != -1) {
            Account srcAccaunt = getUserAccounts(srcPassport).get(srcIndex);
            Account destAccaunt = getUserAccounts(destPassport).get(destIndex);
            if (srcAccaunt.getValue() >= amount) {
                srcAccaunt.setValue(srcAccaunt.getValue() - amount);
                destAccaunt.setValue(destAccaunt.getValue() + amount);
            }
        }
        return result;
    }
}
