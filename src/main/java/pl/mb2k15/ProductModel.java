/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mb2k15;

import javax.persistence.*;


/**
 * @author Matt
 */
@Table(name = "produkty")
@Entity
public class ProductModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String category;

    private float price;

    private int number;

    private String file;

    public ProductModel(){

    }

    public ProductModel(final Builder builder) {
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.number = builder.number;
        this.file = builder.file;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public static class Builder{

        private Integer id;

        private String name;

        private String category;

        private float price;

        private int number;

        private String file;


        public Builder(final String name){
            this.name = name;
        }

        public Builder category(final String category){
            this.category = category;
            return this;
        }
        public Builder price(final float price){
            this.price = price;
            return this;
        }
        public Builder number(final int number){
            this.number = number;
            return this;
        }
        public Builder file(final String file){
            this.file = file;
            return this;
        }

        ProductModel build(){
            return new ProductModel(this);
        }
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", file='" + file + '\'' +
                '}';
    }


}
