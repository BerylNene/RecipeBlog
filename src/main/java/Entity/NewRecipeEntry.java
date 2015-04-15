package Entity;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0641046
 */
@Entity
public class NewRecipeEntry {
    
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String author;
    private String category;
    private String recipeName;
    
   @Lob
    private String ingredient;
   private String step;
   
   
   private Date dateCreated;
   
   
   @PrePersist
   private void onCreate() {
       dateCreated = new Date();
   }

   /**
    * 
    * @return the id
    */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /**
     * 
     * @return email
     */
    public String getEmail() {
        return email;
    }

    
    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /**
     * 
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    
    /**
     * 
     * @param author 
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    
    /**
     * 
     * @return recipeName
     */
    public String getRecipeName() {
        return recipeName;
    }

    
    /**
     * 
     * @param recipeName 
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    
    /**
     * 
     * @return ingredient
     */
    public String getIngredient() {
        return ingredient;
    }

    
    /**
     * 
     * @param ingredient 
     */
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    
    /**
     * 
     * @return step
     */
    public String getStep() {
        return step;
    }

    
    /**
     * 
     * @param step 
     */
    public void setStep(String step) {
        this.step = step;
    }

    
    /**
     * 
     * @return dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    
    /**
     * 
     * @param dateCreated 
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    
    /**
     * 
     * @return category
     */
    public String getCategory() {
        return category;
    }

    
    /**
     * 
     * @param category 
     */
    public void setCategory(String category) {
        this.category = category;
    }
   
   
   
}
