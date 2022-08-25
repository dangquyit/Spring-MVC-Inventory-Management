package com.junior.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product_info database table.
 * 
 */
@Entity
@Table(name="product_info")
@NamedQuery(name="ProductInfo.findAll", query="SELECT p FROM ProductInfo p")
public class ProductInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="active_flag")
	private int activeFlag;

	private String code;

	@Column(name="create_date")
	private Timestamp createDate;

	@Lob
	private String description;

	@Column(name="img_url")
	private String imgUrl;

	private String name;

	@Column(name="update_date")
	private Timestamp updateDate;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="productInfo")
	private List<History> histories;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="productInfo")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to ProductInStock
	@OneToMany(mappedBy="productInfo")
	private List<ProductInStock> productInStocks;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;

	public ProductInfo() {
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setProductInfo(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setProductInfo(null);

		return history;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setProductInfo(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setProductInfo(null);

		return invoice;
	}

	public List<ProductInStock> getProductInStocks() {
		return this.productInStocks;
	}

	public void setProductInStocks(List<ProductInStock> productInStocks) {
		this.productInStocks = productInStocks;
	}

	public ProductInStock addProductInStock(ProductInStock productInStock) {
		getProductInStocks().add(productInStock);
		productInStock.setProductInfo(this);

		return productInStock;
	}

	public ProductInStock removeProductInStock(ProductInStock productInStock) {
		getProductInStocks().remove(productInStock);
		productInStock.setProductInfo(null);

		return productInStock;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}