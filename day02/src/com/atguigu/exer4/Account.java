package com.atguigu.exer4;

/**1.定义一个Account类
 1）该Account类封装了账户编号（String）和余额（double）两个属性
 2）设置相应属性的getter和setter方法
 3）提供无参和有两个参数的构造器
 4）系统根据账号判断与用户是否匹配，需提供hashCode()和equals()方法的重写
 * @author xsj
 * @create 2020-09-18 22:35
 */
public class Account {
    private String accountId;
    private double balance;

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                '}';
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountId == null) ? 0 :
                accountId.hashCode());
        long temp;
        temp = Double.doubleToLongBits(balance);
        result = prime * result + (int) (temp ^ (temp >>>
                32));
        return result;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;
        if (Double.doubleToLongBits(balance) !=
                Double.doubleToLongBits(other.balance))
            return false;
        return true;
    }

    public Account() {
    }

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
