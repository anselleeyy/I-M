package cn.ltysyn.inmusic.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "t_role")
@Data
public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7304251194885107504L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
