package generic.base.strengthen;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 下午6:45 2019/3/21
 */
public class EnumTest {
    public static void main(String[] args) {
        /*WeekDay weekDay = WeekDay.MON;
        System.out.println(weekDay.nextDay());*/

        /*WeekDayEnum weekDay2 = WeekDayEnum.FRI;
        System.out.println(weekDay2);
        System.out.println(weekDay2.name());
        System.out.println(weekDay2.ordinal());
        System.out.println(WeekDayEnum.valueOf("SUN"));
        System.out.println(Arrays.toString(WeekDayEnum.values()));*/

        TrafficLamp trafficLamp = TrafficLamp.GREEN;
        System.out.println(trafficLamp.nextLamp());
        System.out.println(trafficLamp.time);

    }

    public enum WeekDayEnum {
        SUN,MON(2),TUE,WED,THI,FRI,SAT;

        /**
         * 枚举的构造方法必须是private
         */
        private WeekDayEnum() {
            System.out.println("first");
        }

        private WeekDayEnum(int day) {
            System.out.println("second");
        }
    }

    public enum TrafficLamp {
        RED(30){
            @Override
            public TrafficLamp nextLamp() {
                return GREEN;
            }
        },GREEN(40){
            @Override
            public TrafficLamp nextLamp() {
                return YELLOW;
            }
        },YELLOW(5){
            @Override
            public TrafficLamp nextLamp() {
                return RED;
            }
        };

        public abstract TrafficLamp nextLamp();
        public int time;
        private TrafficLamp(int time){
            this.time = time;
        }
    }
}
