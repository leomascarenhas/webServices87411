package ca.vanier.recipeideas.entities;

public class Procedure {
    
    private Long id;
    private String description;
    private String instructions;

    public Procedure(Long id, String description, String instructions) {
        this.id = id;
        this.description = description;
        this.instructions = instructions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
}
