package ca.vanier.recipeideas.entities;

import java.util.List;

public class Recipe {

    private Long id;
    private String[] keywords;
    private String description;
    private String[] ingredients;
    private List<Procedure> procedures;

    public Recipe(Long id, String[] keywords, String description, String[] ingredients, List<Procedure> procedures) {
        this.id = id;
        this.keywords = keywords;
        this.description = description;
        this.ingredients = ingredients;
        this.procedures = procedures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }
    
    
    
}
