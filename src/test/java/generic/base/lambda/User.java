package generic.base.lambda;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: zouyongqi
 * @Description:
 * @Date: Created in 22:40 2019-08-02
 */
public class User {
    private Long id;

    private String name;

    private Integer age;

    private String sex;

    private String jobNumber;
    /** 入职日期 */
    private Date entryDate;

    /** 家庭成员数量 */
    private BigDecimal familyMemberQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public BigDecimal getFamilyMemberQuantity() {
        return familyMemberQuantity;
    }

    public void setFamilyMemberQuantity(BigDecimal familyMemberQuantity) {
        this.familyMemberQuantity = familyMemberQuantity;
    }
}
