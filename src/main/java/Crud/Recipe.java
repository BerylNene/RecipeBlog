/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Crud;
import credentials.database;
import static credentials.database.getConnection;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 *
 * @author Beryl Bawo Nene (c0641046)
 */
@Path("/recipe")
public class Recipe {
    
    /**
     * 
     * @return result
     */
    @GET
    @Produces("application/json")
    public String doGet() {
        String result = getResult("SELECT * FROM newrecipeentry ");
        return result;
    }

    /**
     * doGet takes a string parameter and passes it to all newrecipeentry table
     *returns result which store all data into the result variable
     *
     * @param id
     * @return result
     */
    @GET
    @Path("{id}")
    @Produces("application/json")
    public String doGet(@PathParam("id") String id) {
        String result = getResult("SELECT * FROM newrecipeentry where id=?", id);
        return result;
    }

    /**
     * doPost Method takes a string parameter and passes 
     * which then pass values into the newrecipeentry table
     *
     * @param input
     */
    @POST
    @Consumes("application/json")
    public void doPost(String input) {
        JsonParser jsonParser = Json.createParser(new StringReader(input));
        Map<String, String> map = new HashMap<>();
        String key = "", value;
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
            switch (event) {
                case KEY_NAME:
                    key = jsonParser.getString();
                    break;
                case VALUE_STRING:
                    value = jsonParser.getString();
                    map.put(key, value);
                    break;
                case VALUE_NUMBER:
                    value = Integer.toString(jsonParser.getInt());
                    map.put(key, value);
                    break;
            }
        }
        
        System.out.println(map);
        String email = map.get("email");
        String author = map.get("author");
        String category = map.get("category");
        String recipeName = map.get("recipeName");
        String ingredient = map.get("ingredient");
        String step = map.get("step");
        String dateCreated = map.get("dateCreated");
       
        doUpdate("INSERT INTO newrecipeentry (email,author,category,recipeName,ingredient,step,dateCreated) "
                + "VALUES (?, ?, ?,?,?,?,?)", email, author, category, recipeName, ingredient, step, dateCreated );
    }

    /**
     * doPut Method takes a string parameter and passes 
     * which then pass values into the newrecipeentry table
     * to put on the table
     * @param id
     * @param input
     */
    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public void doPut(@PathParam("id") String id, String input) {
        JsonParser jsonParser = Json.createParser(new StringReader(input));
        Map<String, String> map = new HashMap<>();
        String key = "", value;
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
            switch (event) {
                case KEY_NAME:
                    key = jsonParser.getString();
                    break;
                case VALUE_STRING:
                    value = jsonParser.getString();
                    map.put(key, value);
                    break;
                case VALUE_NUMBER:
                    value = Integer.toString(jsonParser.getInt());
                    map.put(key, value);
                    break;
            }
        }
        System.out.println(map);
        String idRe = map.get("id");
        String ingredient = map.get("ingredient");
        String step = map.get("step");
        String dateCreated = map.get("dateCreated");
        
        doUpdate("update newrecipeentry set id=?, ingredient = ? , step = ?, dateCreated = ? where id = ?",
               idRe,ingredient, step, dateCreated, id);
    }

    /**
     * doDelete Method takes a string parameter and passes 
     * which then pass values into the newrecipeentry table
     * to delete an id entry from the newrecipeentry table
     *
     * @param id
     * @param input
     */
    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    public void doDelete(@PathParam("id") String id, String input) {
        doUpdate("DELETE FROM `newrecipeentry` WHERE `id`=?", id);
    }

    /**
     *
     * @param query
     * @param params
     * @throws SQLException
     * @return
     */
    private String getResult(String query, String... params) {
        String stringResult;
        JsonArrayBuilder jsonArray = Json.createArrayBuilder();
        try (Connection conn = database.getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 1; i <= params.length; i++) {
                pstmt.setString(i, params[i - 1]);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JsonObject json = Json.createObjectBuilder()
                        .add("id", rs.getInt("id"))
                        .add("email", rs.getString("email"))
                        .add("author", rs.getString("author"))
                        .add("category", rs.getString("category"))
                        .add("recipeName", rs.getString("recipeName"))
                        .add("ingredient", rs.getString("ingredient"))
                        .add("step", rs.getString("step"))
                        .add("dateCreated", rs.getString("dateCreated")).build();
                jsonArray.add(json);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        stringResult = jsonArray.build().toString();
        return stringResult;
    }

    /**
     * doUpdate updates the newrecipeentry table
     *
     * @param query
     * @param params
     * @return numChanges
     */
    private int doUpdate(String query, String... params) {
        int numChanges = 0;
        try (Connection conn = getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 1; i <= params.length; i++) {
                pstmt.setString(i, params[i - 1]);
            }
            numChanges = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return numChanges;
    }
}