package controller;

import entity.Coder;
import model.CoderModel;

import javax.swing.*;

public class CoderController {
    public static void create() {
        //Usamos el modelo
        CoderModel objCoderModel = new CoderModel();

        String name = JOptionPane.showInputDialog(null, "Please enter a name");
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter an age"));
        String clan = JOptionPane.showInputDialog(null, "Enter a clan");

        Coder objCoder = new Coder();
        objCoder.setName(name);
        objCoder.setAge(age);
        objCoder.setClan(clan);

        //Llamando
        objCoder = (Coder) objCoderModel.insert(objCoder);

        JOptionPane.showMessageDialog(null, objCoder.toString());
    }

    public static void getAllUsers() {
        CoderModel coderModel = new CoderModel();
        String coderList = "Coders List";
        for (Object i : coderModel.findAll()) {
            Coder objCoder = (Coder) i;
            coderList += objCoder.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, coderList);
    }

    public static void delete() {
        CoderModel coderModel = new CoderModel();

        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the coder id"));
        Coder objCoder = coderModel.findCoderById(idDelete);
        if (objCoder == null) {
            JOptionPane.showMessageDialog(null, "Coder not found");
        }else {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?");
            if (confirm == 0) coderModel.delete(objCoder);
        }
    }
}
