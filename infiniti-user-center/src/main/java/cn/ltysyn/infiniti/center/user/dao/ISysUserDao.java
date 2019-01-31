package cn.ltysyn.infiniti.center.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.ltysyn.infiniti.common.model.SysUser;

public interface ISysUserDao extends JpaRepository<SysUser, Long> {

}
