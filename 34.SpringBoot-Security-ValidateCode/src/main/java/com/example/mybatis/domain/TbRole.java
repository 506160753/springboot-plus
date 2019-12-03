package com.example.mybatis.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色表：包括三个字段，ID，角色名，对该角色的描述
 * </p>
 *
 * @author Administrator
 * @since 2019-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色代码
     */
    private String code;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;


}
