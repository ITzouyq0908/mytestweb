package generic.base.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 22:48 2019-08-02
 */
public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest.groupingByTest();
    }

    public static void groupingByTest() {
        List<User> userList = LambdaTest.getUserList();
        //分组
        Map<String, List<User>> groupBySex =
                userList.stream().collect(Collectors.groupingBy(User::getSex));
        //遍历分组
        for (Map.Entry<String, List<User>> entryUser : groupBySex.entrySet()) {
            String key = entryUser.getKey();
            List<User> entryUserList = entryUser.getValue();
        }
    }

    public static List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setAge(23);
        user.setEntryDate(new Date());
        user.setFamilyMemberQuantity(new BigDecimal(3));
        user.setId(1L);
        user.setName("abc");
        user.setJobNumber("11111");
        user.setSex("男");
        userList.add(user);
        User user2 = new User();
        user2.setAge(32);
        user2.setEntryDate(new Date());
        user2.setFamilyMemberQuantity(new BigDecimal(4));
        user2.setId(2L);
        user2.setName("dev");
        user2.setJobNumber("22222");
        user2.setSex("女");
        userList.add(user2);
        User user3 = new User();
        user3.setAge(24);
        user3.setEntryDate(new Date());
        user3.setFamilyMemberQuantity(new BigDecimal(5));
        user3.setId(3L);
        user3.setName("ade");
        user3.setJobNumber("33333");
        user3.setSex("男");
        userList.add(user3);
        return userList;
    }
}
