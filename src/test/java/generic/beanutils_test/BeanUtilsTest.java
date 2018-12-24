package generic.beanutils_test;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 上午1:01 2018/9/9
 */
public class BeanUtilsTest {

    public static <T>T requestToBean(HttpServletRequest request, Class<T> clazz) {
        //创建javaBean对象
        Object obj = null;
        try {
            obj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //得到请求中的每个参数
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            //获得参数名称
            String propertieName = enu.nextElement();
            //获得参数值
            String value = request.getParameter(propertieName);
            //把参数拷贝到javaBean中
            try {
                BeanUtils.setProperty(obj, propertieName, value);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return (T)obj;
    }

    @Test
    public void test1() {
        try {
            Class clazz = Class.forName("com.mytest.pojo.User");
            Object obj = clazz.newInstance();
            //注册一个日期格式转换器
            ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
            //注意： 对于基本数据类型，beanutils工具进行自动类型转换。把String自动转成Integer,Double,Float
            BeanUtils.setProperty(obj, "userName", "fafa");
            BeanUtils.setProperty(obj, "password", "fafdaf");
            BeanUtils.setProperty(obj, "age",12);
            BeanUtils.setProperty(obj, "birthday", "2012-01-02");
            System.out.println("obj: " + obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
