package generic.base.strengthen;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午7:08 2019/3/21
 */
public abstract class WeekDay {

    public static final WeekDay SUN = new WeekDay(){
        @Override
        public WeekDay nextDay() {
            return MON;
        }
    };
    public static final WeekDay MON = new WeekDay(){
        @Override
        public WeekDay nextDay() {
            return SUN;
        }
    };

    public abstract WeekDay nextDay();

    /*public WeekDay nextDay() {
        if(this == SUN) {
            return MON;
        } else {
            return SUN;
        }
    }*/

    @Override
    public String toString() {
        return this == SUN?"SUN":"MON";
    }
}
