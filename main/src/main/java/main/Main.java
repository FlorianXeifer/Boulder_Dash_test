package main;

import java.sql.SQLException;

import controller.Controller;
import model.Model;
import view.View;


public abstract class Main {

    
    public static void main(final String[] args) {
        final Controller controller = new Controller(new View(), new Model());

    }

}
