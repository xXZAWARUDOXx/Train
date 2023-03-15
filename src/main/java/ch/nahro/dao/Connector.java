package ch.nahro.dao;

import ch.nahro.model.Stop;
import ch.nahro.model.TrainLine;
import ch.nahro.model.TrainType;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Connector {

    private static Connector instance;
    private SessionFactory sessionFactory;
    private final Configuration configuration;

    private Connector() {
        this.configuration = new Configuration();
    }

    public static Connector getInstance() {
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

    public void setConfiguration() {
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/train");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "1234");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.addAnnotatedClass(Stop.class);
        configuration.addAnnotatedClass(TrainLine.class);
        configuration.addAnnotatedClass(TrainType.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void closeConnection() {
        this.sessionFactory.close();
    }
}