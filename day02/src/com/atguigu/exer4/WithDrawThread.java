package com.atguigu.exer4;

/**共享数据account.getBalance
 * @author xsj
 * @create 2020-09-18 22:38
 */
public class WithDrawThread extends Thread {
    Account account;
    //要取款的额度
    double withDraw;

    public WithDrawThread(String name,Account account, double withDraw) {
        super(name);
        this.account = account;
        this.withDraw = withDraw;
    }

    @Override
    public void run() {
        synchronized (account){

            if(account.getBalance()>withDraw){
                System.out.println(Thread.currentThread().getName() + ":取款成功，取现的金额为：" + withDraw);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance()-withDraw);
            }else{
                System.out.println("取现额度超过账户余额，取款失败");
            }
            System.out.println("现在的账户余额为"+account.getBalance());
        }
    }
}
