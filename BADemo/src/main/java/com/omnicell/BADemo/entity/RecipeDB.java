package com.omnicell.BADemo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="recipe", uniqueConstraints = @UniqueConstraint(columnNames="id"))
public class RecipeDB {
	@Id
	@NotNull
	@Column(name="id", unique=true, nullable=false)
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name="name", nullable=false)
	private String name;
	
	@NotNull
	@Column(name="image", nullable=false)
	private String image;
	
	@NotNull
	@Column(name="category", nullable=false)
	private String category;
	
	@NotNull
	@Column(name="label", nullable=true)
	private String label;
	
	@NotNull
	@Column(name="price", nullable=false)
	private String price;
	
	@NotNull
	@Column(name="description", nullable=false)
	private String description;
	
	
	
	public RecipeDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipeDB(@NotNull long id, @NotNull String name, @NotNull String image, @NotNull String category,
			@NotNull String label, @NotNull String price, @NotNull String description) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.category = category;
		this.label = label;
		this.price = price;
		this.description = description;
	}

	public RecipeDB(@NotNull String name, @NotNull String image, @NotNull String category,
			@NotNull String label, @NotNull String price, @NotNull String description) {
		super();
		this.name = name;
		this.image = image;
		this.category = category;
		this.label = label;
		this.price = price;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RecipeDB [id=" + id + ", name=" + name + ", image=" + image + ", category=" + category + ", label="
				+ label + ", price=" + price + ", description=" + description + "]";
	}
	
}
