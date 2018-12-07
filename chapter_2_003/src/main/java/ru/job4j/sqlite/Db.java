package ru.job4j.sqlite;


import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Db {
    private Connection connection;

    public List<Value> getList() {
        return list;
    }

    private List<Value> list;
    private static final String TABLE = "entry";
    Db() {
        Config cfg = new Config();
        cfg.init();
        try  {
            connection = DriverManager.getConnection(cfg.get("url"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (!isTableExist()) {
            createTable();
        }
        clearTable();
        generate(10);
    }

    public static void main(String[] args) {
        Db db = new Db();
        db.createList();
        Values values = new Values(db.getList());
        StoreXML sx = new StoreXML(new File("C:\\sqlite\\db\\values.xml"));
        sx.save(values);
        ConvertXSQT convert = new ConvertXSQT();
        convert.convert(new File("C:\\sqlite\\db\\values.xml"), new File("C:\\sqlite\\db\\dest.xml"), new File("C:\\sqlite\\db\\schema.scm"));
    }

    public void generate(int n) {
        for (int i = 0; i < n; i++) {
            add(i);
        }
        return;
    }

    public void add(int value) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO " + TABLE + " (value) VALUES(?)")) {
            ps.setInt(1, value);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearTable() {
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM " + TABLE)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private boolean isTableExist() {
        boolean result = false;
        try {
            DatabaseMetaData md = connection.getMetaData();
            ResultSet rs = md.getTables(null, null, TABLE, null);
            result = rs.next();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void createList() {
        this.list = new ArrayList();
        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + TABLE)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Value value = new Value(rs.getInt("value"));
                list.add(value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean createTable() {
        boolean result = false;
        try (PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS " + TABLE + " (value INTEGER)")) {
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}