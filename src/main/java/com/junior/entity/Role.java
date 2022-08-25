package com.junior.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="active_flag")
	private int activeFlag;

	@Column(name="create_date")
	private Timestamp createDate;

	private String description;

	@Column(name="role_name")
	private String roleName;

	@Column(name="update_date")
	private Timestamp updateDate;

	//bi-directional many-to-one association to Auth
//	@OneToMany(mappedBy="role")
	@OneToMany(mappedBy="role", fetch = FetchType.EAGER)
	private List<Auth> auths;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userRoles;

	public Role() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActiveFlag() {
		return this.activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public List<Auth> getAuths() {
		return this.auths;
	}

	public void setAuths(List<Auth> auths) {
		this.auths = auths;
	}

	public Auth addAuth(Auth auth) {
		getAuths().add(auth);
		auth.setRole(this);

		return auth;
	}

	public Auth removeAuth(Auth auth) {
		getAuths().remove(auth);
		auth.setRole(null);

		return auth;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRole(null);

		return userRole;
	}

}