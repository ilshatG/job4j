package servlets.EchoServlets;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.xml.transform.Source;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

public class DBStore implements Store, AutoCloseable {
        private static final BasicDataSource SOURCE = new BasicDataSource();
        private static DBStore INSTANCE = new DBStore();
        private static final String TABLE = "users";

        private DBStore() {
            Properties config = new Properties();
            try (InputStream in = DBStore.class.getClassLoader().getResourceAsStream("app.properties")) {
                config.load(in);
                SOURCE.setUrl(config.getProperty("url"));
                SOURCE.setUsername(config.getProperty("username"));
                SOURCE.setPassword(config.getProperty("password"));
                SOURCE.setDriverClassName(config.getProperty("driver-class-name"));
                SOURCE.setMinIdle(25);
                SOURCE.setMaxIdle(30);
                SOURCE.setMaxOpenPreparedStatements(200);

                if (!isTableExist()) {
                    createTable();
                }

            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        public static DBStore getInstance() {
            return INSTANCE;
        }

        @Override
        public void add(User user) {
            try (Connection connection = SOURCE.getConnection();
                 PreparedStatement ps = connection.prepareStatement("INSERT INTO " + TABLE + " (name, login, email, createDate) VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)
            ) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getLogin());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getCreateDate());
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        @Override
        public void update(User user) {
            try (PreparedStatement ps = SOURCE.getConnection().prepareStatement("UPDATE " + TABLE + " SET name = ?, " +
                    "login = ?, email = ?, createDate = ? where id = ?")) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getLogin());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getCreateDate());
                ps.setInt(5, user.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void delete(User user) {
            try (PreparedStatement ps = SOURCE.getConnection().prepareStatement("DELETE FROM " + TABLE + " WHERE ID = ?")) {
                ps.setInt(1, user.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return;
        }

        @Override
        public List<User> findAll(User model) {
            return null;
        }

        @Override
        public User findById(User model) {
            return null;
        }

        @Override
        public List<User> getAll() {
            List result = new CopyOnWriteArrayList();
            try (PreparedStatement ps = SOURCE.getConnection().prepareStatement("SELECT * FROM " + TABLE)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"),
                            rs.getString("email"), rs.getString("createDate"));
                    result.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

        private boolean isTableExist() {
            boolean result = false;
            try {
                DatabaseMetaData md = SOURCE.getConnection().getMetaData();
                ResultSet rs = md.getTables(null, null, TABLE, null);
                result = rs.next();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

        private boolean createTable() {
            boolean result = false;
            try (PreparedStatement ps = SOURCE.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS " + TABLE
                    + " (id SERIAL PRIMARY KEY, name varchar(225), login varchar(225), email varchar(225), createDate varchar(225))")
            ) {
                ps.executeUpdate();
                result = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

    @Override
    public void close() throws Exception {
        SOURCE.close();
    }
}

