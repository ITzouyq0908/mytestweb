package generic.base.strengthen;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 22:53 2019-07-19
 */
public class ReflectTest {

    public String str1 = "ball";
    public String str2 = "basketball";
    public String str3 = "field";

    public static void main(String[] args) throws Exception{
        ReflectTest pt1 = new ReflectTest();
        pt1.changeValue(pt1);
        System.out.println(pt1);
    }

    public void changeValue(Object obj) throws Exception{
        Field[] fields = obj.getClass().getFields();
        for (Field field : fields) {
            Type type = field.getType();
            if(type == String.class) {
                String oldValue = (String)field.get(obj);
                String newValue = oldValue.replace("b","a");
                field.set(obj, newValue);
            }
        }
    }

    @Override
    public String toString() {
        return str1 + " : " + str2 + " : " + str3;
    }
}
