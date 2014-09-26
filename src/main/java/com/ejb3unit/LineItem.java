package com.ejb3unit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Test entity bean with method annotations Represents a line item of an order.
 * 
 * @author Daniel Wiese
 * 
 */
@Entity
public class LineItem implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private double subtotal;

    private int quantity;

    private String product;

    private Order order;

    /**
     * The pk.
     * 
     * @return the pk
     */
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     * 
     * @param id -
     *            die id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * The corresponding order.
     * 
     * @return - the order
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order.
     * 
     * @param order -
     *            order
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Returns the product.
     * 
     * @return Returns the product.
     */
    @Column
    public String getProduct() {
        return product;
    }

    /**
     * The product to set.
     * 
     * @param product
     *            The product to set.
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * Returns the quantity.
     * 
     * @return Returns the quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * The quantity to set.
     * 
     * @param quantity
     *            The quantity to set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the subtotal.
     * 
     * @return Returns the subtotal.
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * The subtotal to set.
     * 
     * @param subtotal
     *            The subtotal to set.
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (other != null && other instanceof LineItem) {
            final LineItem otherC = (LineItem) other;
            final EqualsBuilder builder = new EqualsBuilder();
            builder.append(this.subtotal, otherC.subtotal);
            builder.append(this.id, otherC.id);
            builder.append(this.order, otherC.order);
            builder.append(this.product, otherC.product);
            builder.append(this.quantity, otherC.quantity);
            return builder.isEquals();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(this.subtotal);
        builder.append(this.id);
        builder.append(this.order);
        builder.append(this.product);
        builder.append(this.quantity);
        return builder.toHashCode();
    }

}
