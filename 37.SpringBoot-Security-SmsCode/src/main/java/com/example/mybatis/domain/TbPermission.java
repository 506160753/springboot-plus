package com.example.mybatis.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 权限列表:该表记录所有要加以控制的权限，如录入、修改、删除、执行等，也包括三个字段，ID，名称，描述
 * </p>
 *
 * @author Administrator
 * @since 2019-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 上级权限
     */
    private Long pid;

    /**
     * 描述
     */
    private String permission;


}
