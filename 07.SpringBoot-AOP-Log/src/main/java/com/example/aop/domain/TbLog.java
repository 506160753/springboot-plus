package com.example.aop.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author Administrator
 * @since 2019-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * URL
     */
    private String url;

    /**
     * 操作描述
     */
    private String description;

    /**
     * 用户账户
     */
    private String loginName;

    /**
     * 操作时间
     */
    private Date createTime;

    /**
     * 耗时
     */
    private Long spendTime;

    /**
     * IP地址
     */
    private String ip;


}
