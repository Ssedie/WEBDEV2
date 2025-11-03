package org.midterm.zed.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StoreDTO{

        @NotBlank(message = "Name is Required")
        private String name;

        @NotBlank(message = "Description is Required")
         private String description;

        @Min(1)
        private int stock;

        @NotBlank(message = "Unit is Required")
        private String unit;

        @NotBlank(message = "Price is Needed")
        @Min(1)
        private double price;

        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public String getDescription() {
                return description;
        }
        public void setDescription(String description) {
                this.description = description;
        }
        public int getStock() {
                return stock;
        }
        public void setStock(int stock) {
                this.stock = stock;
        }
        public String getUnit() {
                return unit;
        }
        public void setUnit(String unit) {
                this.unit = unit;
        }
        public double getPrice() {
                return price;

        }
        public void setPrice(double price) {
                this.price = price;
        }
}
