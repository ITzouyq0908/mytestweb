package generic.jvm.test1;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zouyongqi
 * @Description: 模拟类加载溢出（元空间oom）
 * @Date: Created in 上午11:07 2018/11/30
 */
public class OOMTest {
    public static void main(String[] args) {

        try {
            //准备url
            URL url = new File("/Users/zouyongqi/IdeaProjects/mytestweb/src/test1/java/generic/jvm/test1").toURI().toURL();
            URL[] urls = {url};
            //获取有关类型加载的JMX接口
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器
            List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
            while (true) {
                //加载类型并缓存类加载器实例
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("generic.jvm.test1.OOMTest");
                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
                System.out.println("total:" + loadingBean.getTotalLoadedClassCount());
                System.out.println("active:" + loadingBean.getLoadedClassCount());
                System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
