package com.junior.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the auth database table.
 * 
 */
@Entity
@NamedQuery(name = "Auth.findAll", query = "SELECT a FROM Auth a")
public class Auth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "active_flag")
	private int activeFlag;

	@Column(name = "create_date")
	private Timestamp createDate;

	@Column(name = "permisstion")
	private int permisstion;

	@Column(name = "update_date")
	private Timestamp updateDate;

	// bi-directional many-to-one association to Menu
//	@ManyToOne(fetch=FetchType.LAZY)
	@ManyToOne(fetch = FetchType.EAGER)
	private Menu menu;

	// bi-directional many-to-one association to Role
	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;

	public Auth() {
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

	public int getPermisstion() {
		return permisstion;
	}

	public void setPermisstion(int permisstion) {
		this.permisstion = permisstion;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}