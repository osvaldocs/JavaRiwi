package model;

import database.ConfigDB;
import database.Crud;
import entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoderModel implements Crud {
    @Override
    public Object insert(Object obj) {
        //Abrir conexion
        Connection objConnection = ConfigDB.openConnection();
        //Convertir objeto abstracto
        Coder objCoder = (Coder) obj;

        try {
            String sql = "INSERT INTO coders (user_name, age, clan) VALUES (?,?,?)";
            //Preparar el statement para ingresar los datos y returngeneratedkeys devuelve el id generado
            PreparedStatement objPrepared = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepared.setString(1, objCoder.getName());
            objPrepared.setInt(2, objCoder.getAge());
            objPrepared.setString(3, objCoder.getClan());

            //Ejecutar el Query
            objPrepared.execute();
            //Obtener resultado con los id generados
            ResultSet objResult = objPrepared.getGeneratedKeys();

            while (objResult.next()) {
                //Aca se inserta el id al objeto coder
                objCoder.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Coder was succesfully added");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCoder;
    }

    @Override
    public List<Object> findAll() {
        List<Object> coderList = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            //Creamos la sentencia sql
            String sql = "SELECT * FROM coders";
            //Usamos el preparedStatement que me perimite  hacer la consulta
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            //Ejecutamos el query  y lo guardamos en una variable
            ResultSet objResult = objPrepared.executeQuery();

            while (objResult.next()) {
                //Crear coder para poder agregar a la lista
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("user_name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));

                coderList.add(objCoder);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();

        return coderList;
    }

    @Override
    public Boolean update(Object obj) {
        return null;
    }

    @Override
    public Boolean delete(Object obj) {
        //Convertir el objeto a Coder
        Coder objCoder = (Coder) obj;

        Connection  objConnection = ConfigDB.openConnection();
        boolean isDeleted = false;
        try {
            String sql = "DELETE FROM coders WHERE id = ?";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            // Paso el id del coder que nos pasaron como parametro para eliminarlo
            objPrepared.setInt(1, objCoder.getId());
            //Obtengo cuantas columnas fueron afectadas
            int result = objPrepared.executeUpdate();
            //Si mas de una columna fue modificada(eliminada) eso significa que fue eliminada
            if(result > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Coder was deleted succesfully");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //Cerrar la conexion
        ConfigDB.closeConnection();
        return isDeleted;

    }

    public Coder findCoderById(int id) {
        Connection objConnection = ConfigDB.openConnection();
        Coder objCoder = new Coder();
        try {
            String sql = "SELECT * FROM coders WHERE id = ?";
            PreparedStatement objPrepared = objConnection.prepareStatement(sql);
            objPrepared.setInt(1, id);
            ResultSet objResult = objPrepared.executeQuery();

            if (objResult.next()) {
                objCoder.setId(objResult.getInt("id"));
                objCoder.setName(objResult.getString("user_name"));
                objCoder.setAge(objResult.getInt("age"));
                objCoder.setClan(objResult.getString("clan"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return objCoder;
    }
}
