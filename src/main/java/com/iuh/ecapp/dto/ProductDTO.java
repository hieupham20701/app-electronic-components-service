package com.iuh.ecapp.dto;

import com.iuh.ecapp.model.entity.Brand;
import com.iuh.ecapp.model.entity.Category;
import com.iuh.ecapp.model.entity.Discount;
import java.util.Date;
import java.util.List;

public class ProductDTO {
    private int id;

    private String name;

    private double price;
    private Date createdDate;
    private Date updatedDate;
    private String status;
    private String description;
    private Category category;
    private Brand brand;
    private Discount discount;
    private List<ImageDTO> imageDTOs;
    public ProductDTO() {
    }

    public ProductDTO(int id, String name, double price, Date createdDate, Date updatedDate, String status, String description, Category category, Brand brand, Discount discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.status = status;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public List<ImageDTO> getImageDTOs() {

        return imageDTOs;
    }

    public void setImageDTOs(List<ImageDTO> imageDTOs) {
        this.imageDTOs = imageDTOs;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", brand=" + brand +
                ", discount=" + discount +
                '}';
    }
}
