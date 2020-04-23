/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mykitchengarden.mykicthengarden.Views;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

/**
 *
 * @author Team PlantLet
 */
public class Plant {
    Image image;
    String name;
    
    public Plant(String name, Image image) {
      this.name = name;
      this.image = image;
    };
    
    public String getName() {
      return name;
    }

    public void setName(String name) {
       this.name = name;
    }
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
