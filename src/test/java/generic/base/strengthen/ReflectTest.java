package generic.base.strengthen;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        /*pt1.changeValue1(pt1);
        System.out.println(pt1);*/

//        pt1.getFieldValue();
//        pt1.methodInvoke();

//        String startMethodName = args[0];
//        pt1.invokeTargetArgumentsMain(startMethodName);

        pt1.arrayReflect();


    }

    public void changeValue1(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            Class type = field.getType();
            if(type == String.class) {
                String oldValue = (String)field.get(obj);
                String newValue = oldValue.replace('b', 'a');
                field.set(obj, newValue);
            }
        }
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

    public void getFieldValue() throws Exception{
        ReflectPoint point = new ReflectPoint(3, 5);
        Field fieldX = ReflectPoint.class.getDeclaredField("x");
        fieldX.setAccessible(true);
        System.out.println(fieldX.get(point));
    }

    public void methodInvoke() throws Exception {
        String str = "abc";
        Method charAtMethod = String.class.getMethod("charAt", int.class);
        //如果invoke的第一个参数为null,则该方法为静态方法,第二个参数为该方法的参数
        System.out.println(charAtMethod.invoke(str, 1));
        //jdk1.4语法，jdk1.4不支持可变参数
        System.out.println(charAtMethod.invoke(str, new Object[]{2}));
    }

    /**
     * 反射调用类中的main方法
     */
    public void invokeTargetArgumentsMain(String startingMethodName) throws Exception {

       Method method = Class.forName(startingMethodName).getMethod("main", String[].class);
       //下面的调用会报错，参数个数不对，原因是jdk1.5以后，会把该String数组进行拆包，进而会有
        //三个参数，而main方法只接收一个参数
        //解决方法有下面两种，第一种：将该参数再进行一次数组包装，包装后jdk拆包后还是一个参数，类型为字符串数组
        //第二种：将该数组强制转换为Object对象，即该数组为一个对象，也就是一个参数
//       method.invoke(null, new String[]{"111","222","333"});
       method.invoke(null, new Object[]{new String[]{"111","222","333"}});
       method.invoke(null, (Object)new String[]{"111","222","333"});

    }

    /**
     * 数组反射
     */
    public void arrayReflect() throws Exception {
        int[] a1 = new int[3];
        int[] a2 = new int[4];
        int[][] a3 = new int[2][3];
        String[] a4 = new String[3];
        System.out.println(a1.getClass() == a2.getClass());
        /*System.out.println(a1.getClass() == a3.getClass());
        System.out.println(a1.getClass() == a4.getClass());*/
    }

    @Override
    public String toString() {
        return str1 + " : " + str2 + " : " + str3;
    }
}

class TargetArguments {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}