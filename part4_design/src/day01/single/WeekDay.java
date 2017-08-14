package day01.single;

/**
 * Created by robin on 2017/8/14.
 */
public enum WeekDay {
    FIR(){
        @Override
        public WeekDay nextday() {
            return SEC;
        }
    },SEC(){
        @Override
        public WeekDay nextday() {
            return THREE;
        }
    }
    ,THREE(){
        @Override
        public WeekDay nextday() {
            return FIR;
        }
    };
    public abstract WeekDay nextday();
}
