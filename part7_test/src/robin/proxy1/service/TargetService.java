package robin.proxy1.service;

import robin.proxy1.aspect.Transaction;

/**
 * Created by robin on 2017/8/24.
 */
public class TargetService implements IService {
    @Transaction
    @Override
    public void saveObject() {
        //System.out.println("begin transaction");
        System.out.println("save object");
        //System.out.println("commit transaction");
    }

   // @Transaction
    @Override
    public void writeObject() {
        System.out.println("write object ");
    }
}
