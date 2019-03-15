package cn.ltysyn.inmusic.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Entity(name = "t_user")
@Data
@EntityListeners(AuditingEntityListener.class)
@ApiModel(value = "用户类")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2480016720339995032L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,  unique = true, length = 500)
    private String username;

    @Column(length = 500)
    private String password;
    
    @Column(length = 100)
    private String email;
    
    @Column(length = 11)
    private Long phone;
    
    // 用户头像地址
    @Column(length = 100)
 	private String avatar;
    
    @Column
    @CreatedDate
    private Date createTime;
    
    @Column
    @LastModifiedDate
    private Date updateTime;
    
    @Transient
    private String token = "";

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> authorities;

}
