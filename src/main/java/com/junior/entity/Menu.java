package com.junior.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "active_flag")
	private int activeFlag;

	@Column(name = "create_date")
	private Timestamp createDate;

	private String name;

	@Column(name = "order_index")
	private int orderIndex;

	@Column(name = "parent_id")
	private int parentId;

	@Column(name = "update_date")
	private Timestamp updateDate;

	private String url;

	// bi-directional many-to-one association to Auth
	@OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
	private List<Auth> auths;

	@Transient // Annotation disable
	private List<Menu> child;

	@Transient
	private String idMenu;
	
	@Transient
	private Map<Integer, Integer> mapAuth;
	

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderIndex() {
		return this.orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Auth> getAuths() {
		return this.auths;
	}

	public void setAuths(List<Auth> auths) {
		this.auths = auths;
	}

	public Auth addAuth(Auth auth) {
		getAuths().add(auth);
		auth.setMenu(this);

		return auth;
	}

	public Auth removeAuth(Auth auth) {
		getAuths().remove(auth);
		auth.setMenu(null);

		return auth;
	}

	public List<Menu> getChild() {
		return child;
	}

	public void setChild(List<Menu> child) {
		this.child = child;
	}

	public String getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public Map<Integer, Integer> getMapAuth() {
		return mapAuth;
	}

	public void setMapAuth(Map<Integer, Integer> mapAuth) {
		this.mapAuth = mapAuth;
	}
	
	

}