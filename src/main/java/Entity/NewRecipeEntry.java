package Entity;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;






/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author c0641046
 */

public class NewRecipeEntry implements Serializable {
    

    private int id;
    private String email;
    private String author;
    private String category;
    private String recipeName;
    private String ingredients;
    private String steps;
   private Date dateCreated;
   
   
   /**
    * 
    * @param id
    * @param email
    * @param author
    * @param category
    * @param recipeName
    * @param ingredients
    * @param steps
    * @param dateCreated 
    */
    public NewRecipeEntry(int id, String email, String author, String category, String recipeName, String ingredients, String steps, Date dateCreated) {
        this.id = id;
        this.email = email;
        this.author = author;
        this.category = category;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.steps = steps;
        this.dateCreated = dateCreated;
    }

    /**
     * Empty construction for NewRecipeEntry
     */
    public NewRecipeEntry() {
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
    public String getIngredients() {
        return ingredients;
    }

    
    /**
     * 
     * @param ingredients 
     */
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    
    /**
     * 
     * @return step
     */
    public String getSteps() {
        return steps;
    }

    
    /**
     * 
     * @param steps
     */
    public void setSteps(String steps) {
        this.steps = steps;
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
