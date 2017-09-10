package com.imloves.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wujianchuan
 * 2017/8/19 22:02
 */
@Entity
@Data
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
public class SysRole implements Serializable {

    private static final long serialVersionUID = -4241953971764840993L;

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}
