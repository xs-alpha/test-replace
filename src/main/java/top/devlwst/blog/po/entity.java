package top.devlwst.blog.po;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaosheng
 * @date Created at 2023/2/26
 */
public class entity {
    /**
     * id
     */
    private Long recordId;

    /**
     * 钱数
     */
    private BigDecimal money;

    /**
     * 天数
     */
    private Integer dayNum;

    private String phone;

    /**
     * 备注
     */
    private String reMark;

    /**
     * 押金
     */
    private BigDecimal deposit;

    /**
     * 延期天数
     */
    private Integer delayDays;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 缴费日期
     */
    private Date paymentDate;

    /**
     * 计划还款日期
     */
    private Date planRetDate;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 是否完成
     */
    private Integer isFinish;

    /**
     * 是否赊账
     */
    private Integer isDebt;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;
}
